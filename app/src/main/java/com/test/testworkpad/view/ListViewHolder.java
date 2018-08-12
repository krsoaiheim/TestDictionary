package com.test.testworkpad.view;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.testworkpad.Constants;

public class ListViewHolder extends RecyclerView.ViewHolder {
  private View itemView;
  private LinearLayout layout;
  private Resources res;


  public ListViewHolder(View itemView) {
    super(itemView);
    this.itemView = itemView;
    layout = (LinearLayout) itemView;
    res = itemView.getResources();
  }


  public void setWord(String word, int lang) {
    if (word != null) {
      int resId = getStringResByName(Constants.LANG_ARR[lang]);
      TextView tv = new TextView(itemView.getContext());
      tv.setText(res.getString(resId, word));
      layout.addView(tv);
    }
  }


  private int getStringResByName(String aString) {
    String packageName = itemView.getContext().getPackageName();
    return res.getIdentifier(aString, "string", packageName);
  }


  public void clear() {
    layout.removeAllViews();
  }
}
