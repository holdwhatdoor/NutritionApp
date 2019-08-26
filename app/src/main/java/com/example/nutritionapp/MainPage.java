package com.example.nutritionapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import javax.sql.DataSource;

public class MainPage extends AppCompatActivity {

    DataSource mDataSource;
    public TextView diet;
    public TextView exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mainpage);

        Toolbar toolbar = findViewById(R.id.header_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



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




    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);

        return super.onCreateOptionsMenu(menu);
    }

}
