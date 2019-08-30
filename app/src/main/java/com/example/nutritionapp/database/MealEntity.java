package com.example.nutritionapp.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "meal_table")
public class MealEntity {

    // Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int mealId= 0;
    @ForeignKey(entity = PortionEntity.class, parentColumns = "portionId", childColumns = "mealId")
    private int portionId;
    @ForeignKey(entity = MeasureTypeEntity.class, parentColumns = "measureTypeId", childColumns = "mealId")
    private int measureTypeId;
    // Table Columns
    private String mealName;
    private Double mCals;
    private Double mCarbs;
    private Double mPro;
    private Double mFat;

    // Empty constructor
    @Ignore
    public MealEntity(){ }

    // Constructor, no primary key id
    @Ignore
    public MealEntity(int portionId, int measureTypeId, String mealName, Double mCals, Double mCarbs, Double mPro,
                      Double mFat){
        this.portionId = portionId;
        this.measureTypeId = measureTypeId;
        this.mealName = mealName;
        this.mCals = mCals;
        this.mCarbs = mCarbs;
        this.mPro = mPro;
        this.mFat = mFat;
    }

    // Constructor with primary key int id
    public MealEntity(int mealId, int portionId, int measureTypeId, String mealName, Double mCals, Double mCarbs,
                      Double mPro, Double mFat){
        this.mealId = mealId;
        this.portionId = portionId;
        this.measureTypeId = measureTypeId;
        this.mealName = mealName;
        this.mCals = mCals;
        this.mCarbs = mCarbs;
        this.mPro = mPro;
        this.mFat = mFat;
    }


    // Getters
    public int getMealId(){
        return mealId;
    }

    public int getPortionId(){
        return portionId;
    }

    public int getMeasureTypeId(){
        return measureTypeId;
    }

    public String getMealName(){
        return mealName;
    }

    public Double getMCals(){
        return mCals;
    }

    public Double getMCarbs(){
        return mCarbs;
    }

    public Double getMPro(){
        return mPro;
    }

    public Double getMFat(){
        return mFat;
    }

    // Setters
    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public void setPortionId(int portionId) {
        this.portionId = portionId;
    }

    public void setMeasureTypeId(int measureTypeId) {
        this.measureTypeId = measureTypeId;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setMCals(Double mCals) {
        this.mCals = mCals;
    }

    public void setMCarbs(Double mCarbs) {
        this.mCarbs = mCarbs;
    }

    public void setMPro(Double mPro) {
        this.mPro = mPro;
    }

    public void setMFat(Double mFat) {
        this.mFat = mFat;
    }
}
