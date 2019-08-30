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
    private String converterType;

    // Empty constructor
    @Ignore
    public MeasureTypeEntity(){}

    // Constructor, no primary key id
    @Ignore
    public MeasureTypeEntity(String converterType){
        this.converterType = converterType;
    }

    // Constructor with primary key id
    public MeasureTypeEntity(int measureTypeId, String converterType){
        this.measureTypeId = measureTypeId;
        this.converterType = converterType;
    }

    public int getMeasureTypeId(){
        return measureTypeId;
    }

    public String getConverterType(){
        return converterType;
    }

    // Setters
    public void setMeasureTypeId(int measureTypeId) {
        this.measureTypeId = measureTypeId;
    }

    public void setConverterType(String converterType) {
        this.converterType = converterType;
    }
}
