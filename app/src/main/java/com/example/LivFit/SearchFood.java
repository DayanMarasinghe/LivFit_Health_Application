package com.example.LivFit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
     TextView tv1 ,tv2, tv3, tv4, tv5, tv6, tv7, tv8;
     EditText et1, et2, et3, et4, et5, et6, et7, et8;
     SharedPreferences SP;
     DatabaseReference dbref;


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
        tv2 = findViewById(R.id.tvMeal2);
        tv3 = findViewById(R.id.tvMeal3);
        tv4 = findViewById(R.id.tvMeal4);
        tv5 = findViewById(R.id.tvMeal5);
        tv6 = findViewById(R.id.tvMeal6);
        tv7 = findViewById(R.id.tvMeal7);
        tv8 = findViewById(R.id.tvMeal8);

        et1 = findViewById(R.id.etMeal1);
        et2 = findViewById(R.id.etMeal2);
        et3 = findViewById(R.id.etMeal3);
        et4 = findViewById(R.id.etMeal4);
        et5 = findViewById(R.id.etMeal5);
        et6 = findViewById(R.id.etMeal6);
        et7 = findViewById(R.id.etMeal7);
        et8 = findViewById(R.id.etMeal8);

        //shared preferences
        SP = getSharedPreferences("myUserPref", MODE_PRIVATE);

        dbref = FirebaseDatabase.getInstance().getReference().child("Meal").child("m1");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String meal1 = snapshot.child("mname").getValue().toString();
                tv1.setText(meal1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbref = FirebaseDatabase.getInstance().getReference().child("Meal").child("m2");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String meal2 = snapshot.child("mname").getValue().toString();
                tv2.setText(meal2);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbref = FirebaseDatabase.getInstance().getReference().child("Meal").child("m3");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String meal3 = snapshot.child("mname").getValue().toString();
                tv3.setText(meal3);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbref = FirebaseDatabase.getInstance().getReference().child("Meal").child("m4");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String meal4= snapshot.child("mname").getValue().toString();
                tv4.setText(meal4);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbref = FirebaseDatabase.getInstance().getReference().child("Meal").child("m5");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String meal5 = snapshot.child("mname").getValue().toString();
                tv5.setText(meal5);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbref = FirebaseDatabase.getInstance().getReference().child("Meal").child("m6");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String meal6 = snapshot.child("mname").getValue().toString();
                tv6.setText(meal6);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dbref = FirebaseDatabase.getInstance().getReference().child("Meal").child("m7");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String meal7 = snapshot.child("mname").getValue().toString();
                tv7.setText(meal7);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvmsg = (tv1.getText().toString());

                /*SharedPreferences.Editor tveditor = SP.edit();
                tveditor.putString("mealTv", tvmsg);
                tveditor.commit();*/

                Intent itv = new Intent(getApplicationContext(), EditFood.class);
                itv.putExtra("mealTv", tvmsg);
                startActivity(itv);
            }
        });


        //send details to be edited and deleted
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg1 = Integer.parseInt(et1.getText().toString());

                SharedPreferences.Editor editor1 = SP.edit();
                editor1.putInt("et1", msg1);
                editor1.commit();

                Intent i1 = new Intent(getApplicationContext(), EditFood.class);
                startActivity(i1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg2 = Integer.parseInt(et2.getText().toString());

                SharedPreferences.Editor editor2 = SP.edit();
                editor2.putInt("et2", msg2);
                editor2.commit();

                Intent i2 = new Intent(getApplicationContext(), EditFood.class);
                startActivity(i2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg3 = Integer.parseInt(et3.getText().toString());

                SharedPreferences.Editor editor3 = SP.edit();
                editor3.putInt("et3", msg3);
                editor3.commit();

                Intent i3 = new Intent(getApplicationContext(), EditFood.class);
                startActivity(i3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg4 = Integer.parseInt(et4.getText().toString());


                SharedPreferences.Editor editor4 = SP.edit();
                editor4.putInt("et4", msg4);
                editor4.commit();

                Intent i4 = new Intent(getApplicationContext(), EditFood.class);
                startActivity(i4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg5 = Integer.parseInt(et5.getText().toString());

                SharedPreferences.Editor editor5 = SP.edit();
                editor5.putInt("et5", msg5);
                editor5.commit();

                Intent i5 = new Intent(getApplicationContext(), EditFood.class);
                startActivity(i5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg6 = Integer.parseInt(et6.getText().toString());

                SharedPreferences.Editor editor6 = SP.edit();
                editor6.putInt("et6", msg6);
                editor6.commit();

                Intent i6 = new Intent(getApplicationContext(), EditFood.class);
                startActivity(i6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg7 = Integer.parseInt(et7.getText().toString());


                SharedPreferences.Editor editor7 = SP.edit();
                editor7.putInt("et7", msg7);
                editor7.commit();


                Intent i7 = new Intent(getApplicationContext(), EditFood.class);
                startActivity(i7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int msg8 = Integer.parseInt(et8.getText().toString());

                SharedPreferences.Editor editor8 = SP.edit();
                editor8.putInt("et8", msg8);
                editor8.commit();

                Intent i8 = new Intent(getApplicationContext(), EditFood.class);
                startActivity(i8);
            }
        });


    }




}