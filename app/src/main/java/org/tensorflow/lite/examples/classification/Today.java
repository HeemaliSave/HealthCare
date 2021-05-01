package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class  Today extends AppCompatActivity {

    Button detect_btn,meal_btn,back_btn,weight_btn,weight_btn_remain,suggest_btn;
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
        meal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                String str_food_name = food_name.getText().toString();
                String str_initial = food_weight.getText().toString();
                String str_remain = food_weight_ramain.getText().toString();
                String totoal = String.format("%.1f", Float.parseFloat(str_initial) - Float.parseFloat(str_remain));
                Food food = new DBHelper().getFoodByName(str_food_name);
                String id = String.valueOf(gettimeinmili());
                String mealtype = mealType();
                String mealtime = mealTime();

                DatabaseHandler dh = new DatabaseHandler(Today.this);
                FoodDetail foodDetail = new FoodDetail(id, mealtype, mealtime, str_food_name, str_initial, str_remain, totoal,
                        food.getCarb(), food.getProtein(), food.getFibre(), food.getFat());
                dh.addContact(foodDetail);
                Log.e("FoodDetail", dh.getFood(id).toString());
            }catch(Exception e){
                    Log.e("FoodDetailE",e.toString());
                }
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
        suggest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Today.this,suggest.class));
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

    private String mealTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    private String mealType() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        Date date = new Date();
        int hour = Integer.parseInt(formatter.format(date));
        String ans = "Breakfast";
        if(hour<=11){
            ans="BreakFast";
        }else if(hour<=16){
            ans="Lunch";
        }else{
            ans="Dinner";
        }
        return ans;
    }

    private long gettimeinmili() {
        long timeInmili = 10l;
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH");
        Date date = new Date();
        String str = formatter.format(date);
        String[] splited = str.split("\\s+");

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateString = splited[0]+"-"+splited[1]+"-"+splited[2];//"4-3-2017"
        try{
            //formatting the dateString to convert it into a Date
            Date date2 = sdf.parse(dateString);
            timeInmili = date2.getTime();
        }catch(ParseException e){
            e.printStackTrace();
        }
        int hour = Integer.parseInt(splited[3]);
        int extra = 0;
        if(hour<=11){
            extra = 0;
        }else if(hour<=16){
            extra = 1;
        }else{
            extra = 2;
        }
        return timeInmili+extra;
    }

    private void initialize() {
        detect_btn = (Button)findViewById(R.id.detect_btn);
        meal_btn = findViewById(R.id.btn_meal);
        back_btn = findViewById(R.id.btn_back);
        suggest_btn = findViewById(R.id.btn_suggest);
        weight_btn = findViewById(R.id.btn_weight);
        weight_btn_remain = findViewById(R.id.btn_weight_remain);
        food_name = (EditText)findViewById(R.id.food_name);
        food_weight = findViewById(R.id.food_weight);
        food_weight_ramain = findViewById(R.id.food_weight_remain);
    }

}