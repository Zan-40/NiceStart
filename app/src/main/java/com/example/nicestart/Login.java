package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.animation.*;

import com.bumptech.glide.Glide;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView thunder = findViewById(R.id.thunder);
        Animation blink = AnimationUtils.loadAnimation(this, R.anim.blink);

        thunder.startAnimation(blink);

        ImageView girl = findViewById(R.id.girl);
        Glide.with(this).load(R.drawable.girl).into(girl);
    }

    public void openMain(View view){
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }

    public void openRegister(View view){
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}