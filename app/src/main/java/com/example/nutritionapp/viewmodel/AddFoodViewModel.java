package com.example.nutritionapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nutritionapp.database.AppRepository;
import com.example.nutritionapp.database.FoodEntity;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AddFoodViewModel extends AndroidViewModel {

    public MutableLiveData<FoodEntity> mLiveFood = new MutableLiveData<>();
    public LiveData<FoodEntity> mFood;
    public LiveData<List<FoodEntity>> mFoods;

    public AppRepository mRepo;
    public Executor executor = Executors.newSingleThreadExecutor();

    public AddFoodViewModel(@NonNull Application application) {
        super(application);
        mRepo = AppRepository.getInstance(getApplication());
        mFoods = mRepo.mFoods;

    }

    public void insertFood(FoodEntity newFood){
        mRepo.insertFood(newFood);
    }

    public void deleteFood(int foodId){
        mRepo.deleteFood(mRepo.getFoodById(foodId));
    }
}
