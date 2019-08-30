package com.example.nutritionapp.database;

import androidx.room.PrimaryKey;

public class FoodEntity {

    // Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int foodId = 0;


    // Getters
    public int getFoodId(){
        return foodId;
    }

}
