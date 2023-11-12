package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ImageView2 extends Fragment {
    String [] imagebutton1 = {"Name: Benz","Name:TATA","Name: BMW","Name: Innova"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_image_view2, container, false);
        TextView textView2 = view.findViewById(R.id.textView2);
        textView2.setText(imagebutton1[1]);
        return view;

    }
}