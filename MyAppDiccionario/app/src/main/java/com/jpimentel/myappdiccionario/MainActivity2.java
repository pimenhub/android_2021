package com.jpimentel.myappdiccionario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView textViewT, textViewS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewT = findViewById(R.id.tvTermino);
        textViewS = findViewById(R.id.tvSignificado);

        obtenerDatos();
    }

    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        String termino = bundle.getString("termino");
        String significado = bundle.getString("significado");
        textViewT.setText(termino);
        textViewS.setText(significado);
    }
}