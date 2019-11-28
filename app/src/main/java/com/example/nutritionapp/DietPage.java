package com.example.nutritionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DietPage extends AppCompatActivity implements View.OnClickListener{

    public Button addFoodBtn;
    public Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.diet_page);

        Toolbar toolbar = findViewById(R.id.header_bar);
     //   setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addFoodBtn = findViewById(R.id.dp_add_food_btn);
        addFoodBtn.setOnClickListener(this);

        exitBtn = findViewById(R.id.dp_exit_btn);
        exitBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dp_add_food_btn:
                Intent addFoodIntent = new Intent(this, AddFoodPage.class);
                this.startActivity(addFoodIntent);
                break;
            case R.id.dp_exit_btn:
                Intent exitIntent = new Intent(this, MainPage.class);
                this.startActivity(exitIntent);
                break;
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        //   mDataSource.close();
    }

    @Override
    protected void onResume(){
        super.onResume();
        //     mDataSource.open();
    }
}
