package com.test.testworkpad.di.view;

import com.test.testworkpad.model.AddWordModel;
import com.test.testworkpad.model.DataManager;
import com.test.testworkpad.presenter.AddWordPresenter;
import com.test.testworkpad.view.IAddWord;

import dagger.Module;
import dagger.Provides;

@Module
public class AddWordModule {
  private IAddWord view;


  @PresenterScope
  @Provides
  public AddWordModel model(DataManager manager) {
    return new AddWordModel(manager);
  }


  public AddWordModule(IAddWord view) {
    this.view = view;
  }


  @PresenterScope
  @Provides
  public AddWordPresenter presenter(AddWordModel model) {
    return new AddWordPresenter(view, model);
  }
}
