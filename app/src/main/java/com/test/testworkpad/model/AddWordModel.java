package com.test.testworkpad.model;

import com.test.testworkpad.model.database.Word;

import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.async.AsyncSession;

public class AddWordModel {
  private DataManager manager;


  public AddWordModel(DataManager manager) {
    this.manager = manager;
  }


  public ApiService getService() {
    return manager.getService();
  }


  public AbstractDaoSession getSession() {
    return manager.getSession();
  }


  public void saveAsyncSession(AsyncSession asyncSession, Word word) {
    asyncSession.insert(word);
  }
}
