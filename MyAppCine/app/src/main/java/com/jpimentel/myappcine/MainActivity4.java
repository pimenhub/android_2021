package com.jpimentel.myappcine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {
    ImageButton imageButton;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imageButton = findViewById(R.id.imgClose);
        imageView = findViewById(R.id.imgFull);

        obtenerImg();

    }
    private void obtenerImg(){
        Bundle bundle = getIntent().getExtras();
        int img = bundle.getInt("imagen");
        imageView.setImageResource(img);
    }

    public void onClick(View view) {
        finish();
    }
}