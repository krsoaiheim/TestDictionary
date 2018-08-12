package com.test.testworkpad.di.view;

import com.test.testworkpad.view.SearchActivity;

import dagger.Subcomponent;

@PresenterScope
@Subcomponent(modules = SearchModule.class)
public interface SearchComponent {
  void injectSearchActivity(SearchActivity activity);
}
