package com.jakepf00.cubetimer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AlgListAdapter extends RecyclerView.Adapter<AlgListAdapter.AlgViewHolder> {
    private ArrayList<Algorithm> algSet;

    static class AlgViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView algText;
        AlgViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.alg_name);
            algText = v.findViewById(R.id.alg_text);
        }
    }

    public AlgListAdapter(ArrayList<Algorithm> algs) {
        algSet = algs;
    }
    @Override
    @NonNull
    public AlgListAdapter.AlgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reference_list_item, parent, false);
        return new AlgViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlgViewHolder holder, int position) {
        holder.name.setText(algSet.get(position).getName());
        holder.algText.setText(algSet.get(position).getAlgorithm());
    }
    @Override
    public int getItemCount() {
        return algSet.size();
    }
}
