package org.tensorflow.lite.examples.classification;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
    String TAG = "SQLiteHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HealthCare";
    private static final String TABLE_FOODS = "Foods";
    private static final String Key_id = "id";
    private static final String Key1 = "meal_type",Key2="meal_time",Key3="food_name",Key4="initial",Key5="left_over",Key6="total",Key7="carb",
            Key8="protein",Key9="fibre",Key10="fat";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FOODS_TABLE = "CREATE TABLE " + TABLE_FOODS + "("
                + Key_id + " TEXT PRIMARY KEY ,"
                + Key1 + " TEXT ," + Key2 + " TEXT,"
                + Key3 + " TEXT," + Key4 + " TEXT," + Key5 + " TEXT," + Key6 + " TEXT,"
                + Key7 + " TEXT," + Key8 + " TEXT," + Key9 + " TEXT," + Key10 + " TEXT"+ ")";
        db.execSQL(CREATE_FOODS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // code to add the new contact
    void addContact(FoodDetail food) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Key_id, food.getId());
        values.put(Key1, food.getMeal_type());
        values.put(Key2, food.getMeal_time());
        values.put(Key3, food.getFood_name());
        values.put(Key4, food.getInital());
        values.put(Key5, food.getLeft_over());
        values.put(Key6, food.getTotal());
        values.put(Key7, food.getCarb());
        values.put(Key8, food.getProtein());
        values.put(Key9, food.getFibre());
        values.put(Key10, food.getFats());
    try {
        // Inserting Row
        db.insert(TABLE_FOODS, null, values);
    }catch (Exception e){

    }
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    FoodDetail getFood(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOODS, new String[] { Key_id,
                        Key1, Key2, Key3, Key4, Key5, Key6, Key7,
                        Key8, Key9, Key10}, Key_id + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        FoodDetail food = null;
        try {

            food = new FoodDetail(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9),
                    cursor.getString(10));

        }catch (Exception e){
            Log.e(TAG,e.toString());
        }
        return food;
    }
}
