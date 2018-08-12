package com.test.testworkpad.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.test.testworkpad.App;
import com.test.testworkpad.R;
import com.test.testworkpad.di.view.SearchModule;
import com.test.testworkpad.model.database.Word;
import com.test.testworkpad.presenter.SearchPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity implements ISearch {
  @Inject
  SearchPresenter presenter;
  @Inject
  ListAdapter adapter;
  @BindView(R.id.word)
  EditText word;
  @BindView(R.id.search)
  Button search;
  @BindView(R.id.search_list)
  RecyclerView searchList;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    ButterKnife.bind(this);
    App.getCompoment().searchComponent(new SearchModule(this)).injectSearchActivity(this);
    searchList.setLayoutManager(new LinearLayoutManager(this));
    searchList.setAdapter(adapter);
  }


  @OnClick(R.id.search)
  public void searchData() {
    String wordString = word.getText().toString();
    if (!TextUtils.isEmpty(wordString)) {
      presenter.search(wordString);
    }
  }


  private void loadList(List<Word> search) {
    adapter.clear();
    adapter.add(search);
  }


  @Override
  public void setList(final List<Word> list) {
    loadList(list);
  }
}
