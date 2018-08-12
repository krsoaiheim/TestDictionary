package com.test.testworkpad.di.view;

import com.test.testworkpad.view.MainActivity;

import dagger.Subcomponent;

@PresenterScope
@Subcomponent(modules = MainListModule.class)
public interface MainListComponent {
  void injectMainList(MainActivity activity);
}
