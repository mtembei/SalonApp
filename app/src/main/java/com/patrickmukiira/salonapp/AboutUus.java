package com.patrickmukiira.salonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutUus extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_uus);
        textView = (TextView) findViewById(R.id.textViewAboutUs);

        Intent intent = getIntent();

        textView.setText("Welcome to Ashley's hair and \t\t\tbeauty parlour \n\nAshley's hair and beauty parlour is a mobile application platform that enables" +
                " one to book for an appointment for services offered at our salon.\nOur services include:\n\nCategory A:HairStyle\n\n" +
                "Braids\nBlowout\nWaves\nSuper-do\nStrands\n\nCategory B:Massage\n\nShoulder\nBack\nLegs\n\nCategory C:Others\n\n" +
                "Pedicure\nManicure\nfacial therapy\n");
    }
}
