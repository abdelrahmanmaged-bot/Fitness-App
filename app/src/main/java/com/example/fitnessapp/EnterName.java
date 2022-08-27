package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EnterName extends AppCompatActivity {
    private MyDatabaseHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        Button btnEntername= (Button) findViewById(R.id.EnterNameBtn);
        TextView txtName = findViewById(R.id.txtName);
        TextView txtPass = findViewById(R.id.txtName2);
        dbHandler = new MyDatabaseHelper(EnterName.this);

        btnEntername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtName.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(EnterName.this, "Please enter username", Toast.LENGTH_SHORT).show();
                }
                String pass = txtPass.getText().toString();
                if (pass.isEmpty()){
                    Toast.makeText(EnterName.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }else {

                    dbHandler.addNewUsername(name);
                    dbHandler.addNewPassword(pass);
                    Toast.makeText(EnterName.this, "Username has been added", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EnterName.this, ChooseGender.class);
                    startActivity(intent);

                }
            }


        });





    }





}