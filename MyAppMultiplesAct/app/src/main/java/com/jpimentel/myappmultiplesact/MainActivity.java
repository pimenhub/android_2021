package com.jpimentel.myappmultiplesact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pulsar(View view) {
        //Objeto Intent, este me permite activar diversas actividad con la ayuda de startActivity()
        Intent intent = new Intent(this, MAIntermedio.class);
        startActivity(intent);
        //finish();
    }
}