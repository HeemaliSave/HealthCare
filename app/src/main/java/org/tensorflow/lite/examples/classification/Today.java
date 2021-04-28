package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class  Today extends AppCompatActivity {

    Button detect_btn,meal_btn,back_btn,weight_btn,weight_btn_remain;
    EditText food_name,food_weight,food_weight_ramain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today);
        Intent intent = getIntent();
        String item_detected = intent.getStringExtra("item");
        if (item_detected==null){
            item_detected="Name of Food Item";
        }

        System.out.println(item_detected);
        initialize();

        food_name.setText(item_detected);
        detect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Today.this,ClassifierActivity.class);
                startActivity(intent);
            }
        });
        weight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double rand = 25 + Math.random()*5;
                String rounded = String.format("%.1f", rand);
                food_weight.setText(rounded);
            }
        });
        weight_btn_remain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double rand = 10 + Math.random()*5;
                String rounded = String.format("%.1f", rand);
                food_weight_ramain.setText(rounded);
            }
        });
    }

    private void initialize() {
        detect_btn = (Button)findViewById(R.id.detect_btn);
        meal_btn = findViewById(R.id.btn_meal);
        back_btn = findViewById(R.id.btn_back);
        weight_btn = findViewById(R.id.btn_weight);
        weight_btn_remain = findViewById(R.id.btn_weight_remain);
        food_name = (EditText)findViewById(R.id.food_name);
        food_weight = findViewById(R.id.food_weight);
        food_weight_ramain = findViewById(R.id.food_weight_remain);
    }
}