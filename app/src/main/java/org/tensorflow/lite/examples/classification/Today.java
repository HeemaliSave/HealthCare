package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class  Today extends AppCompatActivity {

    Button detect_btn;
    EditText food_name;
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
        detect_btn = (Button)findViewById(R.id.detect_btn);
        food_name = (EditText)findViewById(R.id.food_name);
        food_name.setText(item_detected);
        detect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Today.this,ClassifierActivity.class);
                startActivity(intent);
            }
        });
    }
}