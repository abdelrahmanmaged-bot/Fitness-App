package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bmi_calc_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcBtn = (Button) findViewById(R.id.btn_BMI_Calculator);
        BMI_Calculator bmi_calculator = new BMI_Calculator();
        EditText tmpText1 = (EditText) findViewById(R.id.wight_text);
        EditText tmpText2 = (EditText) findViewById(R.id.height_text);
        TextView view1 = (TextView) findViewById(R.id.result);
        float temp1 = Float.parseFloat(tmpText1.getText().toString());
        float temp2 = Float.parseFloat(tmpText2.getText().toString());
        calcBtn.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {

                if(!(tmpText1.getText().toString().equals("")) && !(tmpText2.getText().toString().equals(""))&&!(Float.parseFloat(tmpText1.getText().toString())<=0)&&!(Float.parseFloat(tmpText2.getText().toString())<=0)){

                    bmi_calculator.setWeight(temp1);
                    bmi_calculator.setHeight(temp2);
                    view1.setText(String.valueOf(bmi_calculator.bmi_calculator()));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter a valid number of weight or height",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}