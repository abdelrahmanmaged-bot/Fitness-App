package com.example.fitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class bmi_calc_activity extends AppCompatActivity {
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcBtn = (Button) findViewById(R.id.btn_BMI_Calculator);
        BMI_Calculator bmi_calculator = new BMI_Calculator(0,0);
        EditText tmpText1 = (EditText) findViewById(R.id.wight_text);
        EditText tmpText2 = (EditText) findViewById(R.id.height_text);
        TextView view1 = (TextView) findViewById(R.id.result);
        try {
            calcBtn.setOnClickListener(new View.OnClickListener() {
                @Nullable
                @Override


                public void onClick(View view) {
                    if (tmpText1.length()==0 && tmpText2.length()==0 ) {

                        float temp1 = Float.parseFloat(String.valueOf(tmpText1.getText().toString().equalsIgnoreCase("nonnull")));
                        float temp2 = Float.parseFloat(String.valueOf(tmpText2.getText().toString().equalsIgnoreCase("nonnull")));
                        bmi_calculator.setWeight(temp1);
                        bmi_calculator.setHeight(temp2);
                        view1.setText(String.valueOf(bmi_calculator.bmi_calculator()));
                    } else {
                        Toast.makeText(getApplicationContext(), "Please enter a valid number of weight or height", Toast.LENGTH_LONG).show();
                    }
                }

            });
        }catch(NullPointerException e) {
            System.out.println("NullPointerException thrown!");


        }
    }
}