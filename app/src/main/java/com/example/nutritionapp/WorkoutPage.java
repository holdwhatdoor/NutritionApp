package com.example.nutritionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class WorkoutPage extends AppCompatActivity implements View.OnClickListener {

    public Button addWkout;
    public Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.workout_page);

        Toolbar toolbar = findViewById(R.id.header_bar);
     //   setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addWkout = findViewById(R.id.wo_add_btn);
        addWkout.setOnClickListener(this);
        exit = findViewById(R.id.wo_exit_btn);
        exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wo_add_btn:
                break;
            case R.id.wo_exit_btn:
                Intent mainIntent = new Intent(this, MainPage.class);
                this.startActivity(mainIntent);
                break;
        }
    }
}
