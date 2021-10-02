package com.jpimentel.myappfirebasedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jpimentel.myappfirebasedb.complementos.DataVO;

import java.util.UUID;

public class InsertarActivity extends AppCompatActivity {

    private EditText txtN, txtA, txtE;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        txtN = findViewById(R.id.txtNombre);
        txtA = findViewById(R.id.txtApellido);
        txtE = findViewById(R.id.txtEdad);
        this.iniciarFirebase();
    }

    public void onClick(View view) {
        this.insert();
    }
    private void iniciarFirebase(){
        FirebaseApp.initializeApp(getApplicationContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    private void insert(){

        DataVO dataVO = new DataVO();
        if (!txtN.getText().toString().isEmpty()&&!txtA.getText().toString().isEmpty()&&!txtE.getText().toString().isEmpty()){
            dataVO.setId(UUID.randomUUID().toString());
            dataVO.setNombre(txtN.getText().toString());
            dataVO.setApellido(txtA.getText().toString());
            dataVO.setEdad(Integer.parseInt(txtE.getText().toString()));
            //Se crea la tabla o nodo como es conocido en firebase, luego en cada nodo definido con el
            //identificador id para poder crear los registros
            databaseReference.child("Data").child(dataVO.getId()).setValue(dataVO);
            txtN.setText("");
            txtE.setText("");
            txtA.setText("");
            Toast.makeText(this, "Datos Ingresados Correctamente", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Datos no Ingresados", Toast.LENGTH_SHORT).show();
        }
    }
}