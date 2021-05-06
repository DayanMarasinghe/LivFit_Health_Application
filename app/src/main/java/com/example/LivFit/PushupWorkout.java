package com.example.LivFit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PushupWorkout extends AppCompatActivity {

    private Button confirm;
    TextView a,b,burntnum;
    DatabaseReference reff;
    private EditText duration;
    private int calburn;
    int count;

    String wtype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pushup_workout);

        a=(TextView)findViewById(R.id.textViewpshups);
        b=(TextView)findViewById(R.id.textViewcalpmin);

        Intent intent = getIntent();
        wtype=intent.getStringExtra("workout");
        reff=FirebaseDatabase.getInstance().getReference().child("Workout").child(wtype);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String name = snapshot.child("name").getValue().toString();
                String calburnt = snapshot.child("calburnt").getValue().toString();
                a.setText(name);
                b.setText(calburnt);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        duration =(EditText)findViewById(R.id.editTextdurationw);
        burntnum=(TextView)findViewById(R.id.textViewbrntnum);

        confirm =(Button) findViewById(R.id.dinbtn);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               calburn = calculateCalBurnt(duration,b);
               String getcalburn = String.valueOf(calburn);
               burntnum.setText(getcalburn);

            }
        });

    }

    public void increment(View v){
        count++;
        duration.setText(""+count);
    }
    public void decrement(View v){
        if(count<=0) count=0;
        else count--;
        duration.setText(""+count);
    }

    public int calculateCalBurnt(EditText duration, TextView b){

        int cvduration = Integer.parseInt(duration.getText().toString());
        int cvcalburn = Integer.parseInt(b.getText().toString());

        return cvcalburn*cvduration;
    }
}



