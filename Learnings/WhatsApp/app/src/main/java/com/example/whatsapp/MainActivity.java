package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button calls, updates, chats;
    Spinner spinner;

    String [] threeDotList = {"New group","New broadcast","Linked devices","Starred message","Payments","Settings"};

    ListView callListVIew;
    String [] callList = {"Akash Kobal","Sushma","Bavith","Joyce","Harsha","Hemanth","Ravith","Shreyas","Prajwal","Darshan","Roshan","Chetan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calls = findViewById(R.id.fragmentUpdates);
        updates = findViewById(R.id.fragmentCall);
        chats = findViewById(R.id.fragmentChats);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter threeDotArrayAdapter, callListViewAdapter;
        threeDotArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,threeDotList);
        spinner.setAdapter(threeDotArrayAdapter);
/*
        callListVIew = findViewById(R.id.callListVIew);
        callListViewAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,callList);
        callListVIew.setAdapter(callListViewAdapter);*/



    }

    public void onCLick(View view) {
        Fragment frg;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        int buttonId = view.getId();
        if (buttonId == R.id.fragmentChats){
            fragmentTransaction.replace(R.id.fragmentLayout,new chats());
            fragmentTransaction.commit();
        }
        else if (buttonId == R.id.fragmentUpdates){
            fragmentTransaction.replace(R.id.fragmentLayout,new updates());
            fragmentTransaction.commit();
        }
        else if (buttonId == R.id.fragmentCall){
            fragmentTransaction.replace(R.id.fragmentLayout,new calls());
            fragmentTransaction.commit();
        }
    }
}