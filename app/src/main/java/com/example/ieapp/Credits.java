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
                Intent i = new Intent(Credits.this, HomeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.credits);

        textView=(TextView)findViewById(R.id.textView);

        String n0 = "\n";
        String n1 = getString(R.string.credits_heading);
        String n2 = getString(R.string.lead);
        String n3 = getString(R.string.lead_name1);
        String n4 = getString(R.string.lead_name2);
        String n5 = getString(R.string.story);
        String n6 = getString(R.string.story_contri1);
        String n7 = getString(R.string.story_contri2);
        String n8 = getString(R.string.story_contri3);
        String n9 = getString(R.string.app);
        String n10 = getString(R.string.app_contri1);
        String n11 = getString(R.string.app_contri2);
        String n12 = getString(R.string.specialthanks);
        String n13 = getString(R.string.woc_contri1);
        String n14 = getString(R.string.woc_contri2);


        textView.setText(n1 + n0 + n0 + n0 + n2 + n0 + n3 + n0 + n4 + n0 + n0 + n5 + n0 + n6 + n0 +
                n7 + n0 + n8 + n0 + n0 + n9 + n0 + n10 +
                n0 + n11 + n0 + n0 + n12 + n0 + n13 + n0 + n14);
        textView.startAnimation( animation);

    }
}
