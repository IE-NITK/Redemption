//package com.example.ieapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    Button b_read1;
//    Button b_read2;
//    Button b_read3;
//
//    TextView tv_text;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        b_read1 = (Button) findViewById(R.id.b_read1);
//        b_read2 = (Button) findViewById(R.id.b_read2);
//        b_read3 = (Button) findViewById(R.id.b_read3);
//
//        tv_text = (TextView) findViewById(R.id.tv_text);
//
//
//        String text = "";
//        String filename = "Question 1.txt";
//        String[] buttons_options = new String[4];
//        while (true) {
//            try {
//                InputStream is = getAssets().open(filename);
//                int size = is.available();
//                byte[] buffer = new byte[size];
//                is.read(buffer);
//                is.close();
//                text = new String(buffer);
//                buttons_options = text.split("split_to_button");
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//
//            tv_text.setText(buttons_options[0]);
//            b_read1.setText(buttons_options[1]);
//            b_read2.setText(buttons_options[2]);
//            b_read3.setText(buttons_options[3]);
//
//            b_read1.setOnClickListener(this);
//            b_read2.setOnClickListener(this);
//            b_read3.setOnClickListener(this);
//
//
//
//        }
//    }
//    @Override
//    public void onClick(View v) {
//        switch(v.getId())
//        {
//            case R.id.b_read1:
//
//
//
//
//
//
//
//
//
//        }
//
//    }
//}
//
//
//
//
//
//

package com.example.ieapp;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;



public class Game_Screen extends AppCompatActivity
{

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);

//        updateQuestion(mQuestionNumber);

        String text = "";
        String filename = "Question 1.txt";
        String[] buttons_options = new String[4];
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
            buttons_options = text.split("split_to_button");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        mQuestionView.setText(buttons_options[0]);
        mButtonChoice1.setText(buttons_options[1]);
        mButtonChoice2.setText(buttons_options[2]);
        mButtonChoice3.setText(buttons_options[3]);

        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mQuestionNumber++;
                mScore = mScore+1;
                updateScore(mScore);
                updateQuestion(mQuestionNumber);

            }
    });
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mQuestionNumber++;
                mScore = mScore+1;
                updateScore(mScore);
                updateQuestion(mQuestionNumber);

            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mQuestionNumber++;
                mScore = mScore+1; //this we'll have to take from file (might not be +1)
                updateScore(mScore);
                updateQuestion(mQuestionNumber);


            }
        });

    }

    private void updateQuestion(int mQuestionNumber)    {

        String text = "";
        String filename = QuestionLibrary.getQuestionFile(mQuestionNumber);
        String[] buttons_options = new String[4];
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
            buttons_options = text.split("split_to_button");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        mQuestionView.setText(buttons_options[0]);
        mButtonChoice1.setText(buttons_options[1]);
        mButtonChoice2.setText(buttons_options[2]);
        mButtonChoice3.setText(buttons_options[3]);

    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}




