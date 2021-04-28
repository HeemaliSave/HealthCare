package org.tensorflow.lite.examples.classification;

public class FoodDetail {
    String id,meal_type, meal_time, food_name,inital,left_over,total,carb,protein,fibre,fats;

    public FoodDetail(String id, String meal_type, String meal_time, String food_name, String inital, String left_over, String total, String carb, String protein, String fibre, String fats) {
        this.id = id;
        this.meal_type = meal_type;
        this.meal_time = meal_time;
        this.food_name = food_name;
        this.inital = inital;
        this.left_over = left_over;
        this.total = total;
        this.carb = carb;
        this.protein = protein;
        this.fibre = fibre;
        this.fats = fats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeal_type() {
        return meal_type;
    }

    public void setMeal_type(String meal_type) {
        this.meal_type = meal_type;
    }

    public String getMeal_time() {
        return meal_time;
    }

    public void setMeal_time(String meal_time) {
        this.meal_time = meal_time;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getInital() {
        return inital;
    }

    public void setInital(String inital) {
        this.inital = inital;
    }

    public String getLeft_over() {
        return left_over;
    }

    public void setLeft_over(String left_over) {
        this.left_over = left_over;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    public String getFibre() {
        return fibre;
    }

    public void setFibre(String fibre) {
        this.fibre = fibre;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    @Override
    public String toString() {
        return "FoodDetail{" +
                "id='" + id + '\'' +
                ", meal_type='" + meal_type + '\'' +
                ", meal_time='" + meal_time + '\'' +
                ", food_name='" + food_name + '\'' +
                ", inital='" + inital + '\'' +
                ", left_over='" + left_over + '\'' +
                ", total='" + total + '\'' +
                ", carb='" + carb + '\'' +
                ", protein='" + protein + '\'' +
                ", fibre='" + fibre + '\'' +
                ", fats='" + fats + '\'' +
                '}';
    }
}
