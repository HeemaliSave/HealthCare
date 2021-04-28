package org.tensorflow.lite.examples.classification;

import java.util.ArrayList;

public class DBHelper {
    public ArrayList<Food> getAllFood(){
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food(0,"beans","p","f",60,24,0.8f,25));
        foods.add(new Food(1,"blueberry","f","c",14,0.7f,0.3f,2.4f));
        foods.add(new Food(2,"carrot","f","c",9.58f,0.93f,0.24f,5));
        foods.add(new Food(3,"cheerios","c","p",83,6,5,0.4f));
        foods.add(new Food(4,"mango","c","fs",15,0.8f,0.4f,1.6f));
        foods.add(new Food(5,"milk","p","c",5,3.4f,1,0));
        foods.add(new Food(6,"rice","c","f",28,2.7f,0.3f,0.4f));
        foods.add(new Food(7,"lentils","p","f",20,9,0.4f,11));
        foods.add(new Food(8,"yoghurt","p","p",3.6f,10,0.4f,0));
        foods.add(new Food(9,"banana","c","fs",23,1.3f,0.5f,3.1f));
        foods.add(new Food(10,"potato","c","fs",17,2.2f,0.5f,2.6f));
        foods.add(new Food(11,"apples","c","f",14,0.3f,0.2f,4));
        foods.add(new Food(12,"pears","c","f",27,1,0.25f,6));
        foods.add(new Food(14,"spinach","f","p",1.1f,2.9f,0.4f,4));


        return foods;
    }
}
