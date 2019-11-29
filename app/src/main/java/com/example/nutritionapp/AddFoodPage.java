package com.example.nutritionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.nutritionapp.database.AppRepository;
import com.example.nutritionapp.database.FoodEntity;

import java.util.List;

public class AddFoodPage extends AppCompatActivity implements View.OnClickListener {

    AppRepository appRepo;
    List<FoodEntity> allFoods = (List<FoodEntity>) appRepo.mFoods;

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

                break;
            case R.id.af_cancel_btn:
                Intent dietIntent = new Intent(this, DietPage.class);
                this.startActivity(dietIntent);
                break;
            case R.id.af_clear_btn:
                break;
        }
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

        return validInput;
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

}
