package com.example.nutritionapp.database;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface PortionDAO {

    LiveData<List<PortionEntity>> getAll();

}
