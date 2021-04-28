package org.tensorflow.lite.examples.classification;


import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class record extends AppCompatActivity {
    CalendarView calender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);

        calender = (CalendarView)
                findViewById(R.id.calender);
        

        // Add Listener in calendar
        calender
                .setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override

                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {

                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index is start with 0
                                String Date
                                        = dayOfMonth + "-"
                                        + (month+1) + "-" + year;

                                // set this date in TextView for Display
                                Intent intent = new Intent(record.this, RecordDetail.class);
                                intent.putExtra("currentDate",Date);
                                startActivity(intent);
                            }
                        });
    }
}