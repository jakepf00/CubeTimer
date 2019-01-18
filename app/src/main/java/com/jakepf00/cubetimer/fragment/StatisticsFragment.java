package com.jakepf00.cubetimer.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jakepf00.cubetimer.FileHelper;
import com.jakepf00.cubetimer.R;
import com.jakepf00.cubetimer.Solve;
import com.jakepf00.cubetimer.Statistics;

import java.util.ArrayList;

public class StatisticsFragment extends Fragment {
    private String cube;

    private OnFragmentInteractionListener mListener;

    public StatisticsFragment() {}

    public static StatisticsFragment newInstance() {
        return new StatisticsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistics, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Spinner cubeChooser = getActivity().findViewById(R.id.cube_chooser);
        cube = cubeChooser.getSelectedItem().toString();
        cubeChooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cube = (String) parent.getItemAtPosition(position);

                ArrayList<Solve> solves = FileHelper.readSolvesFromFile(cube, getActivity());
                ArrayAdapter<Solve> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, solves);
                ListView listView = getView().findViewById(R.id.alltime_stats_list);
                listView.setAdapter(arrayAdapter);
                TextView bestTextView = getActivity().findViewById(R.id.alltime_best_text);
                double best = Statistics.calculateBest(solves);
                String bestText = best + "";
                bestTextView.setText(bestText);
                // TODO: figure out best Ao5 and Ao12
                TextView meanTextView = getActivity().findViewById(R.id.alltime_mean_text);
                double mean = Statistics.calculateMean(solves);
                String meanText = mean + "";
                meanTextView.setText(meanText);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<Solve> solves = FileHelper.readSolvesFromFile(cube, getActivity());
        ArrayAdapter<Solve> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, solves);
        ListView listView = getView().findViewById(R.id.alltime_stats_list);
        listView.setAdapter(arrayAdapter);

        TextView bestTextView = getActivity().findViewById(R.id.alltime_best_text);
        double best = Statistics.calculateBest(solves);
        String bestText = best + "";
        bestTextView.setText(bestText);
        // TODO: figure out best Ao5 and Ao12
        TextView meanTextView = getActivity().findViewById(R.id.alltime_mean_text);
        double mean = Statistics.calculateMean(solves);
        String meanText = mean + "";
        meanTextView.setText(meanText);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
