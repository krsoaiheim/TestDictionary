package com.test.testworkpad.di;

import com.test.testworkpad.model.ApiService;
import com.test.testworkpad.model.DataManager;
import com.test.testworkpad.model.database.DaoSession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {NetworkModule.class, DatabaseModule.class})
public class DataManagerModule {
  @Provides
  @Singleton
  public ApiService service(Retrofit retrofit) {
    return retrofit.create(ApiService.class);
  }


  @Provides
  @Singleton
  public DataManager manager(ApiService service, DaoSession session) {
    return new DataManager(service, session);
  }
}
