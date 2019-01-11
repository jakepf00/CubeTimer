package com.jakepf00.cubetimer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AlgListAdapter extends RecyclerView.Adapter<AlgListAdapter.AlgViewHolder> {
    private ArrayList<String> algSet; // TODO: make Algorithm class

    static class AlgViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        AlgViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public AlgListAdapter(ArrayList<String> algs) {
        algSet = algs;
    }
    @Override
    @NonNull
    public AlgListAdapter.AlgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.alg_list_item, parent, false);
        return new AlgViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlgViewHolder holder, int position) {
        holder.mTextView.setText(algSet.get(position));

    }
    @Override
    public int getItemCount() {
        return algSet.size();
    }
}
