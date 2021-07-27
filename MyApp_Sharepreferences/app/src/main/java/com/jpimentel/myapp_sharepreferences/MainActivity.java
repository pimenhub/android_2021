package com.jpimentel.myapp_sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextN, editTextE;
    private TextView textViewN, textViewE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextN = findViewById(R.id.edtNombre);
        editTextE = findViewById(R.id.edtEdad);

        textViewN = findViewById(R.id.txtNombre);
        textViewE = findViewById(R.id.txtEdad);

        //Cargar las preferencias
        this.loadPreferences();

    }

    public void onClick(View view) {
        //Guardar las preferencias
        this.savePreferences();

        editTextN.setText("");
        editTextE.setText("");
    }

    //Metodo para almacenar los registros como preferencias
    private void savePreferences(){
        if(!editTextN.getText().toString().isEmpty() && !editTextE.getText().toString().isEmpty()){

            String nombre;
            int edad;
            //Instancia del objeto sharepreferences para la creacion del archivo que almacenara las preferencias
            SharedPreferences preferences = getSharedPreferences("archivoShared", Context.MODE_PRIVATE);
            nombre = editTextN.getText().toString();
            edad = Integer.parseInt(editTextE.getText().toString());

            //Se registrar los datos obtenidos como preferencias
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nombre", nombre);
            editor.putInt("edad", edad);

            textViewN.setText(nombre);
            textViewE.setText(String.valueOf(edad));

            editor.commit();

        }
        else {
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para cargar los registro que fueron guardados como preferencias
    private void loadPreferences(){
        String nombre;
        int edad;

        SharedPreferences preferences = getSharedPreferences("archivoShared", Context.MODE_PRIVATE);
        //Se obtienen las preferecias almacenadas en archivo respectivo
        //Si no existe informacion anterior se agrega los s1 por defecto
        nombre = preferences.getString("nombre", "---");
        edad = preferences.getInt("edad", 0);

        textViewN.setText(nombre);
        textViewE.setText(String.valueOf(edad));
    }


}