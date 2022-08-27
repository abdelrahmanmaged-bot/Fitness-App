package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sgin_in button
        Button sgin=(Button) findViewById(R.id.sign_inbtn);
        final MyDatabaseHelper DB = new MyDatabaseHelper(this);

        EditText username =(EditText) findViewById(R.id.username);
        EditText password=(EditText) findViewById(R.id.editTextTextPassword);
        String user= username.getText().toString();
        String pass= password.getText().toString();
        sgin.setOnClickListener(new View.OnClickListener() {//main page
            public void onClick(View v) {

boolean cheack= DB.checkusernamepassword(user,pass);
                if (username.length()==0 ||password.length()==0) {
                    Toast.makeText(MainActivity.this, "enter all fields", Toast.LENGTH_LONG).show();
                }else{
                    if (cheack) {

                        Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, bmi_calc_activity.class);
                        startActivity(intent);
                    }
                    else {

                        Toast.makeText(MainActivity.this, "wrong user name or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });
        //reigster button
        Button register= findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register_page(v);
            }
        });



    }
    public void next_page(View v) {   //main page
        Intent intent = new Intent(this,ChooseGender.class);
        startActivity(intent);

    }
    public void register_page(View v) {   //main page
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }
}