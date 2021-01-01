package com.example.ieapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.ieapp.R.id.button4;
import static com.example.ieapp.R.id.button4_play;

public class HomeActivity extends AppCompatActivity {
    Button start;
    private ImageButton b;
    Button play;
    MediaPlayer ring;

    public void play(View view) {
        ring.start();
        ring.pause();
    }


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        start = (Button) findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, MainActivity.class);
                i.putExtra("id", "ID01");
                startActivity(i);

            }
        });
        b = (ImageButton) findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Credits.class));
            }
        });


        play = (Button) findViewById(R.id.button4_play);
        ring = MediaPlayer.create(HomeActivity.this, R.raw.games_of_part_4);
        play.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View view) {
                                        if (ring.isPlaying()) {
                                            ring.pause();
                                            play.setBackgroundResource(R.drawable.play);
                                        } else {
                                            ring.start();
                                            play.setBackgroundResource(R.drawable.pause);
                                        }

                                    }
                                }
        );

    }
}

