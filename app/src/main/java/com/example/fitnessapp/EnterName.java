package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EnterName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);
        Button btnEntername= (Button) findViewById(R.id.EnterNameBtn);

        btnEntername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnterName.this, ChooseGender.class);
                startActivity(intent);
            }
        });


        TextView txtName = findViewById(R.id.txtName);
        String name = txtName.getText().toString();
    }

//    Button btnWelcome = findViewById(R.id.btnWelcome);



}