package com.example.fragmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AFragment extends Fragment {

    private static final String AGE0 = "arg1";
    private static final String AGE1 = "arg2";



    public static AFragment getInstance(String value1, int value2){

        AFragment aFragment = new AFragment();

        Bundle bundle = new Bundle();
        bundle.putString(AGE0,value1);
        bundle.putInt(AGE1,value2);

        aFragment.setArguments(bundle);

        return aFragment;
    }

    public AFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (getArguments() != null){
            String name = getArguments().getString(AGE0);
            int number = getArguments().getInt(AGE1);

            String TAG = "Check Log";
            Log.d(TAG, "The Name Is: "+name+" The Number Is: "+number);

            ((MainActivity) getActivity()).callFromFragment();
        }




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}