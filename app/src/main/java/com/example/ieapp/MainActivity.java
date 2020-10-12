package com.example.ieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button b_read;
    Button button;
    Button button2;
    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_read = findViewById(R.id.choice1);
        button = findViewById(R.id.choice2);
        button2 = findViewById(R.id.choice3);
        tv_text = findViewById(R.id.question);

        String text = "";
        try {
            InputStream is = getAssets().open("Question 2.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String screen = "";
        int index = text.indexOf("split_to_button");
        if (index != -1) {
            screen = text.substring(0, index);
        }
        String b1 = "";
        int i = text.indexOf("split_to_button", index + 1);
        if (i != -1 && index != -1) {
            b1 = text.substring(index + 15, i);
        }
        index = i;
        String b2 = "";
        i = text.indexOf("split_to_button", index +1 );
        if (i != -1 && index != -1) {
            b2 = text.substring(index + 15, i);
        }
        index = i;
        String b3 = "";
        b3 = text.substring(index + 15);
        tv_text.setText(screen);
        b_read.setText(b1);
        button.setText(b2);
        button2.setText(b3);
        }
    }

