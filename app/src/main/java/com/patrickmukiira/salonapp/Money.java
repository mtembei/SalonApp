package com.patrickmukiira.salonapp;

import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.TextView;

public class Money extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        textView = (TextView) findViewById(R.id.textViewMoney);
        textView.setText("Braids:KSH 150\n\nBlowout:KSH 300\n\nWaves:KSH 200\n\nSuper-do:KSH 1000\n\nStrands:KSH 500\n\n" +
                "Shoulder massage:KSH 450\n\nBack massage:KSH 600\n\nLeg massage:KSH 350\n\nPedicure:KSH 200\n\nManicure:KSH 250");
    }
}
