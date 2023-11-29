package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.*;
import android.widget.*;
import androidx.appcompat.widget.Toolbar;



public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private int num = 0;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        Button mas = findViewById(R.id.mas);
        Button menos = findViewById(R.id.menos);
        Button reset = findViewById(R.id.reset);

        foto = findViewById(R.id.foto);

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

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // La foto fue tomada con éxito
            Bundle extras = data.getExtras();
            if (extras != null) {
                // Obtener la imagen capturada como Bitmap
                Bitmap imageBitmap = (Bitmap) extras.get("data");

                // Mostrar la imagen en el ImageView
                foto.setImageBitmap(imageBitmap);
                foto.setVisibility(View.VISIBLE);
            }
        }
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
            dispatchTakePictureIntent();
        }
        if (id == R.id.nopeople) {
            Intent intent = new Intent(MainActivity.this, Nopeople.class);
            startActivity(intent);
        }
        if (id == R.id.settings) {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}