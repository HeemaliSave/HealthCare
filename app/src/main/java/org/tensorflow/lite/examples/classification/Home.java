package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {


    Button today_btn,profile_btn,goal_btn,record_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        today_btn = (Button)findViewById(R.id.today_btn);
        profile_btn = (Button)findViewById(R.id.profile_btn);
        goal_btn = findViewById(R.id.goal_btn);
        record_btn = findViewById(R.id.record_btn);
        record_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,record.class));
            }
        });
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ProfilePage.class);

                startActivity(intent);
            }
        });
        today_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Today.class);
                startActivity(intent);
            }
        });
        goal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Goal.class));
            }
        });
    }
}