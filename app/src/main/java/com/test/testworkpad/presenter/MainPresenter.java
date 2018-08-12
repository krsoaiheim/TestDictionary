package com.test.testworkpad.presenter;

import com.test.testworkpad.model.MainModel;
import com.test.testworkpad.model.database.Word;
import com.test.testworkpad.view.IMain;

import org.greenrobot.greendao.async.AsyncOperation;
import org.greenrobot.greendao.async.AsyncOperationListener;
import org.greenrobot.greendao.async.AsyncSession;

import java.util.List;

public class MainPresenter implements AsyncOperationListener {
  private final MainModel model;
  private final IMain view;


  public MainPresenter(IMain view, MainModel model) {
    this.view = view;
    this.model = model;
  }


  public void getWords() {
    AsyncSession asyncSession = model.getSession().startAsyncSession();
    asyncSession.setListenerMainThread(this);
    model.loadAsyncSession(asyncSession);
  }


  @Override
  public void onAsyncOperationCompleted(AsyncOperation operation) {
    List<Word> list = (List<Word>) operation.getResult();
    view.setList(list);
  }
}
