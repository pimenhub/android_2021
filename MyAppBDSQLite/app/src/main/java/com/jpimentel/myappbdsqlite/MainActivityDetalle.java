package com.jpimentel.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivityDetalle extends AppCompatActivity {

    private Fragment fragment;
    private String id, nombre, sabor, tipo, precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle);

        fragment = new DetalleFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragment).commit();
        this.obtenerDatos();
        this.trasladoFragment();
    }
    private void obtenerDatos(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        nombre = bundle.getString("nombre");
        sabor = bundle.getString("sabor");
        tipo = bundle.getString("tipo");
        precio = bundle.getString("precio");
    }

    private void trasladoFragment(){
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        bundle.putString("nombre", nombre);
        bundle.putString("sabor", sabor);
        bundle.putString("tipo", tipo);
        bundle.putString("precio", precio);
        fragment.setArguments(bundle);
    }
}