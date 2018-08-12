package com.test.testworkpad.presenter;

import com.test.testworkpad.model.SearchModel;
import com.test.testworkpad.model.database.Word;
import com.test.testworkpad.view.ISearch;

import org.greenrobot.greendao.async.AsyncOperation;
import org.greenrobot.greendao.async.AsyncOperationListener;
import org.greenrobot.greendao.async.AsyncSession;

import java.util.List;

public class SearchPresenter implements AsyncOperationListener {
  private ISearch view;
  private SearchModel model;


  public SearchPresenter(ISearch view, SearchModel model) {
    this.view = view;
    this.model = model;
  }


  public void search(String wordPart) {
    AsyncSession asyncSession = model.getSession().startAsyncSession();
    asyncSession.setListenerMainThread(this);
    asyncSession.loadAll(Word.class);
    model.loadAsyncSession(asyncSession, wordPart);
  }


  @Override
  public void onAsyncOperationCompleted(AsyncOperation operation) {
    List<Word> list = (List<Word>) operation.getResult();
    view.setList(list);
  }
}
