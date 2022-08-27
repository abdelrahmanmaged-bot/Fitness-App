package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ChooseHeight extends AppCompatActivity {
    private MyDatabaseHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_height);

        EditText chooseHeight = findViewById(R.id.chooseHeight);
        ImageView add = findViewById(R.id.imgAdd);
        ImageView remove = findViewById(R.id.imgRemove);
        Button ctnBtn = findViewById(R.id.btnContinue);

        dbHandler = new MyDatabaseHelper(ChooseHeight.this);

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

        ctnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String height = chooseHeight.getText().toString();

                dbHandler.addNewHeight(height);

                Toast.makeText(getApplicationContext(), "Height has been added", Toast.LENGTH_SHORT).show();
            }
        });


    }
}