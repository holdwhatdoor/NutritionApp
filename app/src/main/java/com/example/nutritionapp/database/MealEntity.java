package com.example.nutritionapp.database;

import androidx.room.PrimaryKey;

public class MealEntity {

    // Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int mealId= 0;


    // Getters
    public int getMealId(){
        return mealId;
    }

}
