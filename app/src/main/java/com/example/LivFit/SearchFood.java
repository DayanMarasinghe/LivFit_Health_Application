package com.example.LivFit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchFood extends AppCompatActivity {
    public static final String MSG_TO_SEND1= "com.example.LivFit.MSG_TO_SEND1";
    public static final String MSG_TO_SEND2 = "com.example.LivFit.MSG_TO_SEND2";
    public static final String MSG_TO_SEND3 = "com.example.LivFit.MSG_TO_SEND3";
    public static final String MSG_TO_SEND4 = "com.example.LivFit.MSG_TO_SEND4";
    public static final String MSG_TO_SEND5 = "com.example.LivFit.MSG_TO_SEND5";
    public static final String MSG_TO_SEND6 = "com.example.LivFit.MSG_TO_SEND6";
    public static final String MSG_TO_SEND7 = "com.example.LivFit.MSG_TO_SEND7";
    public static final String MSG_TO_SEND8 = "com.example.LivFit.MSG_TO_SEND8";


    //declaring variables
     Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
     TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;
     EditText et1, et2, et3, et4, et5, et6, et7, et8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchfood);

        //bind the buttons and views
        btn1 = findViewById(R.id.btnMeal1);
        btn2 = findViewById(R.id.btnMeal2);
        btn3 = findViewById(R.id.btnMeal3);
        btn4 = findViewById(R.id.btnMeal4);
        btn5 = findViewById(R.id.btnMeal5);
        btn6 = findViewById(R.id.btnMeal6);
        btn7 = findViewById(R.id.btnMeal7);
        btn8 = findViewById(R.id.btnMeal8);

        tv1 = findViewById(R.id.tvMeal1);
        tv1 = findViewById(R.id.tvMeal2);
        tv1 = findViewById(R.id.tvMeal3);
        tv1 = findViewById(R.id.tvMeal4);
        tv1 = findViewById(R.id.tvMeal5);
        tv1 = findViewById(R.id.tvMeal6);
        tv1 = findViewById(R.id.tvMeal7);
        tv1 = findViewById(R.id.tvMeal8);

        et1 = findViewById(R.id.etMeal1);
        et2 = findViewById(R.id.etMeal2);
        et3 = findViewById(R.id.etMeal3);
        et4 = findViewById(R.id.etMeal4);
        et5 = findViewById(R.id.etMeal5);
        et6 = findViewById(R.id.etMeal6);
        et7 = findViewById(R.id.etMeal7);
        et8 = findViewById(R.id.etMeal8);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg1 = Integer.parseInt(et1.getText().toString());
                Intent i1 = new Intent(getApplicationContext(), EditFood.class);
                i1.putExtra(MSG_TO_SEND1, msg1);
                startActivity(i1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg2 = Integer.parseInt(et2.getText().toString());
                Intent i2 = new Intent(getApplicationContext(), EditFood.class);
                i2.putExtra(MSG_TO_SEND2, msg2);
                startActivity(i2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg3 = Integer.parseInt(et3.getText().toString());
                Intent i3 = new Intent(getApplicationContext(), EditFood.class);
                i3.putExtra(MSG_TO_SEND3, msg3);
                startActivity(i3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg4 = Integer.parseInt(et4.getText().toString());
                Intent i4 = new Intent(getApplicationContext(), EditFood.class);
                i4.putExtra(MSG_TO_SEND4, msg4);
                startActivity(i4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg5 = Integer.parseInt(et5.getText().toString());
                Intent i5 = new Intent(getApplicationContext(), EditFood.class);
                i5.putExtra(MSG_TO_SEND5, msg5);
                startActivity(i5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg6 = Integer.parseInt(et6.getText().toString());
                Intent i6 = new Intent(getApplicationContext(), EditFood.class);
                i6.putExtra(MSG_TO_SEND6, msg6);
                startActivity(i6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg7 = Integer.parseInt(et7.getText().toString());
                Intent i7 = new Intent(getApplicationContext(), EditFood.class);
                i7.putExtra(MSG_TO_SEND7, msg7);
                startActivity(i7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg8 = Integer.parseInt(et8.getText().toString());
                Intent i8 = new Intent(getApplicationContext(), EditFood.class);
                i8.putExtra(MSG_TO_SEND8, msg8);
                startActivity(i8);
            }
        });


    }




}