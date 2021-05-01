package org.tensorflow.lite.examples.classification;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class suggest extends AppCompatActivity {
    float total_carb=0,total_protein=0,total_fat=0,total_fibre=0;
    final String MyPref = "ProfileDetail";
    DatabaseHandler dh;
    TextView suggest_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggest);

        suggest_text = findViewById(R.id.tv_suggest);

        dh = new DatabaseHandler(this);
        getDataFromDB();
        readLocalStorage();

        apiCall();

    }

    private void readLocalStorage() {
        SharedPreferences sh = getSharedPreferences(MyPref,MODE_PRIVATE);
        Float height = sh.getFloat("UHeight",20.0f);
        Float weight = sh.getFloat("UWeight",45.0f);

        float carbt,proteint,fatt,fibret;
        if(height<=55){
            carbt = 37;
            proteint = 2;
            fatt = 15;
            fibret = 3;
        }
        else if(height<=60){
            carbt = 66;
            proteint = 7;
            fatt = 24;
            fibret = 7;
        }
        else if(height<=65){
            carbt = 101;
            proteint = 12;
            fatt = 33;
            fibret = 11;
        }
        else{
            carbt = 150;
            proteint = 16;
            fatt = 40;
            fibret = 14;
        }
        if(total_fat>fatt){
            total_fat = 0;
        }else{
            total_fat = fatt - total_fat;
        }

        if(total_protein>proteint){
            total_protein = 0;
        }else{
            total_protein = proteint - total_protein;
        }

        if(total_carb>carbt){
            total_carb = 0;
        }else{
            total_carb = carbt - total_carb;
        }

        if(total_fibre>fibret){
            total_fibre = 0;
        }else{
            total_fibre = fibret - total_fibre;
        }
    }

    private void getDataFromDB() {
        String id = String.valueOf(gettimeinmili());
        String id2 = String.valueOf(Long.parseLong(id)+1);
        String id3 = String.valueOf(Long.parseLong(id)+2);

        FoodDetail f1 = dh.getFood(id);
        FoodDetail f2 = dh.getFood(id2);
        FoodDetail f3 = dh.getFood(id3);
        if(f1!=null) {
            total_carb += Float.parseFloat(f1.getCarb());
            total_protein += Float.parseFloat(f1.getProtein());
            total_fat += Float.parseFloat(f1.getFats());
            total_fibre += Float.parseFloat(f1.getFibre());
        }
        if(f2!=null){
            total_carb += Float.parseFloat(f2.getCarb());
            total_protein += Float.parseFloat(f2.getProtein());
            total_fat += Float.parseFloat(f2.getFats());
            total_fibre += Float.parseFloat(f2.getFibre());
        }
        if(f3!=null){
            total_carb += Float.parseFloat(f3.getCarb());
            total_protein += Float.parseFloat(f3.getProtein());
            total_fat += Float.parseFloat(f3.getFats());
            total_fibre += Float.parseFloat(f3.getFibre());
        }
    }

    private long gettimeinmili() {
        long timeInmili = 10l;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String dateString = formatter.format(date);
        try{
            //formatting the dateString to convert it into a Date
            Date date2 = formatter.parse(dateString);
            timeInmili = date2.getTime();
        }catch(ParseException e){
            e.printStackTrace();
        }

        return timeInmili;
    }

    private void apiCall() {
        String url = "http://10.0.2.2:8000/?carb="+total_carb+"&protein="+total_protein+"&fat="+total_fat+"&fibre="+total_fibre;
        RequestQueue requestQueue;

        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonrequestQueue;
        jsonrequestQueue = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("TestingApi","Carb: "+ total_carb +", Fat: "+total_fat+", Fibre: "+total_fibre+", Protein: "+total_protein);
                    Log.d("TestingApi",response.getString("data"));
                    suggest_text.setText(response.getString("data"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TestingApi","Something wrong "+error.toString());
            }
        });
//        jsonrequestQueue.setRetryPolicy(new RetryPolicy() {
//            @Override
//            public int getCurrentTimeout() {
//                return 50000;
//            }
//
//            @Override
//            public int getCurrentRetryCount() {
//                return 50000;
//            }
//
//            @Override
//            public void retry(VolleyError error) throws VolleyError {
//
//            }
//        });
        requestQueue.add(jsonrequestQueue);
    }
}