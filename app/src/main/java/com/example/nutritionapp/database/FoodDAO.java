package com.example.nutritionapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FoodDAO {

    @Query("SELECT * FROM food_table WHERE foodId = :id")
    FoodEntity getFoodById(int id);

    @Query("SELECT * FROM food_table ORDER BY foodId")
    LiveData<List<FoodEntity>> getAll();

}
