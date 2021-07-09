package com.jpimentel.myappmeses_lista;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

public class MA_Meses extends AppCompatActivity {
    private TextView mes, contenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_meses);

        mes = findViewById(R.id.txtMes);
        contenido = findViewById(R.id.txtContenido);

        this.datos();
    }

    private void datos(){
        Bundle bundle = getIntent().getExtras();
        String mes = bundle.getString("mes");
        int contenido = bundle.getInt("contenido");
        this.mes.setText(String.valueOf(mes));
        this.contenido.setText(contenido);
    }

}