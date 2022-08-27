package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class AddPR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pr);

        EditText txtExerciseName = findViewById(R.id.txtExerciseName);
        EditText txtKgs = findViewById(R.id.txtKgs);
        EditText txtReps = findViewById(R.id.txtReps);
        ListView listPR = findViewById(R.id.listPR);
        Button btnAddNewPR = findViewById(R.id.btnAddNewPR);

        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listPR.setAdapter(listAdapter);

        btnAddNewPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exerciseName = txtExerciseName.getText().toString();
                String kgs = txtKgs.getText().toString();
                String reps = txtReps.getText().toString();

                String item = "Exercise: " + exerciseName + "\n" + kgs + " KGs" + "\t" + reps + " reps";
                listAdapter.add(item);

                txtExerciseName.getText().clear();
                txtKgs.getText().clear();
                txtReps.getText().clear();
            }
        });

    }
}