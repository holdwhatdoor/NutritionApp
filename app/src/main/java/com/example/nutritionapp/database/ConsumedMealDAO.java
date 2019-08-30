package com.example.nutritionapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ConsumedMealDAO {

    @Query("SELECT * FROM consumed_meal WHERE consumedId = :id")
    ConsumedMealEntity getConsumedMealById(int id);

    @Query("SELECT * FROM consumed_meal ORDER BY consumedId")
    LiveData<List<ConsumedMealEntity>> getAll();

}
