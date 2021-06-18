package com.jpimentel.myapp_nombre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText campo, campo2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo = findViewById(R.id.txtNombre);
        resultado = findViewById(R.id.txtResultado);
        campo2 = findViewById(R.id.txtEdad);
    }
    private void mostrarNombre(){
        String campoNombre;
        String campoEdad;
        campoNombre = campo.getText().toString();
        campoEdad = campo2.getText().toString();

        if(!campoNombre.isEmpty()&&!campoEdad.isEmpty()) {
            int anio;
            Calendar c = Calendar.getInstance();
            int a = c.get(Calendar.YEAR);
            anio = a - Integer.parseInt(campoEdad);

            resultado.setText("Su nombre es: " + campoNombre+"\n"+ "y su año de nacimiento es: "+anio);
        }
        else {
            Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void pulsar(View view) {
        switch (view.getId()){
            case R.id.btnMostrar:
                this.mostrarNombre();
                break;
        }

    }
}