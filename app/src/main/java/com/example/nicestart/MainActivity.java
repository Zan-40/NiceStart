package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.widget.Toolbar;



public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        Button mas = findViewById(R.id.mas);
        Button menos = findViewById(R.id.menos);
        Button reset = findViewById(R.id.reset);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mas.setOnClickListener(v -> {
            num += 1;
            screen.setText(String.valueOf(num));
        });

        menos.setOnClickListener(v -> {
            num -= 1;
            screen.setText(String.valueOf(num));
        });

        reset.setOnClickListener(v -> {
            num = 0;
            screen.setText("0");
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.camera) {
            Toast toast = Toast.makeText(this,"going APPBAR CAMERA",Toast.LENGTH_LONG );
            toast.show();
        }
        if (id == R.id.nopeople) {
            Intent intent = new Intent(MainActivity.this, Nopeople.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}