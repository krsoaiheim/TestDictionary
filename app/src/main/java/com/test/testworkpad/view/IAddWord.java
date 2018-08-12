package com.test.testworkpad.view;

import com.test.testworkpad.model.TranslateResp;

public interface IAddWord {
  void showError();
  void setWord(TranslateResp resp);
  void notifyWordSaved();
}
