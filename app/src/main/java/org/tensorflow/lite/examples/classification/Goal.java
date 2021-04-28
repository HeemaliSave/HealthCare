package org.tensorflow.lite.examples.classification;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Goal extends AppCompatActivity {
    final String MyPref = "ProfileDetail";
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal);
        SharedPreferences sh = getSharedPreferences(MyPref,MODE_PRIVATE);
        Float height = sh.getFloat("UHeight",20.0f);
        Float weight = sh.getFloat("UWeight",45.0f);
        iv = findViewById(R.id.imageView3);
        if(height<=55){
            iv.setImageResource(R.drawable.goal1);
        }
        else if(height<=60){
            iv.setImageResource(R.drawable.goal2);
        }
        else if(height<=65){
            iv.setImageResource(R.drawable.goal3);
        }
        else if(height>65){
            iv.setImageResource(R.drawable.goal4);
        }
    }
}