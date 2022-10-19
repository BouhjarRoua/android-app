package com.example.testinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import java.util.Timer;
import java.util.TimerTask;

public class splash_Screen extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

            Timer timer =new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    intent = new Intent(splash_Screen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },2000);








    }
}