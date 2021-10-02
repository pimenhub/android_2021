package com.jpimentel.myappfirebasedatabase2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jpimentel.myappfirebasedatabase2021.complementos.DataVO;

import java.util.UUID;

public class InsertarActivity extends AppCompatActivity {
    EditText editTextN, editTextA, editTextT;

    //Implementamos los objetos de Firebase que nos serviran para realizar las acciones respectivas
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        editTextN = findViewById(R.id.edtInsertarNombre);
        editTextA = findViewById(R.id.edtInsertarApellido);
        editTextT = findViewById(R.id.edtInsertarTelefono);
        this.iniciarFirebase();

    }

    public void onClick(View view) {
        this.insertar();
    }
    //metodo de inicializacion con firebase, de mi app, la base de datos y las referencias a la misma
    private void iniciarFirebase(){
        FirebaseApp.initializeApp(getApplicationContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    //Metodo para insertar datos a nuestra base de datos en firebase
    private void insertar(){
        DataVO dataVO = new DataVO();
        if(!editTextN.toString().isEmpty() && !editTextA.toString().isEmpty()
                && !editTextT.toString().isEmpty()){
            dataVO.setIdContacto(UUID.randomUUID().toString());
            dataVO.setNombreContacto(editTextN.getText().toString());
            dataVO.setApellidoContacto(editTextA.getText().toString());
            dataVO.setTelefonoContacto(Integer.parseInt(editTextT.getText().toString()));
            //Ya con la informacion setea, vamos a crear nuestra tabla y sus campos, juntamente
            //con la insercion de sus registro
            //la forma en que firebase almacena estos estos datos es de Tipo Nodo
            //lo que quiere decir que debemos de crear una estructura entre padre e hijo
            databaseReference.child("Contactos")
                                .child(dataVO.getIdContacto())
                                    //Se debe de setear todos los valores
                                    .setValue(dataVO);
            editTextN.setText("");
            editTextA.setText("");
            editTextT.setText("");
            Toast.makeText(this, "Datos Ingresados Correctamente", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
        }
    }

}