package com.example.ieapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button quit;
    Button start;
    private ImageButton b;
    Button settings;
    Button play;
    MediaPlayer ring;
    Button resume;
    Button endings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        start = (Button) findViewById(R.id.button);
        resume = (Button) findViewById(R.id.button8);

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        final String id = sh.getString("id", "ID01");
        final int score = sh.getInt("score", 0);

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, MainActivity.class);
                i.putExtra("id", id);
                i.putExtra("score", score);
                startActivity(i);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, MainActivity.class);
                i.putExtra("id", "ID01");
                i.putExtra("score", 0);
                startActivity(i);
            }
        });

        if (!id.equals("ID01")) {
            start.setVisibility(View.GONE);
            resume.setVisibility(View.VISIBLE);
        } else {
            resume.setVisibility(View.GONE);
            start.setVisibility(View.VISIBLE);
        }

        settings = (Button) findViewById(R.id.button3);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Settings.class));
            }
        });

        endings = (Button) findViewById(R.id.button2);
        endings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), com.example.ieapp.endings.class));
            }
        });

        quit = (Button) findViewById(R.id.Button6);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        b = (ImageButton) findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Credits.class));
            }
        });
    }
}

