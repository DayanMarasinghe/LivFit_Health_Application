package com.example.LivFit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DisplayBMI extends AppCompatActivity {

    private TextView bmi , weightType , calgoal;
    private Button goDash;
    DecimalFormat display = new DecimalFormat("##.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_b_m_i);

        bmi = findViewById(R.id.tvBMI);
        weightType = findViewById(R.id.tvBMIResult);
        calgoal = findViewById(R.id.tvCalories);
        goDash = findViewById(R.id.btnVisitDashBoard);

        //get data from previous page
        String getBmi = getIntent().getStringExtra("KeyBMI");
        String getWeightType = getIntent().getStringExtra("KeyWeightType");
        String getCalGoal = getIntent().getStringExtra("KeyCalGoal");

        //setting the text to display on this page
        bmi.setText(getBmi);
        weightType.setText(getWeightType);
        calgoal.setText(getCalGoal);

        goDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashIntent = new Intent(DisplayBMI.this,Dashboard.class);
                startActivity(dashIntent);
            }
        });
    }
}