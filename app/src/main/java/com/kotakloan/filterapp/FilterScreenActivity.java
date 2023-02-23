package com.kotakloan.filterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FilterScreenActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout linerLylBlackWhite,linerLylBlackSketch,linerLylCartoon,linerLylRainbow,linerLyl3D;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fliter_screen);
        initView();
    }

    private void initView() {
        SharedPreferences sharedPreferences = getSharedPreferences("FilterApp",MODE_PRIVATE);
         editor = sharedPreferences.edit();
         linerLylBlackWhite = findViewById(R.id.linerLylBlackWhite);
        linerLylBlackSketch = findViewById(R.id.linerLylBlackSketch);
        linerLylCartoon = findViewById(R.id.linerLylCartoon);
        linerLylRainbow = findViewById(R.id.linerLylRainbow);
        linerLyl3D = findViewById(R.id.linerLyl3D);
        linerLylBlackWhite.setOnClickListener(this);
        linerLylBlackSketch.setOnClickListener(this);
        linerLylCartoon.setOnClickListener(this);
        linerLylRainbow.setOnClickListener(this);
        linerLyl3D.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.linerLylBlackWhite:
                editor.putString("filterType", "BlackWhite");
                editor.commit();
                Intent next = new Intent(FilterScreenActivity.this, ChooseImageActivity.class);
                startActivity(next);
                break;
            case R.id.linerLylBlackSketch:
                editor.putString("filterType", "Sketch");
                editor.commit();
                next = new Intent(FilterScreenActivity.this, ChooseImageActivity.class);
                startActivity(next);
                break;
            case R.id.linerLylCartoon:
                editor.putString("filterType", "Cartoon");
                editor.commit();
                next = new Intent(FilterScreenActivity.this, ChooseImageActivity.class);
                startActivity(next);
                break;
            case R.id.linerLylRainbow:
                editor.putString("filterType", "Rainbow");
                editor.commit();
                next = new Intent(FilterScreenActivity.this, ChooseImageActivity.class);
                startActivity(next);
                break;
            case R.id.linerLyl3D:
                editor.putString("filterType", "Reflection");
                editor.commit();
                next = new Intent(FilterScreenActivity.this, ChooseImageActivity.class);
                startActivity(next);
                break;


        }

    }
}