package com.jpimentel.myappfirebasedatabase2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jpimentel.myappfirebasedatabase2021.complementos.DataVO;

import java.util.ArrayList;

public class MostrarActivity extends AppCompatActivity {
    private ListView listView;

    //Implementamos los objetos de Firebase que nos serviran para realizar las acciones respectivas
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private ArrayList<DataVO> listDataVO = new ArrayList<>();
    DataVO dataVO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        listView = findViewById(R.id.lista);
        this.iniciarFirebase();
        this.mostrar();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dataVO = (DataVO) adapterView.getItemAtPosition(i);
                String idContacto = dataVO.getIdContacto();
                String nombreContacto = dataVO.getNombreContacto();
                String apellidoContacto = dataVO.getApellidoContacto();
                int telefonoContacto = dataVO.getTelefonoContacto();

                Intent intent = new Intent(getApplicationContext(), EditarActivity.class);
                intent.putExtra("id", idContacto);
                intent.putExtra("nombre", nombreContacto);
                intent.putExtra("apellido", apellidoContacto);
                intent.putExtra("telefono", telefonoContacto);
                startActivity(intent);
                finish();
            }
        });

    }

    //metodo de inicializacion con firebase, de mi app, la base de datos y las referencias a la misma
    private void iniciarFirebase(){
        FirebaseApp.initializeApp(getApplicationContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void mostrar(){
        databaseReference.child("Contactos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                listDataVO.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    DataVO dataVO = dataSnapshot.getValue(DataVO.class);
                    listDataVO.add(dataVO);

                    ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),
                            android.R.layout.simple_list_item_1, listDataVO);
                    listView.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Error "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}