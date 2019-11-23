package com.example.nutritionapp.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    // Repository instance variable
    private static AppRepository repoInstance;
    // Live Data variables
    public LiveData<List<FoodEntity>> mFoods;
    public LiveData<List<MeasureTypeEntity>> mMeasureTypes;
    public LiveData<List<PortionedEntity>> mPortions;
    public LiveData<List<MealEntity>> mMeals;
    public LiveData<List<ConsumedMealEntity>> mConsumed;

    // Database variable and executor
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    // Returns instance of app repository
    public static AppRepository getInstance(Context context) {
        if (repoInstance == null) {
            repoInstance = new AppRepository(context);
        }
        return repoInstance;
    }

    // Gets all database repository information
    private AppRepository(Context context) {
        mDb = AppDatabase.getInstance(context);
        mFoods = getAllFoods();
        mMeasureTypes = getAllMeasureTypes();
        mPortions = getAllPortions();
        mMeals = getAllMeals();
        mConsumed = getAllConsumed();
    }

    // LiveData List getAllEntity methods
    private LiveData<List<FoodEntity>> getAllFoods() {
        return mDb.foodDAO().getAll();
    }

    private LiveData<List<MeasureTypeEntity>> getAllMeasureTypes() {
        return mDb.measureTypeDAO().getAll();
    }

    public LiveData<List<PortionedEntity>> getAllPortions() {
        return mDb.portionDAO().getAll();
    }

    public LiveData<List<MealEntity>> getAllMeals() {
        return mDb.mealDAO().getAll();
    }

    public LiveData<List<ConsumedMealEntity>> getAllConsumed() {
        return mDb.consumedMealDAO().getAll();
    }

    public ConsumedMealEntity getConsumedById(int consumedId) { return mDb.consumedMealDAO().getConsumedMealById(consumedId); }
    public FoodEntity getFoodById(int foodId) { return mDb.foodDAO().getFoodById(foodId); }
    public MealEntity getMealById(int mealId) { return mDb.mealDAO().getMealById(mealId); }
    public MeasureTypeEntity getMeasureTypeById(int measureId) { return mDb.measureTypeDAO().getMeasureTypeById(measureId); }
    public PortionedEntity getPortionById(int portionedId){ return mDb.portionDAO().getPortionById(portionedId); }

}
