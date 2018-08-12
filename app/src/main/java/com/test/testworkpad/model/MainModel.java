package com.test.testworkpad.model;

import com.test.testworkpad.model.database.Word;
import com.test.testworkpad.model.database.WordDao;

import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.query.Query;

public class MainModel {
  private DataManager manager;


  public MainModel(DataManager manager) {
    this.manager = manager;
  }


  public AbstractDaoSession getSession() {
    return manager.getSession();
  }


  public void loadAsyncSession(AsyncSession asyncSession) {
    Query query = manager.getSession().queryBuilder(Word.class).orderAsc(WordDao.Properties.Id)
          .build();
    asyncSession.queryList(query);
  }
}
