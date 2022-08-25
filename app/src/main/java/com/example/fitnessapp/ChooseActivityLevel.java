package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ChooseActivityLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);

        Spinner chooseLevel = findViewById(R.id.chooseLevel);
        TextView description = findViewById(R.id.txtDescription);
        chooseLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem =  chooseLevel.getSelectedItem().toString();
                if (selectedItem.equals("No Exercise")) {
                    description.setText("Only normal daily movements in a relaxed manner.");
                }
                if (selectedItem.equals("Little Exercise")) {
                    description.setText("Some activities throughout the day.\ne.g. easy walking, standing, cooking");
                }
                if (selectedItem.equals("Moderate Exercise")) {
                    description.setText("6-8 hours of weekly exercise\ne.g. Fast Walking, Jogging, Dancing, Cycling");
                }
                if (selectedItem.equals("Hard Exercise")) {
                    description.setText("12-15 hours of weekly exercise.\ne.g. Competition Races, Sprinting, Strength training");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChooseActivityLevel.this, ChooseWeight.class);
                startActivity(i);
            }
        });
    }
}