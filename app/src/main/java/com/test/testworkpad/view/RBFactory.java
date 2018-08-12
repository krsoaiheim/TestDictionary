package com.test.testworkpad.view;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.test.testworkpad.Constants;
import com.test.testworkpad.R;

public class RBFactory {
  private Integer toLan;
  private Context cont;


  public RBFactory(Context cont) {
    this.cont = cont;
  }


  public Integer getToLan() {
    return toLan;
  }


  public void setToLan(Integer toLan) {
    this.toLan = toLan;
  }


  public RadioButton createBtn(int i) {
    RadioButton btn = null;
    switch (i) {
      case Constants.RUS:
        btn = new RadioButton(cont);
        btn.setText(R.string.ru_rad);
        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
              toLan = Constants.RUS;
            }
          }
        });
        break;
      case Constants.EN:
        btn = new RadioButton(cont);
        btn.setText(R.string.en_rad);
        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
              toLan = Constants.EN;
            }
          }
        });
        break;
      case Constants.GE:
        btn = new RadioButton(cont);
        btn.setText(R.string.de_rad);
        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
              toLan = Constants.GE;
            }
          }
        });
        break;
      case Constants.JA:
        btn = new RadioButton(cont);
        btn.setText(R.string.ja_rad);
        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
              toLan = Constants.JA;
            }
          }
        });
        break;
    }
    return btn;
  }
}
