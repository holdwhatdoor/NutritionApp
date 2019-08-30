package com.example.nutritionapp.database;

import androidx.room.PrimaryKey;

public class MeasureTypeEntity {

    // Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int measureTypeId = 0;
    // Table Columns
    private String converterType;

    public int getMeasureTypeId(){
        return measureTypeId;
    }

    public String getConverterType(){
        return converterType;
    }

}
