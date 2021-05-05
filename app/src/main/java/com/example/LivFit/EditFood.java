package com.example.LivFit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class EditFood extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;
    TextView TV1, TV2, TV3, TV4, TV5, TV6, TV7, TV8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);

        SharedPreferences SP = getApplicationContext().getSharedPreferences("myUserPref", MODE_PRIVATE);

        TV1 = findViewById(R.id.TVMeal1);
        Intent intent = getIntent();
        String s1 = intent.getStringExtra("mealTv");
        TV1.setText(s1);

        int num1 = SP.getInt("et1", 0);
        int num2 = SP.getInt("et2", 0);
        int num3 = SP.getInt("et3", 0);
        int num4 = SP.getInt("et4", 0);
        int num5 = SP.getInt("et5", 0);
        int num6 = SP.getInt("et6", 0);
        int num7 = SP.getInt("et7", 0);
        int num8 = SP.getInt("et8", 0);



        /*int num2 = intent.getIntExtra(SearchFood.MSG_TO_SEND2, 0);
        int num3 = intent.getIntExtra(SearchFood.MSG_TO_SEND3, 0);
        int num4 = intent.getIntExtra(SearchFood.MSG_TO_SEND4, 0);
        int num5 = intent.getIntExtra(SearchFood.MSG_TO_SEND5, 0);
        int num6 = intent.getIntExtra(SearchFood.MSG_TO_SEND6, 0);
        int num7 = intent.getIntExtra(SearchFood.MSG_TO_SEND7, 0);
        int num8 = intent.getIntExtra(SearchFood.MSG_TO_SEND8, 0);*/


        tv1 = findViewById(R.id.tvQuant1);
        tv2 = findViewById(R.id.tvQuant2);
        tv3 = findViewById(R.id.tvQuant3);
        tv4 = findViewById(R.id.tvQuant4);
        tv5 = findViewById(R.id.tvQuant5);
        tv6 = findViewById(R.id.tvQuant6);
        tv7 = findViewById(R.id.tvQuant7);
        tv8 = findViewById(R.id.tvQuant8);





        tv1.setText("" + num1);
        tv2.setText("" + num2);
        tv3.setText("" + num3);
        tv4.setText("" + num4);
        tv5.setText("" + num5);
        tv6.setText("" + num6);
        tv7.setText("" + num7);
        tv8.setText("" + num8);

    }
}