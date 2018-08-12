package com.test.testworkpad.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.testworkpad.App;
import com.test.testworkpad.R;
import com.test.testworkpad.di.view.MainListModule;
import com.test.testworkpad.model.database.Word;
import com.test.testworkpad.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMain {
  @Inject
  MainPresenter presenter;
  @Inject
  ListAdapter adapter;
  @BindView(R.id.word_recycler)
  RecyclerView wordRecycler;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    App.getCompoment().mainListComponent(new MainListModule(this)).injectMainList(this);
    wordRecycler.setLayoutManager(new LinearLayoutManager(this));
    wordRecycler.setAdapter(adapter);
    presenter.getWords();
  }


  @Override
  public void setList(final List<Word> list) {
    adapter.clear();
    adapter.add(list);
  }


  @OnClick(R.id.add_word)
  public void addWord() {
    Intent intent = new Intent(MainActivity.this, AddWordActivity.class);
    startActivityForResult(intent, 1);
  }


  @OnClick(R.id.search)
  public void search() {
    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
    startActivity(intent);
  }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1 && resultCode == RESULT_OK) {
      presenter.getWords();
    }
  }
}
