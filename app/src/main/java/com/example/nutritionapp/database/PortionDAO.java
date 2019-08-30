package com.example.nutritionapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PortionDAO {

    @Query("SELECT * FROM portion_table WHERE portionId = :id")
    PortionEntity getPortionById(int id);

    @Query("SELECT * FROM portion_table ORDER BY portionId")
    LiveData<List<PortionEntity>> getAll();

}
