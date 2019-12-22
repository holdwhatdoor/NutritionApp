package com.example.nutritionapp.ui;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    String TAG = "MainAdapter";

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MainHolder extends RecyclerView.ViewHolder {
        public MainHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
