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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jakepf00.cubetimer.Clock;
import com.jakepf00.cubetimer.R;
import com.jakepf00.cubetimer.Solve;

import java.util.ArrayList;

public class TimerFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    Clock timer = new Clock();
    boolean timerRunning = false;
    ArrayList<Solve> solves = new ArrayList<>();
    ArrayAdapter<Solve> arrayAdapter;
    ListView listView;

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
                TextView tv = getView().findViewById(R.id.scramble_text);
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
                        } else {
                            tv.setText("Release to start timer");
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (timerRunning) {
                            timerRunning = false;
                        } else {
                            timer.start();
                            timerRunning = true;
                            tv.setText("Timing");
                        }
                        break;
                }
                return true;
            }
        });

        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, solves);
        listView = getView().findViewById(R.id.session_stats_list);
        listView.setAdapter(arrayAdapter);
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
}
