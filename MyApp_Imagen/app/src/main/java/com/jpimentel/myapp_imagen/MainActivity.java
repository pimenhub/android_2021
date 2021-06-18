package com.jpimentel.myapp_imagen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pulsar(View view) {
        if (view.getId() == R.id.btnPulsar){
            Toast.makeText(this, "Es un vehículo de carga", Toast.LENGTH_SHORT).show();
        }
    }
}