package com.example.ieapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import android.os.Bundle;
import android.widget.TextView;

public class Splash_Activity extends AppCompatActivity {

    private ImageView logo;
    private TextView tv;

    private static int splashTimeOut=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
        setTheme(R.style.Theme);
        logo=(ImageView)findViewById(R.id.logo);
        tv = (TextView)findViewById(R.id.textView);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition1);
        tv.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_Activity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeOut);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.transition1);
        logo.startAnimation(myanim);
    }
}



