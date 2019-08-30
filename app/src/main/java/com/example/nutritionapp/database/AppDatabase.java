package com.example.nutritionapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.nutritionapp.utilities.DateConverter;


@Database(entities = {FoodEntity.class, MeasureTypeEntity.class, PortionEntity.class,  MealEntity.class,
        ConsumedMealEntity.class},
        version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public static final String NUTRITION_DB = "AppDatabase.db";

    private static AppDatabase instance;
    private static final Object LOCK = new Object();


    public abstract FoodDAO foodDAO();

    public abstract MeasureTypeDAO measureTypeDAO();

    public abstract PortionDAO portionDAO();

    public abstract MealDAO mealDAO();

    public abstract ConsumedMealDAO consumedMealDAO();

    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            synchronized (LOCK){
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                            NUTRITION_DB)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }

}
