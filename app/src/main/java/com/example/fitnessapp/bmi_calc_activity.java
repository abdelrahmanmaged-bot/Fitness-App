package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bmi_calc_activity extends AppCompatActivity {
    EditText weight,height;
    TextView resultText;
    String calculation,BMIResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calc);
        weight = findViewById(R.id.text_weight);
        height = findViewById(R.id.text_height);
        resultText = findViewById(R.id.result);
        Button calc = (Button) findViewById(R.id.bmiBtn);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = weight.getText().toString();
                String s2 = height.getText().toString();
                float weightValue = Float.parseFloat(s1);
                float heightValue = Float.parseFloat(s2) / 100;
                float bmi = weightValue / (heightValue * heightValue);
                if (!(weightValue > 0) || !(heightValue > 0)) {
                    Toast.makeText(getApplicationContext(), "Please enter e valid number of weight or height", Toast.LENGTH_LONG).show();
                }
                if (bmi < 16) {
                    BMIResult = "Severely Under Weight!";
                }
                else if (bmi < 18.5) {
                    BMIResult = "Under Weight!";
                }
                else if (bmi >= 18.5 && bmi <= 24.9) {
                    BMIResult = "Normal Weight!";
                }
                else if (bmi >= 25 && bmi <= 29.9) {
                    BMIResult = "Over Weight";
                }
                else {
                    BMIResult = "OH, It is very large weight!";
                }

                if(weightValue > 0 && heightValue > 0){
                    calculation = "Result: \n" + bmi + "\n" + BMIResult;
                    resultText.setText(calculation);
                }
            }
        });
    }
}