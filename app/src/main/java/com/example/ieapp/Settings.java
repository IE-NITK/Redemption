package com.example.ieapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.ieapp.R.id.button4;
import static com.example.ieapp.R.id.button4_play;

public class Settings extends AppCompatActivity {
    Button start;
    private ImageButton b;
    Button play;
    MediaPlayer ring;
    Button clearData;

    public void play(View view) {
        ring.start();
        ring.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        play = (Button) findViewById(R.id.button4_play);
        ring = MediaPlayer.create(Settings.this, R.raw.washed_ashore);
        play.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View view) {
                                        if (ring.isPlaying()) {
                                            ring.pause();
                                            play.setText(getString(R.string.musicoff));
                                        } else {
                                            ring.start();
                                            play.setText(getString(R.string.musicon));
                                        }

                                    }
                                }
        );
        clearData=(Button)findViewById(R.id.button5);
        clearData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "your data is cleared now refresh/restart your app" , Toast.LENGTH_SHORT ).show();

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("id","ID01");
                myEdit.putInt("score",0);
                myEdit.commit();
            }
        });

    }
}



