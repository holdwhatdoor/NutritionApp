package com.example.nutritionapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDAO {

    @Query("SELECT * FROM meal_table WHERE mealId = :id")
    MealEntity getMealById(int id);

    @Query("SELECT * FROM meal_table ORDER BY mealId")
    LiveData<List<MealEntity>> getAll();

}
