package com.example.nutritionapp.database;

import androidx.room.PrimaryKey;

public class ConsumedMealEntity {

    // Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int consumedId = 0;


    // Getters
    public int getConsumedId(){
        return consumedId;
    }


}
