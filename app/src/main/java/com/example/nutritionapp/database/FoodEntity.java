package com.example.nutritionapp.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_table")
public class FoodEntity {

    // Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int foodId = 0;
    // Table Columns
    private String foodName;
    private String calories;
    private String carbs;
    private String protein;
    private String fat;
    private String baseMeasure;

    // Empty constructor
    @Ignore
    public FoodEntity(){}

    // Constructor, no primary key id
    @Ignore
    public FoodEntity(String foodName, String calories, String carbs, String protein, String fat, String baseMeasure){
        this.foodName = foodName;
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.baseMeasure = baseMeasure;
    }

    // Constructor with primary key id
    public FoodEntity(int foodId, String foodName, String calories, String carbs, String protein, String fat,
                      String baseMeasure){
        this.foodId = foodId;
        this.foodName = foodName;
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
        this.baseMeasure = baseMeasure;
    }

    // Getters
    public int getFoodId(){
        return foodId;
    }

    public String getFoodName(){
        return foodName;
    }

    public String getCalories(){
        return calories;
    }

    public String getCarbs(){
        return carbs;
    }

    public String getProtein(){
        return protein;
    }

    public String getFat(){
        return fat;
    }

    public String getBaseMeasure(){
        return baseMeasure;
    }

    // Setters
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public void setBaseMeasure(String baseMeasure) {
        this.baseMeasure = baseMeasure;
    }
}
