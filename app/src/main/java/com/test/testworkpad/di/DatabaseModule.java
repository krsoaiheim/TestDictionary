package com.test.testworkpad.di;

import android.content.Context;

import com.test.testworkpad.model.database.DaoMaster;
import com.test.testworkpad.model.database.DaoSession;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
  private Context context;


  public DatabaseModule(Context context) {
    this.context = context;
  }


  @Provides
  @Singleton
  public DaoMaster.DevOpenHelper master() {
    return new DaoMaster.DevOpenHelper(context, "translate-db");
  }


  @Provides
  @Singleton
  public DaoSession session(DaoMaster.DevOpenHelper helper) {
    Database db = helper.getWritableDb();
    return new DaoMaster(db).newSession();
  }
}
