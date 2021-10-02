package com.jpimentel.myappfirebasedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jpimentel.myappfirebasedb.complementos.DataVO;

import java.util.ArrayList;

public class MostrarActivity extends AppCompatActivity {
    private ListView listView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private ArrayList<DataVO> listarDataVO = new ArrayList<>();
    DataVO dataVO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        listView = findViewById(R.id.lista);
        this.iniciarFirebase();
        this.mostrarDatos();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dataVO = (DataVO) parent.getItemAtPosition(position);
                String idT = dataVO.getId();
                String nom = dataVO.getNombre();
                String ape = dataVO.getApellido();
                int edad = dataVO.getEdad();

                Intent intent = new Intent(getApplicationContext(), EditarActivity.class);
                intent.putExtra("id", idT);
                intent.putExtra("nombre", nom);
                intent.putExtra("apellido", ape);
                intent.putExtra("edad", edad);
                startActivity(intent);
                finish();
            }
        });


    }
    private void iniciarFirebase(){
        FirebaseApp.initializeApp(getApplicationContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    private void mostrarDatos(){
        databaseReference.child("Data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //limpiar lista cache
                listarDataVO.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    DataVO dvo = snapshot1.getValue(DataVO.class);
                    listarDataVO.add(dvo);

                    ArrayAdapter arrayAdapter = new ArrayAdapter(getApplication(), android.R.layout.simple_list_item_1, listarDataVO);
                    listView.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}