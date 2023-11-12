package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button red,blue,green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = findViewById(R.id.redFragment);
        blue = findViewById(R.id.blueFragment);
        green = findViewById(R.id.greenFragment);

    }

    public void onClick(View view) {
        int buttonId = view.getId();
        Fragment fr;
        FragmentManager fragmentManager = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (buttonId == R.id.red){
            fragmentTransaction.replace(R.id.fragmentLayout, new RedFragmant());
            fragmentTransaction.commit();
            fr = new RedFragmant();
        } else if (buttonId == R.id.blue) {
            fragmentTransaction.replace(R.id.fragmentLayout,new  BlueFragment());
            fragmentTransaction.commit();
            fr = new BlueFragment();
        } else if (buttonId == R.id.green) {
            fragmentTransaction.replace(R.id.fragmentLayout,new GreenFragment());
            fragmentTransaction.commit();
            fr = new GreenFragment();
        }

    }
}