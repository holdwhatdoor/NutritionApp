package com.example.nutritionapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ConsumedMealDAO {

    @Query("SELECT * FROM consumed_meal WHERE consumedId = :id")
    ConsumedMealEntity getConsumedMealById(int id);

    @Query("SELECT * FROM consumed_meal ORDER BY consumedId")
    LiveData<List<ConsumedMealEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertConsumed(ConsumedMealEntity consumedMealEntity);

    @Delete
    void deleteConsumed(ConsumedMealEntity consumedMealEntity);

}
