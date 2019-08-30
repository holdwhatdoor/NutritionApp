package com.example.nutritionapp.database;

import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

public class PortionEntity {

    //Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int portionId = 0;
    @ForeignKey(entity = FoodEntity.class, parentColumns = "foodId", childColumns = "portionId")
    private int foodId;
    @ForeignKey(entity = MeasureTypeEntity.class, parentColumns = "measureTypeId", childColumns = "portionId")
    // Table Columns
    private Double quantity;
    private String description;
    private Double pCals;
    private Double pCarbs;
    private Double pPro;
    private Double pFat;

    // Getters
    public int getPortionId(){
        return portionId;
    }

    public Double getQuantity(){
        return quantity;
    }

    public String getDescription(){
        return description;
    }

    public Double getPCals(){
        return pCals;
    }

    public Double getPCarbs(){
        return pCarbs;
    }

    public Double getPPro(){
        return pPro;
    }

    public Double getPFat(){
        return pFat;
    }

}
