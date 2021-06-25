package com.jpimentel.myapp_traslado_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Ma_Receptor extends AppCompatActivity {

    private TextView textoN, textoA, textoE, textoD, textoT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma__receptor);

        textoN = findViewById(R.id.txtN);
        textoA = findViewById(R.id.txtA);
        textoE = findViewById(R.id.txtE);
        textoD = findViewById(R.id.txtD);
        textoT = findViewById(R.id.txtT);

        this.obtener();

    }

    private void obtener(){

        //Se agrega el objeto Bundle, este permite obtener los datos
        //trasladados por el intent con su metodo putExtra y poder manipularlos en
        //la actividad que fue llamado
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String nombre = bundle.getString("nom");
            String apellido = bundle.getString("ape");
            String edad = bundle.getString("ed");
            String direccion = bundle.getString("direc");
            String telefono = bundle.getString("te");

            textoN.setText("Nombre: "+nombre);
            textoA.setText("Apellido: "+apellido);
            textoE.setText("Edad: "+edad);
            textoD.setText("Direccion: "+direccion);
            textoT.setText("Telefono: "+telefono);
        }
        else {
            Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
        }

    }
}