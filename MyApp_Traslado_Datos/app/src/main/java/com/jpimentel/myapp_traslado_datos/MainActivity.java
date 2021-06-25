package com.jpimentel.myapp_traslado_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campoN, campoA, campoE, campoD, campoT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoN = findViewById(R.id.txtNombre);
        campoA = findViewById(R.id.txtApellido);
        campoE = findViewById(R.id.txtEdad);
        campoD = findViewById(R.id.txtDire);
        campoT = findViewById(R.id.txtTel);

    }

    private void datos() {
        String nombre = campoN.getText().toString();
        String apellido = campoA.getText().toString();
        String edad = campoE.getText().toString();
        String dire = campoD.getText().toString();
        String tel = campoT.getText().toString();

        if(!nombre.isEmpty()&&!apellido.isEmpty()&&
                !edad.isEmpty()&&!dire.isEmpty()&&!tel.isEmpty()){

            Intent intent = new Intent(this, Ma_Receptor.class);
            intent.putExtra("nom", nombre);
            intent.putExtra("ape", apellido);
            intent.putExtra("ed", edad);
            intent.putExtra("direc", dire);
            intent.putExtra("te", tel);
            startActivity(intent);

        }
        else {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }

    }


    public void onClick(View view) {
        this.datos();
    }
}