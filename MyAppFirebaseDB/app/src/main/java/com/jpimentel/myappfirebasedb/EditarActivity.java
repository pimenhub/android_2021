package com.jpimentel.myappfirebasedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jpimentel.myappfirebasedb.complementos.DataVO;

public class EditarActivity extends AppCompatActivity {

    private EditText txtN, txtA, txtE;
    String nom, ape, idT;
    int ed;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        txtN = findViewById(R.id.txtNom);
        txtA = findViewById(R.id.txtApe);
        txtE = findViewById(R.id.txtEd);

        this.iniciarFirebase();
        this.data();
    }
    private void iniciarFirebase(){
        FirebaseApp.initializeApp(getApplicationContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    private void data(){
        Bundle bundle = getIntent().getExtras();
        idT = bundle.getString("id");
        nom = bundle.getString("nombre");
        ape = bundle.getString("apellido");
        ed = bundle.getInt("edad");

        txtN.setText(nom);
        txtA.setText(ape);
        txtE.setText(String.valueOf(ed));
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMod:
                update();
                break;
            case R.id.btnEli:
                delete();
                break;
        }
    }
    private void update(){
        DataVO dvo = new DataVO();
        dvo.setId(idT);
        System.err.println(idT);
        dvo.setNombre(txtN.getText().toString());
        dvo.setApellido(txtA.getText().toString());
        dvo.setEdad(Integer.parseInt(txtE.getText().toString()));
        databaseReference.child("Data").child(dvo.getId()).setValue(dvo);
        Toast.makeText(this, "Datos Actualizados", Toast.LENGTH_SHORT).show();
        txtN.setText("");
        txtA.setText("");
        txtE.setText("");
        Intent intent = new Intent(getApplicationContext(), MostrarActivity.class);
        startActivity(intent);
        finish();
    }
    private void delete(){
        DataVO dvo = new DataVO();
        dvo.setId(idT);
        databaseReference.child("Data").child(dvo.getId()).removeValue();
        Toast.makeText(this, "Dato Eliminado", Toast.LENGTH_SHORT).show();
        txtN.setText("");
        txtA.setText("");
        txtE.setText("");
        Intent intent = new Intent(getApplicationContext(), MostrarActivity.class);
        startActivity(intent);
        finish();
    }
}