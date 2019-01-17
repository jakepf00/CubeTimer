package com.jakepf00.cubetimer.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jakepf00.cubetimer.AlgListAdapter;
import com.jakepf00.cubetimer.AlgUtils;
import com.jakepf00.cubetimer.Algorithm;
import com.jakepf00.cubetimer.R;

import java.util.ArrayList;

public class ReferenceFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private Spinner subsetChooser;
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
        subsetChooser = getActivity().findViewById(R.id.subset_chooser);
        ArrayAdapter<String> subsetChooserAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, subsets);
        subsetChooserAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subsetChooser.setAdapter(subsetChooserAdapter);

        recyclerView = getActivity().findViewById(R.id.alg_recycler_view);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        subsetChooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String subset = (String) parent.getItemAtPosition(position);
                ArrayList<Algorithm> thing = AlgUtils.getSubset(subset);
                recyclerAdapter = new AlgListAdapter(thing, getResources());
                recyclerView.swapAdapter(recyclerAdapter, false);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        cubeChooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cube = (String) parent.getItemAtPosition(position);
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
                ArrayAdapter<String> subsetChooserAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, subsets);
                subsetChooserAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                subsetChooser.setAdapter(subsetChooserAdapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
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
