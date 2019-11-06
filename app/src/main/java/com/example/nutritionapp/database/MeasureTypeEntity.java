package com.example.nutritionapp.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "measure_type_table")
public class MeasureTypeEntity {

    // Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int measureTypeId = 0;
    // Table Columns
    private String measureType;

    // Empty constructor
    @Ignore
    public MeasureTypeEntity(){}

    // Constructor, no primary key id
    @Ignore
    public MeasureTypeEntity(String measureType){
        this.measureType = measureType;
    }

    // Constructor with primary key id
    public MeasureTypeEntity(int measureTypeId, String measureType){
        this.measureTypeId = measureTypeId;
        this.measureType = measureType;
    }

    public int getMeasureTypeId(){
        return measureTypeId;
    }

    public String getMeasureType(){
        return measureType;
    }

    // Setters
    public void setMeasureTypeId(int measureTypeId) {
        this.measureTypeId = measureTypeId;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }
}
