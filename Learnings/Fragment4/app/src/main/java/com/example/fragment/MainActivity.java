package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button imageview1 , imageview2 , imageview3 , imageview4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        imageview1 = findViewById(R.id.Imageview1);
        imageview2 = findViewById(R.id.Imageview2);
        imageview3 = findViewById(R.id.Imageview3);
        imageview4 = findViewById(R.id.Imageview4);


    }

    public void button(View view) {
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        int buttonId = view.getId();
        if (buttonId == R.id.Imageview1){
            fragmentTransaction.replace(R.id.frameLayout,new ImageView1());
            Toast.makeText(this,"ImageView1",Toast.LENGTH_SHORT).show();
            fragmentTransaction.commit();
        } else if (buttonId == R.id.Imageview2) {
            fragmentTransaction.replace(R.id.frameLayout,new ImageView2());
            Toast.makeText(this,"ImageView2",Toast.LENGTH_SHORT).show();
            fragmentTransaction.commit();

        } else if (buttonId == R.id.Imageview3) {
            fragmentTransaction.replace(R.id.frameLayout,new ImageView3());
            Toast.makeText(this,"ImageView3",Toast.LENGTH_SHORT).show();
            fragmentTransaction.commit();

        } else if (buttonId == R.id.Imageview4) {
            fragmentTransaction.replace(R.id.frameLayout,new ImageView4());
            Toast.makeText(this,"ImageView4",Toast.LENGTH_SHORT).show();
            fragmentTransaction.commit();

        }
    }
}