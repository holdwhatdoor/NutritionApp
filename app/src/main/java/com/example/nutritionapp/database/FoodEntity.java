package com.example.nutritionapp.database;

import androidx.room.PrimaryKey;

public class FoodEntity {

    // Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int foodId = 0;
    // Table Columns
    private String foodName;
    private double calories;
    private double carbs;
    private double protein;
    private double fat;
    private double baseMeasure;

    // Getters
    public int getFoodId(){
        return foodId;
    }

    public String getFoodName(){
        return foodName;
    }

    public double getCalories(){
        return calories;
    }

    public double getCarbs(){
        return carbs;
    }

    public double getProtein(){
        return protein;
    }

    public double getFat(){
        return fat;
    }

    public double getBaseMeasure(){
        return baseMeasure;
    }
}
