package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment extends Fragment {

    public BlankFragment() {
        // Required empty public constructor

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // here we dont get the findViewById directly we use View Class. because in activity setContentView is used , here set ontentView is not defined

//        return inflater.inflate(R.layout.fragment_blank, container, false); //Breaking this return and initialising with view to find the id's of the fragment
//  here, the view is returning //joins both fragment xml and fragment java file

         View view = inflater.inflate(R.layout.fragment_blank, container, false);
         TextView textView =  view.findViewById(R.id.container); // finding the id by view. and passing to text view
//         view.findViewById(R.id.fragment2);


         return view;


    }
}