package com.test.testworkpad;

import android.app.Application;

import com.test.testworkpad.di.AppComponent;
import com.test.testworkpad.di.DaggerAppComponent;
import com.test.testworkpad.di.DatabaseModule;

public class App extends Application {
  private static AppComponent compoment;


  public static AppComponent getCompoment() {
    return compoment;
  }


  @Override
  public void onCreate() {
    super.onCreate();
    compoment = DaggerAppComponent.builder()
          .databaseModule(new DatabaseModule(getApplicationContext()))
          .build();
  }
}
