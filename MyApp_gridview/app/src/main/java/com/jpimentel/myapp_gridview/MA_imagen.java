package com.jpimentel.myapp_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MA_imagen extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_imagen);
        img = findViewById(R.id.imgMostrar);

        this.dato();
    }
    private void dato(){
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagen");

        this.img.setImageResource(imagen);
    }
}