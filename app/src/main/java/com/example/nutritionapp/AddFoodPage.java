package com.example.nutritionapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.example.nutritionapp.database.AppRepository;
import com.example.nutritionapp.database.FoodEntity;
import com.example.nutritionapp.viewmodel.AddFoodViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class AddFoodPage extends AppCompatActivity implements View.OnClickListener {

    AppRepository appRepo;
    AddFoodViewModel foodVM;
    List<FoodEntity> foodData = new ArrayList<>();

    EditText foodNmEdit;

    RadioGroup measureType;
    RadioButton oz;
    RadioButton g;

    EditText calories;
    EditText carbs;
    EditText protein;
    EditText fat;

    Button addBtn;
    Button clearBtn;
    Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_food);

        Toolbar toolbar = findViewById(R.id.header_bar);
     //   setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodNmEdit = findViewById(R.id.af_name_in);
        measureType = findViewById(R.id.af_mt_rdo_grp);
        oz = findViewById(R.id.af_radio_oz);
        g = findViewById(R.id.af_radio_g);
        calories = findViewById(R.id.af_cal_in);
        carbs = findViewById(R.id.af_carb_in);
        protein = findViewById(R.id.af_pro_in);
        fat = findViewById(R.id.af_fat_in);

        addBtn = findViewById(R.id.af_add_btn);
        addBtn.setOnClickListener(this);

        cancelBtn = findViewById(R.id.af_cancel_btn);
        cancelBtn.setOnClickListener(this);

        clearBtn = findViewById(R.id.af_clear_btn);
        clearBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.af_add_btn:
                if(validInput()){
                    String foodName = foodNmEdit.getText().toString();
                    Double cals = Double.parseDouble(calories.getText().toString());
                    Double carbos = Double.parseDouble(carbs.getText().toString());
                    Double pro = Double.parseDouble(protein.getText().toString());
                    Double fats = Double.parseDouble(fat.getText().toString());
                    String baseMeas = getSelectedMeasure();

                    FoodEntity newFood = new FoodEntity(foodName, cals, carbos, pro, fats, baseMeas);
                    System.out.println("New Food: " + newFood.getFoodId() + ", " + newFood.getFoodName() +
                            ", " + newFood.getCalories() + "cals, " + newFood.getCarbs() + "carbs, " +
                            newFood.getProtein() + "pro, " + newFood.getFat() + "fat, " + newFood.getBaseMeasure());
                    foodVM.insertFood(newFood);

                    foodNmEdit.getText().clear();
                    calories.getText().clear();
                    carbs.getText().clear();
                    protein.getText().clear();
                    fat.getText().clear();
                    measureType.clearCheck();

                    Context context = getApplicationContext();
                    String text = "Insert Successful";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    foodData = (List<FoodEntity>) appRepo.mFoods;

                    String foodsTxt = listDBFoodInfo(foodData);
                    int dbDuration = Toast.LENGTH_LONG;
                    Toast dbToast = Toast.makeText(context,foodsTxt, dbDuration);
                    dbToast.show();

                }
                break;
            case R.id.af_cancel_btn:
                Intent dietIntent = new Intent(this, DietPage.class);
                this.startActivity(dietIntent);
                break;
            case R.id.af_clear_btn:
                foodNmEdit.getText().clear();
                calories.getText().clear();
                carbs.getText().clear();
                protein.getText().clear();
                fat.getText().clear();
                measureType.clearCheck();
                break;
        }
    }

    public String listDBFoodInfo(List<FoodEntity> foods){
        String foodList = null;
        if(foods !=null) {
            for (int i = 0; i < foods.size(); i++){
                FoodEntity foodEntity = foods.get(i);
                int foodId = foodEntity.getFoodId();
                String foodName = foodEntity.getFoodName();
                Double cals = foodEntity.getCalories();
                Double carbs = foodEntity.getCarbs();
                Double protein = foodEntity.getProtein();
                Double fats = foodEntity.getFat();
                String meas = foodEntity.getBaseMeasure();

                foodList = "Food Id: " + foodId + ", Food name: " + foodName + ", Calories: " + cals +
                        ", Carbs: " + carbs + ", Protein: " + protein + ", Fat: " + fats + ", Base Measure: " +
                        meas;
                foodList = foodList + "\n";
             }
        }
        return foodList;
    }

    private boolean duplicateFoodEntry(FoodEntity newFood){
        boolean isDuplicate = false;


        return isDuplicate;
    }

    private boolean validInput(){
        boolean validInput = true;

        if(foodNmEdit.getText() == null){
            validInput = false;
            emptyFoodName();
        }
        if(calories.getText() == null) {
            validInput = false;
            emptyCals();
        }
        if(carbs.getText() == null){
            validInput = false;
            emptyCarbs();
        }
        if(protein.getText() == null){
            validInput = false;
            emptyProtein();
        }
        if(fat.getText() == null){
            validInput = false;
            emptyFat();
        }
        if(!oz.isChecked() && !g.isChecked()){
            validInput = false;
            noMeasureSelected();
        }
        return validInput;
    }

    public String getSelectedMeasure(){
        String selectedMeasure = null;
        if(oz.isChecked()){
            selectedMeasure = "ounces";
        }
        else if(g.isChecked()){
            selectedMeasure = "grams";
        }
        return selectedMeasure;
    }

    public void emptyFoodName(){
        AlertDialog.Builder emptyInput = new AlertDialog.Builder(this);
        emptyInput.setTitle("Food name input blank.");
        emptyInput.setMessage("Please fill in a valid food name.");
        emptyInput.setPositiveButton("OK", (dialog, which) -> {
        });
        emptyInput.create().show();
    }

    public void emptyCals(){
        AlertDialog.Builder emptyInput = new AlertDialog.Builder(this);
        emptyInput.setTitle("Calories input blank.");
        emptyInput.setMessage("Please fill in a valid calorie quantity.");
        emptyInput.setPositiveButton("OK", (dialog, which) -> {
        });
        emptyInput.create().show();
    }

    public void emptyCarbs(){
        AlertDialog.Builder emptyInput = new AlertDialog.Builder(this);
        emptyInput.setTitle("Carbs input blank.");
        emptyInput.setMessage("Please fill in a valid calorie quantity.");
        emptyInput.setPositiveButton("OK", (dialog, which) -> {
        });
        emptyInput.create().show();
    }

    public void emptyProtein(){
        AlertDialog.Builder emptyInput = new AlertDialog.Builder(this);
        emptyInput.setTitle("Protein input blank.");
        emptyInput.setMessage("Please fill in a valid protein quantity.");
        emptyInput.setPositiveButton("OK", (dialog, which) -> {
        });
        emptyInput.create().show();
    }

    public void emptyFat(){
        AlertDialog.Builder emptyInput = new AlertDialog.Builder(this);
        emptyInput.setTitle("Fat input blank.");
        emptyInput.setMessage("Please fill in a valid fat quantity.");
        emptyInput.setPositiveButton("OK", (dialog, which) -> {
        });
        emptyInput.create().show();
    }

    public void noMeasureSelected(){
        AlertDialog.Builder noneSelected = new AlertDialog.Builder(this);
        noneSelected.setTitle("No Measure Type selected.");
        noneSelected.setMessage("No base measure type selected.  Please select a measure type.");
        noneSelected.setPositiveButton("OK", (dialog, which) -> {
        });
        noneSelected.create().show();
    }

}
