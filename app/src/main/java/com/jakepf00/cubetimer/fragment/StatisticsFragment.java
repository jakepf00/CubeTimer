package com.jakepf00.cubetimer.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jakepf00.cubetimer.FileHelper;
import com.jakepf00.cubetimer.R;
import com.jakepf00.cubetimer.Solve;
import com.jakepf00.cubetimer.Statistics;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.jakepf00.cubetimer.FileHelper.readStringFromFile;


public class StatisticsFragment extends Fragment {
    private String cube;

    private OnFragmentInteractionListener mListener;

    public StatisticsFragment() {
        // Required empty public constructor
    }

    public static StatisticsFragment newInstance() {
        return new StatisticsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Spinner cubeChooser = getActivity().findViewById(R.id.cube_chooser);
        cube = cubeChooser.getSelectedItem().toString();

        String text = FileHelper.readStringFromFile(cube, getActivity());
        TextView tv = getActivity().findViewById(R.id.file_contents);
        tv.setText(text);

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
