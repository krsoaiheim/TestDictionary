package com.test.testworkpad.presenter;

import android.support.annotation.NonNull;

import com.test.testworkpad.Constants;
import com.test.testworkpad.model.AddWordModel;
import com.test.testworkpad.model.ApiService;
import com.test.testworkpad.model.TranslateResp;
import com.test.testworkpad.model.database.Word;
import com.test.testworkpad.view.IAddWord;

import org.greenrobot.greendao.async.AsyncOperation;
import org.greenrobot.greendao.async.AsyncOperationListener;
import org.greenrobot.greendao.async.AsyncSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddWordPresenter implements AsyncOperationListener {
  private static final String API_KEY = "trnsl.1.1.20180809T175035Z"+
        ".bb1bc525686f1e29.2bf8c194badfaf67b6621cb4895d68edf73c5e46";
  private final ApiService service;
  private String traslation;
  private String word;
  private Integer fromLan;
  private Integer toLan;
  private IAddWord view;
  private AddWordModel model;
  private Call<TranslateResp> call;


  public AddWordPresenter(IAddWord view, AddWordModel model) {
    this.view = view;
    this.model = model;
    service = model.getService();
  }


  public void translate(final String word, final Integer fromLan, final Integer toLan) {
    destroyCall();
    String lang = getLang(fromLan, toLan);
    call = service.translate(API_KEY, word, lang);
    call.enqueue(new Callback<TranslateResp>() {
      @Override
      public void onResponse(@NonNull Call<TranslateResp> call, @NonNull Response<TranslateResp>
            response) {
        if (response.code() == 200) {
          TranslateResp resp = response.body();
          if (resp != null && resp.getCode() == 200) {
            view.setWord(resp);
            setWord(word.toLowerCase(), resp.getText().toLowerCase(), fromLan, toLan);
          } else {
            view.showError();
          }
        } else {
          view.showError();
        }
      }


      @Override
      public void onFailure(@NonNull Call<TranslateResp> call, @NonNull Throwable t) {
        view.showError();
      }
    });
  }


  private void setWord(String word, String text, Integer fromLan, Integer toLan) {
    this.word = word;
    this.traslation = text;
    this.fromLan = fromLan;
    this.toLan = toLan;
  }


  private String getLang(Integer fromLan, Integer toLan) {
    return Constants.LANG_ARR[fromLan]+"-"+Constants.LANG_ARR[toLan];
  }


  public void destroyCall() {
    if (call != null && call.isExecuted()) {
      call.cancel();
    }
  }


  public void save() {
    Word wordObj = new Word();
    wordObj.setId(null);
    wordObj.setFromWord(word);
    wordObj.setToWord(traslation);
    wordObj.setFromLang(fromLan);
    wordObj.setToLang(toLan);
    AsyncSession asyncSession = model.getSession().startAsyncSession();
    asyncSession.setListenerMainThread(this);
    model.saveAsyncSession(asyncSession, wordObj);
  }


  @Override
  public void onAsyncOperationCompleted(AsyncOperation operation) {
    view.notifyWordSaved();
  }
}
