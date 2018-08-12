package com.test.testworkpad.di.view;

import com.test.testworkpad.model.DataManager;
import com.test.testworkpad.model.MainModel;
import com.test.testworkpad.presenter.MainPresenter;
import com.test.testworkpad.view.IMain;
import com.test.testworkpad.view.ListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainListModule {
  private IMain view;


  public MainListModule(IMain view) {
    this.view = view;
  }


  @PresenterScope
  @Provides
  public MainModel model(DataManager manager) {
    return new MainModel(manager);
  }


  @PresenterScope
  @Provides
  public MainPresenter presenter(MainModel model) {
    return new MainPresenter(view, model);
  }


  @PresenterScope
  @Provides
  public ListAdapter adapter() {
    return new ListAdapter();
  }
}
