package com.example.practicefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button frag1,grag2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag1=findViewById(R.id.button);
        grag2=findViewById(R.id.button2);

    }
    private void replaceframent(Fragment frag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout,frag);
        ft.commit();

    }
    public void Fragment_1(View view) {
        replaceframent(new Fragment1());
    }

    public void Fragment_2(View view) {
        replaceframent(new Fragment2());
    }
    public void Fragment_3(View view) {
        replaceframent(new Fragment3());
    }

}