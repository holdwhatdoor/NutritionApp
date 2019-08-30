package com.example.nutritionapp.database;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface MeasureTypeDAO {

    LiveData<List<MeasureTypeEntity>> getAll();

}
