package org.tensorflow.lite.examples.classification;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.security.Key;
import java.util.ArrayList;

public class DBHelper {
    public ArrayList<Food> getAllFood() {
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food(0, "beans", "p", "f", "60", "24", "0.8", "25"));
        foods.add(new Food(1, "blueberry", "f", "c", "14", "0.7", "0.3", "2.4"));
        foods.add(new Food(2, "carrot", "f", "c", "9.58", "0.93", "0.24", "5"));
        foods.add(new Food(3, "cheerios", "c", "p", "83", "6", "5", "0.4"));
        foods.add(new Food(4, "mango", "c", "fs", "15", "0.8", "0.4", "1.6"));
        foods.add(new Food(5, "milk", "p", "c", "5", "3.4", "1", "0"));
        foods.add(new Food(6, "rice", "c", "f", "28", "2.7", "0.3", "0.4"));
        foods.add(new Food(7, "lentils", "p", "f", "20", "9", "0.4", "11"));
        foods.add(new Food(8, "yoghurt", "p", "p", "3.6", "10", "0.4", "0"));
        foods.add(new Food(9, "banana", "c", "fs", "23", "1.3", "0.5", "3.1"));
        foods.add(new Food(10, "potato", "c", "fs", "17", "2.2", "0.5", "2.6"));
        foods.add(new Food(11, "apples", "c", "f", "14", "0.3", "0.2", "4"));
        foods.add(new Food(12, "pears", "c", "f", "27", "1"  , "0.25", "6"));
        foods.add(new Food(14, "spinach", "f", "p", "1.1", "2.9", "0.4", "4"));
        return foods;
    }

    public Food getFoodByName(String name) {
        ArrayList<Food> allfood = getAllFood();
        for (Food food : allfood) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }
}

    // Sqllite database


