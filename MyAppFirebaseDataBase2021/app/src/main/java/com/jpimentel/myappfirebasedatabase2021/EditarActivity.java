package com.jpimentel.myappfirebasedatabase2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jpimentel.myappfirebasedatabase2021.complementos.DataVO;

public class EditarActivity extends AppCompatActivity {
    private EditText editTextN, editTextA, editTextT;
    private String id, nombre, apellido;
    private int telefono;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        editTextN = findViewById(R.id.edtEditarNombre);
        editTextA = findViewById(R.id.edtEditarApellido);
        editTextT = findViewById(R.id.edtEditarTelefono);
        this.iniciarFirebase();
        this.obtener();

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnActualizarDatos:
                this.actualizar();
                break;
            case R.id.btnEliminarDatos:
                this.eliminar();
                break;
        }
    }
    //metodo de inicializacion con firebase, de mi app, la base de datos y las referencias a la misma
    private void iniciarFirebase(){
        FirebaseApp.initializeApp(getApplicationContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    //Captura de la informacion de los contactos
    private void obtener(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        nombre = bundle.getString("nombre");
        apellido = bundle.getString("apellido");
        telefono = bundle.getInt("telefono");
        //seteo de datos
        editTextN.setText(nombre);
        editTextA.setText(apellido);
        editTextT.setText(String.valueOf(telefono));
    }


    private void actualizar() {
        if (!editTextN.toString().isEmpty() && !editTextA.toString().isEmpty()
                && !editTextT.toString().isEmpty()) {
            DataVO dataVO = new DataVO();
            dataVO.setIdContacto(id);
            dataVO.setNombreContacto(editTextN.getText().toString());
            dataVO.setApellidoContacto(editTextA.getText().toString());
            dataVO.setTelefonoContacto(Integer.parseInt(editTextT.getText().toString()));
            databaseReference.child("Contactos")
                    .child(dataVO.getIdContacto())
                    //Se deben de setear todos los valores
                        .setValue(dataVO);
            Toast.makeText(this, "Contacto Actualizado", Toast.LENGTH_SHORT).show();
            editTextN.setText("");
            editTextA.setText("");
            editTextT.setText("");
            Intent intent = new Intent(getApplicationContext(), MostrarActivity.class);
            startActivity(intent);
            finish();
        }
    }
    private void eliminar(){
        DataVO dataVO = new DataVO();
        dataVO.setIdContacto(id);
        databaseReference.child("Contactos").child(dataVO.getIdContacto()).removeValue();
        Toast.makeText(this, "Contacto Eliminado", Toast.LENGTH_SHORT).show();
        editTextN.setText("");
        editTextA.setText("");
        editTextT.setText("");
        Intent intent = new Intent(getApplicationContext(), MostrarActivity.class);
        startActivity(intent);
        finish();
    }
}