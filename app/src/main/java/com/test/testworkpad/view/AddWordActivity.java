package com.test.testworkpad.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.test.testworkpad.App;
import com.test.testworkpad.Constants;
import com.test.testworkpad.R;
import com.test.testworkpad.di.view.AddWordModule;
import com.test.testworkpad.model.TranslateResp;
import com.test.testworkpad.presenter.AddWordPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddWordActivity extends AppCompatActivity implements IAddWord {
  @Inject
  AddWordPresenter presenter;
  @BindView(R.id.from_group)
  RadioGroup fromGroup;
  @BindView(R.id.to_group)
  RadioGroup toGroup;
  @BindView(R.id.word)
  EditText word;
  @BindView(R.id.translate)
  Button translate;
  @BindView(R.id.translation)
  TextView translation;
  @BindView(R.id.save)
  Button save;
  private Integer fromLan;
  private RBFactory factory;
  private Integer toLan;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_word);
    ButterKnife.bind(this);
    App.getCompoment().addWordComponent(new AddWordModule(this)).injectAddWordActivity(this);
    factory = new RBFactory(this);
    fromGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId) {
        toLan = null;
        switch (checkedId) {
          case R.id.rus_from_btn:
            fromLan = Constants.RUS;
            break;
          case R.id.en_from_btn:
            fromLan = Constants.EN;
            break;
          case R.id.ge_from_btn:
            fromLan = Constants.GE;
            break;
          case R.id.ja_from_btn:
            fromLan = Constants.JA;
            break;
        }
        factory.setToLan(null);
        addToGroup();
      }
    });
  }


  private void addToGroup() {
    toGroup.removeAllViews();
    for (int i = 0; i<=3; i++) {
      if (i != fromLan) {
        RadioButton btn = factory.createBtn(i);
        toGroup.addView(btn);
      }
    }
  }


  @OnClick(R.id.translate)
  public void translate() {
    toLan = factory.getToLan();
    String wordString = word.getText().toString();
    if (!TextUtils.isEmpty(wordString) && fromLan != null && toLan != null) {
      presenter.translate(wordString, fromLan, toLan);
      hideKeyboard();
    }
  }


  private void hideKeyboard() {
    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
    View view = getCurrentFocus();
    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
  }


  @Override
  public void showError() {
    Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
  }


  @Override
  public void setWord(TranslateResp resp) {
    translation.setText(resp.getText());
  }


  @Override
  public void notifyWordSaved() {
    Toast.makeText(this, getString(R.string.saved), Toast.LENGTH_SHORT).show();
    setResult(RESULT_OK);
    finish();
  }


  @OnClick(R.id.save)
  public void save() {
    if (!TextUtils.isEmpty(translation.getText().toString())) {
      presenter.save();
    }
  }


  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.destroyCall();
  }
}
