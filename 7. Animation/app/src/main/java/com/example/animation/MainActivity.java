package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView animationText;
    Button translate, rotation, scale, alpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationText = findViewById(R.id.animation);
        alpha = findViewById(R.id.alpha);
        rotation = findViewById(R.id.rotation);
        scale = findViewById(R.id.scale);
        translate = findViewById(R.id.translate);

//        create object for animation class
        Animation translateAnim, rotationAnim, scaleAnim, alphaAnim;
                translateAnim = AnimationUtils.loadAnimation(this,R.anim.move_animation);
                rotationAnim = AnimationUtils.loadAnimation(this,R.anim.rotation);
                scaleAnim = AnimationUtils.loadAnimation(this,R.anim.scale);
                alphaAnim = AnimationUtils.loadAnimation(this,R.anim.alpha);


        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationText.startAnimation(translateAnim);
            }
        });

        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationText.startAnimation(scaleAnim);
            }
        });
        rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationText.startAnimation(rotationAnim);
            }
        });
        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationText.startAnimation(alphaAnim);
            }
        });

    }
}