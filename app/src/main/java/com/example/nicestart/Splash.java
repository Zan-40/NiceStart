package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.*;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

public class Splash extends AppCompatActivity {

    private LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottie = findViewById(R.id.lottie);



        openApp();

        //ImageView logo = findViewById(R.id.logo);
        //Glide.with(this).load(R.drawable.ic_thunder).into(logo);
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