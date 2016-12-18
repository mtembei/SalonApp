package com.patrickmukiira.salonapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


    }
    public  void  booknow(View view){
        Intent intent = new Intent(this,Book.class);
        startActivity(intent);
    }
    public  void schedule(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public  void  help(View view){
        Intent intent = new Intent(getApplicationContext(),Help.class);
        startActivity(intent);
    }
    public  void money(View view){
        Intent intent = new Intent(getApplicationContext(),Money.class);
        startActivity(intent);
    }
    public void aboutus(View view){
        Intent intent = new Intent(getApplicationContext(),AboutUus.class);
        startActivity(intent);
    }
}
