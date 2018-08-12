package com.test.testworkpad.di.view;

import com.test.testworkpad.model.DataManager;
import com.test.testworkpad.model.SearchModel;
import com.test.testworkpad.presenter.SearchPresenter;
import com.test.testworkpad.view.ISearch;
import com.test.testworkpad.view.ListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {
  private ISearch view;


  public SearchModule(ISearch view) {
    this.view = view;
  }


  @PresenterScope
  @Provides
  public SearchModel model(DataManager manager) {
    return new SearchModel(manager);
  }


  @PresenterScope
  @Provides
  public SearchPresenter presenter(SearchModel model) {
    return new SearchPresenter(view, model);
  }


  @PresenterScope
  @Provides
  public ListAdapter adapter() {
    return new ListAdapter();
  }
}
