package com.example.ieapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Credits extends AppCompatActivity {



    private TextView textView;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        Bundle savedInstancesState = new Bundle();
        super.onCreate(savedInstancesState);
        setContentView(R.layout.credits);
        Button b5=(Button)findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Credits.this, HomeActivity.class));

            }
        });
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.credits);

        textView=(TextView)findViewById(R.id.textView);
        textView.setText("CREDITS\n"+"Mentor1-Madhumitha Nara\n"+"Mentor2-Dwaipayan Munshi\n"+"Mentor3-Prakriti Goyal\n"+"mentee1-T Shree Harsha\n"+"mentee2-Satyam Jyotsana Gargee\n");
        textView.startAnimation( animation);

    }
}
