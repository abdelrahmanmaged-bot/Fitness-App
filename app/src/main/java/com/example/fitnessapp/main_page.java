package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class main_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        LinearLayout btn_BMI_Calc = findViewById(R.id.btn_BMI_Calc);
        LinearLayout btn_PR_Tracker = findViewById(R.id.btn_PR_Tracker);

        btn_BMI_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(main_page.this, bmi_calc_activity.class));
            }
        });

        btn_PR_Tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(main_page.this, AddPR.class));
            }
        });
    }
}