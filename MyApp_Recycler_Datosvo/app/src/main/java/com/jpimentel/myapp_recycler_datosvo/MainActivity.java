package com.jpimentel.myapp_recycler_datosvo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DatosVO> listaVO = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.insertarDatos();

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(listaVO);
        recyclerView.setAdapter(adaptadorRecycler);

    }
    public void insertarDatos(){
        listaVO.add(new DatosVO("Monky Donuts","Calientes y recien hechas",R.drawable.ic_donut));
        listaVO.add(new DatosVO("Comida MegaFast","Rapida y Excelente",R.drawable.ic_fastfood));
        listaVO.add(new DatosVO("La Hamburguesa Gigante","Super deliciosas y gigantes",R.drawable.ic_hamburger));
        listaVO.add(new DatosVO("Pizza Pizza","Ingredientes de calidad y deliciosos",R.drawable.ic_pizza));
        listaVO.add(new DatosVO("Los Tacos Bailarines","Al estilo Mex",R.drawable.ic_taco));
    }
}