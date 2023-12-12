package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ImageView4 extends Fragment {
    String [] imagebutton1 = {"Name: Benz","Name:TATA","Name: BMW","Name: Innova"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_image_view4, container, false);
        TextView textView4 = view.findViewById(R.id.textView4);
        textView4.setText(imagebutton1[3]);
        return view;
    }
}