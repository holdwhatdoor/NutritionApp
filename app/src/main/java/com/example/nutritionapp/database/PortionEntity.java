package com.example.nutritionapp.database;

import androidx.room.PrimaryKey;

public class PortionEntity {

    //Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int portionId = 0;


    // Getters
    public int getPortionId(){
        return portionId;
    }

}
