package com.jakepf00.cubetimer.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jakepf00.cubetimer.AlgListAdapter;
import com.jakepf00.cubetimer.AlgUtils;
import com.jakepf00.cubetimer.Algorithm;
import com.jakepf00.cubetimer.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReferenceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReferenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReferenceFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private OnFragmentInteractionListener mListener;

    public ReferenceFragment() {

    }

    public static ReferenceFragment newInstance() {
        return new ReferenceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reference, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Spinner cubeChooser = getActivity().findViewById(R.id.cube_chooser);
        String cube = cubeChooser.getSelectedItem().toString();
        ArrayList<String> subsets = new ArrayList<>();
        switch(cube) {
            case "2x2":
                subsets.add("Ortega");
                break;
            case "3x3":
                subsets.add("OLL");
                subsets.add("PLL");
                break;
            default:
                subsets.add("no algs available");
        }
        Spinner subsetChooser = getActivity().findViewById(R.id.subset_chooser);
        ArrayAdapter<String> subsetChooserAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, subsets);
        subsetChooser.setAdapter(subsetChooserAdapter);
        String subset = subsetChooser.getSelectedItem().toString();

        mRecyclerView = getActivity().findViewById(R.id.alg_recycler_view);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        ArrayList<Algorithm> thing = AlgUtils.getSubset(subset);
        mAdapter = new AlgListAdapter(thing);
        mRecyclerView.setAdapter(mAdapter);
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
