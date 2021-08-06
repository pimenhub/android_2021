package com.jpimentel.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jpimentel.myappswlocal.complementos.MetodosSW;

import org.json.JSONObject;

public class MainActivityInsertarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText editTextNombre, editTextApellido, editTextTelefono, editTextDireccion;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar_sw);
        editTextNombre = findViewById(R.id.edtNombreCliente);
        editTextApellido = findViewById(R.id.edtApellidoCliente);
        editTextTelefono = findViewById(R.id.edtTelefonoCliente);
        editTextDireccion = findViewById(R.id.edtDireccionCliente);
    }

    public void onClick(View view) {
        this.insertar();
    }

    private void insertar(){
        if(!editTextNombre.getText().toString().isEmpty()&&!editTextApellido.getText().toString().isEmpty()&&
        !editTextTelefono.getText().toString().isEmpty()&&!editTextDireccion.getText().toString().isEmpty()){

            //utilzamos el metodo respectivo de la clase MetodosSW
            metodosSW.insertarSW(this,editTextNombre.getText().toString(),editTextApellido.getText().toString(),
                    Integer.parseInt(editTextTelefono.getText().toString()),editTextDireccion.getText().toString(),
                            this, this);

            editTextNombre.setText("");
            editTextApellido.setText("");
            editTextTelefono.setText("");
            editTextDireccion.setText("");
        }
        else {
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Datos Insertados Correctamente", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a I "+error, Toast.LENGTH_SHORT).show();
        System.err.println("I***** "+error);
    }


}