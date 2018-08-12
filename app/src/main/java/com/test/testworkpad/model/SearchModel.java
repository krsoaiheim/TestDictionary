package com.test.testworkpad.model;

import com.test.testworkpad.model.database.Word;
import com.test.testworkpad.model.database.WordDao;

import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.query.Query;

public class SearchModel {
  private DataManager manager;


  public SearchModel(DataManager manager) {
    this.manager = manager;
  }


  public AbstractDaoSession getSession() {
    return manager.getSession();
  }


  public void loadAsyncSession(AsyncSession asyncSession, String wordPart) {
    Query query = manager.getSession().queryBuilder(Word.class).orderAsc(WordDao.Properties.Id)
          .whereOr(WordDao.Properties.FromWord.like("%"+wordPart+"%"),
                WordDao.Properties.ToWord.like("%"+wordPart+"%")).build();
    asyncSession.queryList(query);
  }
}
