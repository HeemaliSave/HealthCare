package org.tensorflow.lite.examples.classification;

public class Food {
    int id;
    String name,type1,type2;
    float carb,protein,fat,fibre;

    public Food(int id, String name, String type1, String type2, float carb, float protein, float fat, float fibre) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.carb = carb;
        this.protein = protein;
        this.fat = fat;
        this.fibre = fibre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public float getCarb() {
        return carb;
    }

    public void setCarb(float carb) {
        this.carb = carb;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getFibre() {
        return fibre;
    }

    public void setFibre(float fibre) {
        this.fibre = fibre;
    }
}

