package com.example.nutritionapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.nutritionapp.database.AppRepository;
import com.example.nutritionapp.database.ConsumedMealEntity;
import com.example.nutritionapp.database.FoodEntity;
import com.example.nutritionapp.database.MealEntity;
import com.example.nutritionapp.database.MeasureTypeEntity;
import com.example.nutritionapp.database.PortionedEntity;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainViewModel extends AndroidViewModel {

    // Mutable live data variables
    public MutableLiveData<FoodEntity> mLiveFood = new MutableLiveData<>();
    public MutableLiveData<List<FoodEntity>> mLiveFoods = new MutableLiveData<>();
    public LiveData<FoodEntity> mFood;
    public LiveData<List<FoodEntity>> mFoods;

    public MutableLiveData<ConsumedMealEntity> mLiveConsume = new MutableLiveData<>();
    public MutableLiveData<List<ConsumedMealEntity>> mLiveConsumed = new MutableLiveData<>();
    public LiveData<ConsumedMealEntity> mConsume;
    public LiveData<List<ConsumedMealEntity>> mConsumed;

    public MutableLiveData<MealEntity> mLiveMeal = new MutableLiveData<>();
    public MutableLiveData<List<MealEntity>> mLiveMeals = new MutableLiveData<>();
    public LiveData<MealEntity> mMeal;
    public LiveData<List<MealEntity>> mMeals;

    public MutableLiveData<MeasureTypeEntity> mLiveMeas = new MutableLiveData<>();
    public MutableLiveData<List<MeasureTypeEntity>> mLiveMeasures = new MutableLiveData<>();
    public LiveData<MeasureTypeEntity> mMeas;
    public LiveData<List<MeasureTypeEntity>> mMeasures;

    public MutableLiveData<PortionedEntity> mLivePortion = new MutableLiveData<>();
    public MutableLiveData<List<PortionedEntity>> mLivePortions = new MutableLiveData<>();
    public LiveData<PortionedEntity> mPortion;
    public LiveData<List<PortionedEntity>> mPortions;

    public static AppRepository mRepo;
    public Executor executor = Executors.newSingleThreadExecutor();

    public MainViewModel(@NonNull Application application) {
        super(application);

        mRepo = AppRepository.getInstance(getApplication());
        mConsumed = mRepo.mConsumed;
        mFoods = mRepo.mFoods;
        mMeals = mRepo.mMeals;
        mMeasures = mRepo.mMeasureTypes;
        mPortions = mRepo.mPortions;

    }

    // Method to get ids of portioned meal items from a string of ids separated by a colon(:)
    public static int[] getMealItemIds(String portionedIds){
        int[] mealItemIdArray = null;
        String[] stringIdArray = null;
        if(portionedIds != null) {
            stringIdArray = portionedIds.split(":");
            mealItemIdArray = new int[stringIdArray.length];
            for(int i = 0; i < stringIdArray.length; i++){
                mealItemIdArray[i] = Integer.parseInt(stringIdArray[i]);
            }
        }
        return mealItemIdArray;
    }

    // Method to return PortionedEntity variable from an integer array of portion ids that comprise a meal
    public static PortionedEntity getPortionedEntity(int[] mealItemIdArray){
        PortionedEntity item = null;

        if(mealItemIdArray != null){
            for(int i = 0; i < mealItemIdArray.length; i++){
                item = mRepo.getPortionById(mealItemIdArray[i]);
            }
        }

        return item;
    }
}
