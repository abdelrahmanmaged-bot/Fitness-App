package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ChooseHeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_height);

        EditText chooseHeight = findViewById(R.id.chooseHeight);
        ImageView add = findViewById(R.id.imgAdd);
        ImageView remove = findViewById(R.id.imgRemove);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(chooseHeight.getText().toString());
                num++;
                chooseHeight.setText(Integer.toString(num));
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(chooseHeight.getText().toString());
                num--;
                chooseHeight.setText(Integer.toString(num));
            }
        });

        int height = Integer.parseInt(chooseHeight.getText().toString());
    }
}