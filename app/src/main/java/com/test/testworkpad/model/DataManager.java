package com.test.testworkpad.model;

import com.test.testworkpad.model.database.DaoSession;
import com.test.testworkpad.model.database.Word;

import org.greenrobot.greendao.query.Query;

public class DataManager {
  private final ApiService service;
  private final DaoSession session;


  public DataManager(ApiService service, DaoSession session) {
    this.service = service;
    this.session = session;
  }


  public ApiService getService() {
    return service;
  }


  public DaoSession getSession() {
    return session;
  }
}
