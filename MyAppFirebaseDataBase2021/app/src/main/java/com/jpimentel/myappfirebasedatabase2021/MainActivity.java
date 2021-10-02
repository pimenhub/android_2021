package com.jpimentel.myappfirebasedatabase2021;

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

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnInsertar:
                intent = new Intent(getApplicationContext(), InsertarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMostrarEditar:
                intent = new Intent(getApplicationContext(), MostrarActivity.class);
                startActivity(intent);
                break;
        }

    }
}