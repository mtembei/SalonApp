package com.patrickmukiira.salonapp;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Help extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        textView = (TextView) findViewById(R.id.textViewHelp);
        TextView tv = (TextView) findViewById(R.id.textViewHelp);
        Intent intent = getIntent();

        textView.setText("To book an appointment:\n\nclick on Booking\nfill in details in the required fields\nclick Book Appointment\n\n" +
                "To view prices of services offered:\nClick on money\n\n" +
                "To view information about the company:\nClick about us ");

        tv.setTypeface(null, Typeface.BOLD);
    }
}
