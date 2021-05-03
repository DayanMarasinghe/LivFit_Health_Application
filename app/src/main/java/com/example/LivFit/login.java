package com.example.LivFit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class login extends AppCompatActivity {

    private EditText username , password;
    private TextView forgetPW;
    private Button logBtn;
    private AwesomeValidation awesomeValidation;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.etEnterUsername);
        password = findViewById(R.id.etPass);
        forgetPW = findViewById(R.id.tvForgotPW);
        logBtn = findViewById(R.id.btnLoginIn);

        //checking the SDK version to create notification channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Forget password notification", "LivFit Notify", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        firebaseAuth = FirebaseAuth.getInstance();

        //validation patterns
        awesomeValidation.addValidation(this,R.id.etEnterUsername, RegexTemplate.NOT_EMPTY,R.string.emptyUsernameLogin);
        awesomeValidation.addValidation(this,R.id.etPass, RegexTemplate.NOT_EMPTY,R.string.emptyPassword);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking form validation
                if(awesomeValidation.validate()){
                    String valEmail = username.getText().toString().trim();
                    String valPassword = password.getText().toString().trim();
                    //authenticate user
                    firebaseAuth.signInWithEmailAndPassword(valEmail,valPassword);

                    //to fertch data from firebase
                    isUser();
                    
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter login credential correctly",Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgetPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //notify user
                String message = "We sent you a password reset link to your mail";

                NotificationCompat.Builder builder = new NotificationCompat.Builder(login.this,"Forget password notification");
                builder.setContentTitle("You have one new notification from LivFit");
                builder.setContentText(message);
                builder.setSmallIcon(R.drawable.livfit_logo);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(login.this);
                managerCompat.notify(123,builder.build());

            }
        });
    }

    private void isUser() {

        String userEnterdUsername = username.getText().toString().trim();
        String userEnterdPassword = password.getText().toString().trim();

        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        //check if the user exists
        Query checkUser = databaseReference.orderByChild("uname").equalTo(userEnterdUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //if the username exists
                if(snapshot.exists()){

                    username.setError(null);
                    username.setEnabled(false);

                    //get the password from the db for the particular username
                    String DBpassword = snapshot.child(userEnterdUsername).child("pword").getValue(String.class);

                    //checking if the user entered password is matching to the db password
                    if(Objects.equals(DBpassword, userEnterdPassword)){

                        username.setError(null);
                        username.setEnabled(false);

                        //if so taking needed fields from the firebase
                        String DBCalGoal = snapshot.child(userEnterdUsername).child("calGoal").getValue(String.class);
                        String DBCalConsumption = snapshot.child(userEnterdUsername).child("calConsumption").getValue(String.class);
                        String DBCalBurned = snapshot.child(userEnterdUsername).child("calBurned").getValue(String.class);
                        String DBWaterCount = snapshot.child(userEnterdUsername).child("waterCount").getValue(String.class);

                        Toast.makeText(getApplicationContext(),"HIII" , Toast.LENGTH_SHORT).show();

                        //calling the dashboard by passing those from an Intent
                        Intent dashIntent = new Intent(getApplicationContext(),Dashboard.class);
                        dashIntent.putExtra("KeyDashCalGoal",DBCalGoal);
                        dashIntent.putExtra("KeyDashCalConsum",DBCalConsumption);
                        dashIntent.putExtra("KeyDashCalBurn",DBCalBurned);
                        dashIntent.putExtra("KeyDashWaterCount",DBWaterCount);

                        startActivity(dashIntent);
                    }
                    else{
                        password.setError("Wrong password");
                        password.requestFocus();
                    }
                }
                else{
                    username.setError("Invalid username");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}