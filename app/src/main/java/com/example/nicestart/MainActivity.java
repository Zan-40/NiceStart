package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private Button mas;
    private Button menos;
    private Button reset;
    private int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        mas = findViewById(R.id.mas);
        menos = findViewById(R.id.menos);
        reset = findViewById(R.id.reset);

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num += 1;
                screen.setText(String.valueOf(num));
            }
        });

        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num -= 1;
                screen.setText(String.valueOf(num));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 0;
                screen.setText("0");
            }
        });
    }
}