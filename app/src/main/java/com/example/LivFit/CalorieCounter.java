package com.example.LivFit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CalorieCounter extends AppCompatActivity {
    //declaring variables
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriecounter);

        //bind the buttons
        btn1 = findViewById(R.id.btnBRK1);
        btn2 = findViewById(R.id.btnLUNCH2);

        btn4 = findViewById(R.id.btnSNK4);

        btn3 = findViewById(R.id.btnDIN3);
        btn4 = findViewById(R.id.btnSNK41);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchFood.class);
                startActivity(intent);
            }
        });




    }
}