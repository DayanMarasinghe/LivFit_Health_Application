package com.example.LivFit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valdesekamdem.library.mdtoast.MDToast;

public class WaterIntake extends AppCompatActivity {

    EditText editText;
    Button button;
    DatabaseReference waterIntake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake);

        editText = (EditText)findViewById(R.id.waternumber);
        button = (Button)findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String waterCount = editText.getText().toString();

                if(waterCount.isEmpty()){

                    editText.setError("Water cups count required!");
                    MDToast mdToast = MDToast.makeText(getApplicationContext(), "Water cups count required!", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR);
                    mdToast.show();

                }
                else{

                    waterIntake = FirebaseDatabase.getInstance().getReference().child("User").child("user1").child("waterCount");
                    waterIntake.setValue(waterCount);
                    MDToast mdToast = MDToast.makeText(getApplicationContext(), "Water count entered successfully", MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS);
                    mdToast.show();

                }
            }
        });
    }
}