package com.example.ieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    TextView tv_text;
    TextView total_score;
    Intent i;
    String id;
    JSONArray obj;
    JSONObject mainContent;
    int score;

    public JSONObject getIndexData() {
        for (int i = 0; i < obj.length(); i++) {
            try {
                JSONObject objData = (JSONObject) obj.get(i);
                if (objData.getString("id").equals(this.id)) {
                    return objData;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = getIntent();
        id = i.getStringExtra("id");
        score = i.getIntExtra("score",0);
        try {
            obj = new JSONArray(loadJSONFromAsset());
            mainContent = getIndexData();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        button1 = findViewById(R.id.choice1);
        button2 = findViewById(R.id.choice2);
        button3 = findViewById(R.id.choice3);
        tv_text = findViewById(R.id.question);
        total_score = findViewById(R.id.score);

        /*Typeface font_style = Typeface.createFromAsset(getAssets(), "AlexBrush.tff");
        b_read.setTypeface(font_style);*/

        String text = "";
        int countOfButtons = 0;
        String b1 = "";
        String b2 = "";
        String b3 = "";
        String q_id1 = "";
        String q_id2 = "";
        String q_id3 = "";
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        JSONArray options;

        try {
            text = mainContent.getString("text");
            countOfButtons = mainContent.getInt("no_of_options");
            options = mainContent.getJSONArray("options");
            switch (countOfButtons) {
                case 1: {
                    JSONObject obj1 = options.getJSONObject(0);
                    b1 = obj1.getString("text");
                    q_id1 = obj1.getString("q_id");
                    score1 = obj1.getInt("score");
                }
                case 2: {
                    JSONObject obj1 = options.getJSONObject(0);
                    JSONObject obj2 = options.getJSONObject(1);
                    b1 = obj1.getString("text");
                    b2 = obj2.getString("text");
                    q_id1 = obj1.getString("q_id");
                    q_id2 = obj2.getString("q_id");
                    score1 = obj1.getInt("score");
                    score2 = obj2.getInt("score");
                }
                case 3: {
                    JSONObject obj1 = options.getJSONObject(0);
                    JSONObject obj2 = options.getJSONObject(1);
                    JSONObject obj3 = options.getJSONObject(2);
                    b1 = obj1.getString("text");
                    b2 = obj2.getString("text");
                    b3 = obj3.getString("text");
                    q_id1 = obj1.getString("q_id");
                    q_id2 = obj2.getString("q_id");
                    q_id3 = obj3.getString("q_id");
                    score1 = obj1.getInt("score");
                    score2 = obj2.getInt("score");
                    score3 = obj3.getInt("score");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String finalQ_id1 = q_id1;
        final int new_score1 = score1 + score;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalQ_id1.equals("mainmenu")) {
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                    i.putExtra("id", finalQ_id1);
                    i.putExtra("score",new_score1);
                    startActivity(i);
                }
            }
        });

        final String finalQ_id2 = q_id2;
        final int new_score2 = score2 + score;
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalQ_id2.equals("mainmenu")) {
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                    i.putExtra("id", finalQ_id2);
                    i.putExtra("score",new_score2);
                    startActivity(i);
                }
            }
        });

        final String finalQ_id3 = q_id3;
        final int new_score3 = score3 + score;
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalQ_id3.equals("mainmenu")) {
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                    i.putExtra("id", finalQ_id3);
                    i.putExtra("score",new_score3);
                    startActivity(i);
                }
            }
        });

        switch (countOfButtons) {
            case 1: {
                button1.setText(b1);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
            }
            case 2: {
                button1.setText(b1);
                button2.setText(b2);
                button3.setVisibility(View.GONE);
            }
            case 3: {
                button1.setText(b1);
                button2.setText(b2);
                button3.setText(b3);
            }
        }
        total_score.setText(String.valueOf(score));
        tv_text.setText(text);
    }
}

