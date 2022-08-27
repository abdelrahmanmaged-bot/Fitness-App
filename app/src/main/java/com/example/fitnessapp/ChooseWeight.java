package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChooseWeight extends AppCompatActivity {

    private MyDatabaseHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_weight);

        Button btnContinue = findViewById(R.id.btnContinue);
        EditText txtCurrent = findViewById(R.id.txtCurrent);
        EditText txtGoal = findViewById(R.id.txtGoal);

        dbHandler = new MyDatabaseHelper(ChooseWeight.this);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtCurrent.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Current Weight", Toast.LENGTH_SHORT).show();
                }
                else if (txtGoal.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Goal Weight", Toast.LENGTH_SHORT).show();
                }
                else if (txtCurrent.getText().toString().equals("") && txtGoal.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Do you think this is funny?", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHandler.addNewWeight(txtCurrent.toString());
                    dbHandler.addNewWeightGoal(txtGoal.toString());
                    Intent i = new Intent(ChooseWeight.this, ChooseHeight.class);
                    startActivity(i);
                }
            }
        });
    }
}