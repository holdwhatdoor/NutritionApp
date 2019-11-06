package com.example.nutritionapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PortionDAO {

    @Query("SELECT * FROM portioned_table WHERE portionedId = :id")
    PortionedEntity getPortionById(int id);

    @Query("SELECT * FROM portioned_table ORDER BY portionedId")
    LiveData<List<PortionedEntity>> getAll();

}
