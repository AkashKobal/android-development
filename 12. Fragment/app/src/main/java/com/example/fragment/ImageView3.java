package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ImageView3 extends Fragment {
    String [] imagebutton1 = {"Name: Benz","Name:TATA","Name: BMW","Name: Innova"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_image_view3, container, false);
        TextView textView3 = view.findViewById(R.id.textView3);
        textView3.setText(imagebutton1[2]);
        return view;
    }
}