package com.jakepf00.cubetimer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TimeListAdapter extends RecyclerView.Adapter<TimeListAdapter.TimeViewHolder> {
    private ArrayList<Solve> solves;

    static class TimeViewHolder extends RecyclerView.ViewHolder {
        TimeViewHolder(View v) {
            super(v);
        }
    }

    public TimeListAdapter(ArrayList<Solve> solves) {
        this.solves = solves;
    }
    @Override
    @NonNull
    public TimeListAdapter.TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reference_list_item, parent, false);
        return new TimeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return solves.size();
    }
}