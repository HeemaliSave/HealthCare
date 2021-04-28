package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordDetail extends AppCompatActivity {
    String TAG="RecordDetail";
    final String MyPref = "ProfileDetail";
    EditText ed[] = new EditText[30];
    TextView goal_tv;
    float tcarb=0f,tprotein=0f,tfibre=0f,tfat=0f;
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

        initialize();

        FoodDetail f1 = dh.getFood(id);
        FoodDetail f2 = dh.getFood(id2);
        FoodDetail f3 = dh.getFood(id3);

        setText(f1,f2,f3);
        showGoal();
        //Log.e(TAG,f2.toString());


    }

    private void showGoal() {
        String success = "Goal Reached";
        String fail = "Goal Not Reached";
        String goal_Str = fail;
        String color = "red";
        SharedPreferences sh = getSharedPreferences(MyPref,MODE_PRIVATE);
        Float height = sh.getFloat("UHeight",20.0f);
        if(height<=55){
            if(tcarb>=37 && tprotein>=2 && tfat>=15 && tfibre>=3){
                goal_Str = success;
                color = "green";
            }
        }
        else if(height<=60){
            if(tcarb>=66 && tprotein>=7 && tfat>=24 && tfibre>=7){
                goal_Str = success;
                color = "green";
            }
        }
        else if(height<=65){
            if(tcarb>=101 && tprotein>=12 && tfat>=33 && tfibre>=11){
                goal_Str = success;
                color = "green";
            }
        }
        else{
            if(tcarb>=150 && tprotein>=16 && tfat>=40 && tfibre>=14){
                goal_Str = success;
                color = "green";
            }
        }

        if(goal_Str.equals(success)){
            goal_tv.setTextColor(Color.GREEN);
        }else{
            goal_tv.setTextColor(Color.RED);
        }

        goal_tv.setText(goal_Str);


    }


    private void setText(FoodDetail f1,FoodDetail f2,FoodDetail f3) {
        if(f1!=null) {
            Log.d(TAG,f1.toString());
            ed[0].setText(f1.getMeal_type());
            ed[1].setText(f1.getMeal_time());
            ed[2].setText(f1.getFood_name());
            ed[3].setText(f1.getInital());
            ed[4].setText(f1.getLeft_over());
            ed[5].setText(f1.getTotal());
            ed[6].setText(f1.getCarb());
            ed[7].setText(f1.getProtein());
            ed[8].setText(f1.getFibre());
            ed[9].setText(f1.getFats());
            tcarb += Float.parseFloat(f1.getCarb());
            tprotein += Float.parseFloat(f1.getProtein());
            tfibre += Float.parseFloat(f1.getFibre());
            tfat += Float.parseFloat(f1.getFats());
        }
        if(f2!=null) {
            Log.d(TAG,f2.toString());
            ed[10].setText(f2.getMeal_type());
            ed[11].setText(f2.getMeal_time());
            ed[12].setText(f2.getFood_name());
            ed[13].setText(f2.getInital());
            ed[14].setText(f2.getLeft_over());
            ed[15].setText(f2.getTotal());
            ed[16].setText(f2.getCarb());
            ed[17].setText(f2.getProtein());
            ed[18].setText(f2.getFibre());
            ed[19].setText(f2.getFats());
            tcarb += Float.parseFloat(f2.getCarb());
            tprotein += Float.parseFloat(f2.getProtein());
            tfibre += Float.parseFloat(f2.getFibre());
            tfat += Float.parseFloat(f2.getFats());
        }
        if(f3!=null) {
            Log.d(TAG,f3.toString());
            ed[20].setText(f3.getMeal_type());
            ed[21].setText(f3.getMeal_time());
            ed[22].setText(f3.getFood_name());
            ed[23].setText(f3.getInital());
            ed[24].setText(f3.getLeft_over());
            ed[25].setText(f3.getTotal());
            ed[26].setText(f3.getCarb());
            ed[27].setText(f3.getProtein());
            ed[28].setText(f3.getFibre());
            ed[29].setText(f3.getFats());
            tcarb += Float.parseFloat(f3.getCarb());
            tprotein += Float.parseFloat(f3.getProtein());
            tfibre += Float.parseFloat(f3.getFibre());
            tfat += Float.parseFloat(f3.getFats());
        }
    }


    private void initialize() {
        ed[0] = findViewById(R.id.tv00);
        ed[1] = findViewById(R.id.tv01);
        ed[2] = findViewById(R.id.tv02);
        ed[3] = findViewById(R.id.tv03);
        ed[4] = findViewById(R.id.tv04);
        ed[5] = findViewById(R.id.tv05);
        ed[6] = findViewById(R.id.tv06);
        ed[7] = findViewById(R.id.tv07);
        ed[8] = findViewById(R.id.tv08);
        ed[9] = findViewById(R.id.tv09);


        ed[10] = findViewById(R.id.tv10);
        ed[11] = findViewById(R.id.tv11);
        ed[12] = findViewById(R.id.tv12);
        ed[13] = findViewById(R.id.tv13);
        ed[14] = findViewById(R.id.tv14);
        ed[15] = findViewById(R.id.tv15);
        ed[16] = findViewById(R.id.tv16);
        ed[17] = findViewById(R.id.tv17);
        ed[18] = findViewById(R.id.tv18);
        ed[19] = findViewById(R.id.tv19);

        ed[20] = findViewById(R.id.tv20);
        ed[21] = findViewById(R.id.tv21);
        ed[22] = findViewById(R.id.tv22);
        ed[23] = findViewById(R.id.tv23);
        ed[24] = findViewById(R.id.tv24);
        ed[25] = findViewById(R.id.tv25);
        ed[26] = findViewById(R.id.tv26);
        ed[27] = findViewById(R.id.tv27);
        ed[28] = findViewById(R.id.tv28);
        ed[29] = findViewById(R.id.tv29);

        goal_tv = findViewById(R.id.goal_tv);

    }
}