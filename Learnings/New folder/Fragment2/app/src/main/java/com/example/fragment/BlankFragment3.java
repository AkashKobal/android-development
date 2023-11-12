package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment3 extends Fragment {
    public BlankFragment3() {
        // constructor is required
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_blank3, container, false);

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView textView =  view.findViewById(R.id.fragmentC); // finding the id by view. and passing to text view
//         view.findViewById(R.id.fragment2);


        return view;
    }
}