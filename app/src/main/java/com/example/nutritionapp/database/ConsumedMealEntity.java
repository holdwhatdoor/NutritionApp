package com.example.nutritionapp.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "consumed_meal")
public class ConsumedMealEntity {

    // Table Key Columns
    @PrimaryKey(autoGenerate = true)
    private int consumedId = 0;
    private Date consumedTime;

    // Empty constructor
    @Ignore
    public ConsumedMealEntity(){}

    // Constructor, no primary key id
    @Ignore
    public ConsumedMealEntity(Date consumedTime){
        this.consumedTime = consumedTime;
    }

    // Constructor with primary key id
    public ConsumedMealEntity(int consumedId, Date consumedTime){
        this.consumedId = consumedId;
        this.consumedTime = consumedTime;
    }

    // Getters
    public int getConsumedId(){
        return consumedId;
    }

    public Date getConsumedTime(){
        return consumedTime;
    }

    // Setters
    public void setConsumedId(int consumedId) {
        this.consumedId = consumedId;
    }

    public void setConsumedTime(Date consumedTime) {
        this.consumedTime = consumedTime;
    }
}
