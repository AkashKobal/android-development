package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnFragA,btnFragB,btnFragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFragA = findViewById(R.id.fragmentA);
        btnFragB = findViewById(R.id.fragmentB);
        btnFragC = findViewById(R.id.fragmentC);

        // when we open an app by default it will open fragment2
        loadFragment(new BlankFragment2()); // 0 because we add fragment when flag is 0, we replace fragment whent flag is 1(or use boolenan operations

        // reating onclick Listener for all button
        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when we want to load the fragnement dynamically we need fragment manager and Fragment Transaction (add,replace,remove = to add , replace, or remove the oject(frgment)
                // use androidx class fragment

                //creating a method for fragment, to reduce the number of code
               /* FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.fragmentA, new BlankFragment()); // addding the fragrement (where we should add , what we should add), (addingOnButton,BlankFragment)
                fragmentTransaction.commit()// to perform above taks(fragmentTransaction)*/

                loadFragment(new BlankFragment(),); // calling the method from the method with different argument

            }
        });
        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new BlankFragment2());

            }
        });
        btnFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new BlankFragment3());

            }
        });

    }
    public void loadFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (flag == 0)
            fragmentTransaction.add(androidx.constraintlayout.widget.R.id.constraint, fragment); // addding the fragrement (where we should add , what we should add), (addingOnButton,BlankFragment)
        else
            fragmentTransaction.replace(androidx.constraintlayout.widget.R.id.constraint,fragment);
//        if we want to remove the layout from frame layout we use remove
            fragmentTransaction.commit();// to perform above taks(fragmentTransaction)

    }
}