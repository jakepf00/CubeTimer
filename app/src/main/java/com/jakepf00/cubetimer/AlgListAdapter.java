package com.jakepf00.cubetimer;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AlgListAdapter extends RecyclerView.Adapter<AlgListAdapter.AlgViewHolder> {
    private ArrayList<Algorithm> algSet;
    private int grey;
    private int white;
    private int yellow;
    private int blue;
    private int green;
    private int red;
    private int orange;

    static class AlgViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView algText;
        View cubePicture;
        AlgViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.alg_name);
            algText = v.findViewById(R.id.alg_text);
            cubePicture = v.findViewById(R.id.cube_picture);
        }
    }

    public AlgListAdapter(ArrayList<Algorithm> algs, Resources resources) {
        algSet = algs;
        grey = resources.getColor(R.color.grey_cube);
        white = resources.getColor(R.color.white_cube);
        yellow = resources.getColor(R.color.yellow_cube);
        blue = resources.getColor(R.color.blue_cube);
        green = resources.getColor(R.color.green_cube);
        red = resources.getColor(R.color.red_cube);
        orange = resources.getColor(R.color.orange_cube);
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

        View sticker = holder.cubePicture.findViewById(R.id.view);
        sticker.setBackgroundColor(yellow);
        View sticker2 = holder.cubePicture.findViewById(R.id.view2);
        sticker2.setBackgroundColor(yellow);
        View sticker3 = holder.cubePicture.findViewById(R.id.view3);
        sticker3.setBackgroundColor(yellow);
        View sticker4 = holder.cubePicture.findViewById(R.id.view4);
        sticker4.setBackgroundColor(yellow);
        View sticker5 = holder.cubePicture.findViewById(R.id.view5);
        sticker5.setBackgroundColor(yellow);
        View sticker6 = holder.cubePicture.findViewById(R.id.view6);
        sticker6.setBackgroundColor(yellow);
        View sticker7 = holder.cubePicture.findViewById(R.id.view7);
        sticker7.setBackgroundColor(yellow);
        View sticker8 = holder.cubePicture.findViewById(R.id.view8);
        sticker8.setBackgroundColor(yellow);
        View sticker9 = holder.cubePicture.findViewById(R.id.view9);
        sticker9.setBackgroundColor(yellow);
        View sticker10 = holder.cubePicture.findViewById(R.id.view10);
        sticker10.setBackgroundColor(blue);
        View sticker11 = holder.cubePicture.findViewById(R.id.view11);
        sticker11.setBackgroundColor(blue);
        View sticker12 = holder.cubePicture.findViewById(R.id.view12);
        sticker12.setBackgroundColor(blue);
        View sticker13 = holder.cubePicture.findViewById(R.id.view13);
        sticker13.setBackgroundColor(red);
        View sticker14 = holder.cubePicture.findViewById(R.id.view14);
        sticker14.setBackgroundColor(red);
        View sticker15 = holder.cubePicture.findViewById(R.id.view15);
        sticker15.setBackgroundColor(red);
        View sticker16 = holder.cubePicture.findViewById(R.id.view16);
        sticker16.setBackgroundColor(green);
        View sticker17 = holder.cubePicture.findViewById(R.id.view17);
        sticker17.setBackgroundColor(green);
        View sticker18 = holder.cubePicture.findViewById(R.id.view18);
        sticker18.setBackgroundColor(green);
        View sticker19 = holder.cubePicture.findViewById(R.id.view19);
        sticker19.setBackgroundColor(orange);
        View sticker20 = holder.cubePicture.findViewById(R.id.view20);
        sticker20.setBackgroundColor(orange);
        View sticker21 = holder.cubePicture.findViewById(R.id.view21);
        sticker21.setBackgroundColor(orange);
    }
    @Override
    public int getItemCount() {
        return algSet.size();
    }
}
