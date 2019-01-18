package com.jakepf00.cubetimer.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jakepf00.cubetimer.Clock;
import com.jakepf00.cubetimer.FileHelper;
import com.jakepf00.cubetimer.R;
import com.jakepf00.cubetimer.Scrambler;
import com.jakepf00.cubetimer.Solve;
import com.jakepf00.cubetimer.Statistics;

import java.util.ArrayList;

public class TimerFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    Clock timer = new Clock();
    boolean timerRunning = false;
    ArrayList<Solve> solves = new ArrayList<>();
    ArrayAdapter<Solve> arrayAdapter;
    ListView listView;
    private String cube;
    private TextView scrambleText;

    public TimerFragment() {

    }
    public static TimerFragment newInstance() {
        return new TimerFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }
    @Override
    @SuppressLint("ClickableViewAccessibility")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        ConstraintLayout timerLayout = getView().findViewById(R.id.timer_layout);
        timerLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                TextView tv = getView().findViewById(R.id.time_text);
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (timerRunning) {
                            double time = timer.stop();
                            String timeStr = "" + time;
                            tv.setText(timeStr);
                            Solve solve = new Solve();
                            solve.time = time;
                            solves.add(0, solve);
                            arrayAdapter.notifyDataSetChanged();
                            updateStatistics(solves);
                            scrambleText.setText(Scrambler.generateScramble(cube));
                        } else {
                            tv.setText(R.string.release_to_start);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (timerRunning) {
                            timerRunning = false;
                        } else {
                            timer.start();
                            timerRunning = true;
                            tv.setText(R.string.timing);
                        }
                        break;
                }
                return true;
            }
        });

        Button archiveSessionButton = getView().findViewById(R.id.archive_session_button);
        archiveSessionButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileHelper.writeSolvesToFile(cube, solves, getContext());
                solves.clear();
                arrayAdapter.notifyDataSetChanged();
                updateStatistics(solves);
                TextView tv = getView().findViewById(R.id.time_text);
                tv.setText(R.string.touch_to_start);
            }
        });

        arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, solves);
        listView = getView().findViewById(R.id.session_stats_list);
        listView.setAdapter(arrayAdapter);

        Spinner cubeChooser = getActivity().findViewById(R.id.cube_chooser);
        cube = cubeChooser.getSelectedItem().toString();
        cubeChooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cube = (String) parent.getItemAtPosition(position);
                solves.clear();
                arrayAdapter.notifyDataSetChanged();
                updateStatistics(solves);
                TextView tv = getView().findViewById(R.id.time_text);
                tv.setText(R.string.touch_to_start);
                scrambleText.setText(Scrambler.generateScramble(cube));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        scrambleText = getActivity().findViewById(R.id.scramble_text);
        scrambleText.setText(Scrambler.generateScramble(cube));
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
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

    private void updateStatistics(ArrayList<Solve> solves) {
        TextView meanTextView = getActivity().findViewById(R.id.alltime_mean_text);
        double mean = Statistics.calculateMean(solves);
        String meanText = "" + mean;
        if (mean == 0.0) {
            meanTextView.setText(R.string.no_data_available);
        } else {
            meanTextView.setText(meanText);
        }

        TextView bestTextView = getActivity().findViewById(R.id.alltime_best_text);
        double best = Statistics.calculateBest(solves);
        String bestText = "" + best;
        if (best == 0.0) {
            bestTextView.setText(R.string.no_data_available);
        } else {
            bestTextView.setText(bestText);
        }

        TextView averageFiveTextView = getActivity().findViewById(R.id.best_ao5_text);
        double averageFive = Statistics.calculateAverage(solves, 5);
        String averageFiveText = "" + averageFive;
        if (averageFive == 0.0) {
            averageFiveTextView.setText(R.string.no_data_available);
        } else {
            averageFiveTextView.setText(averageFiveText);
        }

        TextView averageTwelveTextView = getActivity().findViewById(R.id.best_ao12_text);
        double averageTwelve = Statistics.calculateAverage(solves, 12);
        String averageTwelveText = "" + averageTwelve;
        averageTwelveTextView.setText(averageTwelveText);
        if (averageTwelve == 0.0) {
            averageTwelveTextView.setText(R.string.no_data_available);
        } else {
            averageTwelveTextView.setText(averageTwelveText);
        }
    }
}
