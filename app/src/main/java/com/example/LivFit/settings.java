package com.example.LivFit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class settings extends AppCompatActivity {

    private TextView editProfile , deleteAccount , logOut , aboutUs , faq;
    private Switch pushNotify , darkTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editProfile = findViewById(R.id.tvLinkEditProfile);
        deleteAccount = findViewById(R.id.tvLinkDeleteAccount);
        logOut = findViewById(R.id.tvLogOut);
        aboutUs = findViewById(R.id.tvAboutUs);
        faq = findViewById(R.id.tvFAQ);
        pushNotify = findViewById(R.id.switchPushNotification);
        darkTheme = findViewById(R.id.switchTheme);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateIntent = new Intent(settings.this,updateAccount.class);
                startActivity(updateIntent);
            }
        });

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete account
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logout
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abtUsIntent = new Intent(settings.this,aboutUs.class);
                startActivity(abtUsIntent);
            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent faqIntent = new Intent(settings.this,faq.class);
                startActivity(faqIntent);
            }
        });
    }
}