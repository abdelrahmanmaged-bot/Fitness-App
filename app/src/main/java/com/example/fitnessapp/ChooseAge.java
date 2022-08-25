package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseAge extends AppCompatActivity {

    private TextView selected;
    private NumberPicker numPick;
    private Button btnContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_age);

        selected = findViewById(R.id.txtSelected);
        numPick = findViewById(R.id.numPick);

        numPick.setMinValue(1);
        numPick.setMaxValue(120);
        numPick.setValue(18);

        numPick.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                selected.setText("Selected: " + newValue);
            }
        });

        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numPick.getValue() < 18) {
                    Toast.makeText(getApplicationContext(), "You're too young for this, kiddo", Toast.LENGTH_SHORT).show();
                }
                else if (numPick.getValue() > 100) {
                    Toast.makeText(getApplicationContext(), "You should be dead, grandpa", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(ChooseAge.this, ChooseActivityLevel.class);
                    startActivity(i);
                }
            }
        });


    }
}