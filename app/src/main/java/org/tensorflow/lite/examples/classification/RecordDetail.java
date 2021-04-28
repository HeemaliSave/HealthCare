package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordDetail extends AppCompatActivity {
    String TAG="RecordDetail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        DatabaseHandler dh = new DatabaseHandler(this);
        String cur_date = getIntent().getStringExtra("currentDate");
        Log.e(TAG,cur_date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        Date date = null;
        try {
            date = sdf.parse(cur_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.e(TAG,date.toString());
        String id = String.valueOf(date.getTime());
        String id2 = String.valueOf(Long.parseLong(id)+1);
        String id3 = String.valueOf(Long.parseLong(id)+2);
        FoodDetail f1 = dh.getFood(id);
        FoodDetail f2 = dh.getFood(id2);
        FoodDetail f3 = dh.getFood(id3);

        try {
            Log.e(TAG, f3.toString());
        }catch (Exception e){
            Log.e(TAG, "id2 = "+id2);
            Log.e(TAG, e.toString());
        }
        //Log.e(TAG,f2.toString());


    }
}