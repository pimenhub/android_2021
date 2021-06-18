package com.jpimentel.miapp_primerproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Declaracion de los objetos que tiene una accion aparte de los button
    TextView txtContador;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establece y encuentra la vista por ID para ser utilizada dentro de la clase
        txtContador = findViewById(R.id.txtContador);
    }
    //Declaracion de los metodos necesarios
    private void mas(){
        contador++;
        txtContador.setText(String.valueOf(contador));

    }
    private void menos(){
        contador--;
        txtContador.setText(String.valueOf(contador));
    }
    private void reiniciar(){
        contador = 0;
        txtContador.setText(String.valueOf(contador));
        if(contador == 0){
            Toast.makeText(this, "El contador se ha reiniciado a 0", Toast.LENGTH_SHORT).show();
        }
    }

    //Definimos lo botones que seran utilizados en la actividad
    public void pulsar(View view) {
     if (view.getId() == R.id.btnMas){
         this.mas();
     }
     if(view.getId() == R.id.btnMenos){
         this.menos();
     }
     if(view.getId() == R.id.btnCero){
         this.reiniciar();
     }
    }
}