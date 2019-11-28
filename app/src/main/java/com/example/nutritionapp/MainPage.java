package com.example.nutritionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import javax.sql.DataSource;

public class MainPage extends AppCompatActivity implements View.OnClickListener{

    DataSource mDataSource;
    public TextView diet;
    public TextView workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mainpage);

        Toolbar toolbar = findViewById(R.id.header_bar);
        //  setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        diet = findViewById(R.id.diet_lbl);
        diet.setOnClickListener(this);
        workout = findViewById(R.id.workout_lbl);
        workout.setOnClickListener(this);

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


    @Override
    public void onClick(View v){
        switch (v.getId()){

            case R.id.diet_lbl:
                Intent dietIntent = new Intent(this, DietPage.class);
                this.startActivity(dietIntent);
                break;
            case R.id.workout_lbl:
                Intent wkoutIntent = new Intent(this, WorkoutPage.class);
                this.startActivity(wkoutIntent);
                break;

        }


    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);

        return super.onCreateOptionsMenu(menu);
    }

}
