package com.test.testworkpad.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.testworkpad.R;
import com.test.testworkpad.model.database.Word;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
  private List<Word> list = new ArrayList<>();


  public ListAdapter() {
    setHasStableIds(true);
  }


  @NonNull
  @Override
  public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
    return new ListViewHolder(v);
  }


  @Override
  public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
    Word word = list.get(position);
    holder.clear();
    holder.setWord(word.getFromWord(), word.getFromLang());
    holder.setWord(word.getToWord(), word.getToLang());
  }


  @Override
  public long getItemId(int position) {
    return list.get(position).getId();
  }


  @Override
  public int getItemCount() {
    return list.size();
  }


  public void add(List<Word> words) {
    list.addAll(words);
    notifyDataSetChanged();
  }


  public void clear() {
    list.clear();
  }
}
