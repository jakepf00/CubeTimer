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
    // TODO: Rename parameter arguments, choose names that match the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    Clock timer = new Clock();
    boolean timerRunning = false;
    ArrayList<Solve> solves = new ArrayList<>();
    ArrayAdapter<Solve> arrayAdapter;
    ListView listView;

    public TimerFragment() {

    }
    // TODO: Rename and change types and number of parameters
    public static TimerFragment newInstance(String param1, String param2) {
        TimerFragment fragment = new TimerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
    // TODO: Rename method, update argument and hook method into UI event
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
