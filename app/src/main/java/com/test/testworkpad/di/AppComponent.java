package com.test.testworkpad.di;

import com.test.testworkpad.di.view.AddWordComponent;
import com.test.testworkpad.di.view.AddWordModule;
import com.test.testworkpad.di.view.MainListComponent;
import com.test.testworkpad.di.view.MainListModule;
import com.test.testworkpad.di.view.SearchComponent;
import com.test.testworkpad.di.view.SearchModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DataManagerModule.class)
public interface AppComponent {
  MainListComponent mainListComponent(MainListModule mainListModule);
  AddWordComponent addWordComponent(AddWordModule module);
  SearchComponent searchComponent(SearchModule module);
}
