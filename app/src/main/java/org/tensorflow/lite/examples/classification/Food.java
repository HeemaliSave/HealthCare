package org.tensorflow.lite.examples.classification;

public class Food {
    int id;
    String name,type1,type2;
    String carb,protein,fat,fibre;

    public Food(int id, String name, String type1, String type2, String carb, String protein, String fat, String fibre) {
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

    public String getCarb() {
        return carb;
    }

    public void setCarb(String carb) {
        this.carb = carb;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getFibre() {
        return fibre;
    }

    public void setFibre(String fibre) {
        this.fibre = fibre;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", carb='" + carb + '\'' +
                ", protein='" + protein + '\'' +
                ", fat='" + fat + '\'' +
                ", fibre='" + fibre + '\'' +
                '}';
    }
}

