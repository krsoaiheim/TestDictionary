package com.test.testworkpad.di.view;

import com.test.testworkpad.view.AddWordActivity;

import dagger.Subcomponent;

@PresenterScope
@Subcomponent(modules = AddWordModule.class)
public interface AddWordComponent {
  void injectAddWordActivity(AddWordActivity activity);
}
