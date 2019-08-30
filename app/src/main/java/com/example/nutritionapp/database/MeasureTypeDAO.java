package com.example.nutritionapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MeasureTypeDAO {

    @Query("SELECT * FROM measure_type_table WHERE measureTypeId = :id")
    MeasureTypeEntity getMeasureTypeById(int id);

    @Query("SELECT * FROM measure_type_table ORDER BY measureTypeId")
    LiveData<List<MeasureTypeEntity>> getAll();

}
