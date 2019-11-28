package com.example.nutritionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddFoodPage extends AppCompatActivity implements View.OnClickListener {

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
}
