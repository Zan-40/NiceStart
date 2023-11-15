package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.*;

import com.bumptech.glide.Glide;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        openApp();

        ImageView logo = findViewById(R.id.logo);
        Glide.with(this).load(R.drawable.coffeelogo).into(logo);
    }

    private void openApp(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
            }, 2000);
    }
}