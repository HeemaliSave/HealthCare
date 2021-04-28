package org.tensorflow.lite.examples.classification;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class ProfilePage extends AppCompatActivity {

    EditText name,age,height,weight;
    Button update,back;
    final String MyPref = "ProfileDetail";
    String sname,sage;
    Float sheight,sweight;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        name = (EditText)findViewById(R.id.ename);
        age = (EditText)findViewById(R.id.eage);
        height = (EditText)findViewById(R.id.eheight);
        weight = (EditText)findViewById(R.id.eweight);
        update = (Button)findViewById(R.id.update_btn);
        sp = getSharedPreferences(MyPref,MODE_PRIVATE);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname = name.getText().toString();
                sage = age.getText().toString();
                sheight = Float.parseFloat(height.getText().toString());
                sweight = Float.parseFloat(weight.getText().toString());
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("UName",sname);
                editor.putString("UAge",sage);
                editor.putFloat("UWeight",sweight);
                editor.putFloat("UHeight",sheight);
                editor.apply();

            }
        });
        setValues();
    }

    private void setValues() {
        SharedPreferences sh = getSharedPreferences(MyPref,MODE_PRIVATE);
        String name1 = sh.getString("UName","");

        String  age1 = sh.getString("UAge","");

        Log.d("age",age1);
        Float height1 = sh.getFloat("UHeight",0f);
        Float weight1 = sh.getFloat("UWeight",0f);
        name.setText(name1);
        age.setText(age1);
        if(height1!=0){
            height.setText(height1.toString());
        }
        if(weight1!=0){
            weight.setText(weight1.toString()
            );
        }
    }

}