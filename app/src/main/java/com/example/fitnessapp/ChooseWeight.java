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

        dbHandler = new MyDatabaseHelper(ChooseWeight.this);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtCurrent.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Current Weight", Toast.LENGTH_SHORT).show();
                }
                else {
                    dbHandler.addNewWeight(txtCurrent.toString());
                    Intent i = new Intent(ChooseWeight.this, ChooseHeight.class);
                    startActivity(i);
                }
            }
        });
    }
}