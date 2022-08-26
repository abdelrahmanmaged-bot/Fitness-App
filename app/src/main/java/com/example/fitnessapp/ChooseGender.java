package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseGender extends AppCompatActivity {
    private MyDatabaseHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_gender);

        RadioGroup gender = findViewById(R.id.genderRG);
        Button btnContinue = findViewById(R.id.btnContinue);

        dbHandler = new MyDatabaseHelper(ChooseGender.this);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup genderRG = findViewById(R.id.genderRG);

                if (gender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select a gender", Toast.LENGTH_SHORT).show();
                }
                else {
                    RadioButton checked = findViewById(gender.getCheckedRadioButtonId());
                    String checkedGender = checked.getText().toString();
                    if (checkedGender.equals("Male"))
                    {
                        dbHandler.addNewSex("Male");
                    }
                    else if (checkedGender.equals("Female")) {
                        dbHandler.addNewSex("Female");
                    }
                    Toast.makeText(getApplicationContext(), "Gender has been added", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ChooseGender.this, ChooseAge.class);
                    startActivity(i);

                }
            }
        });

    }
}