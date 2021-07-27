package com.jpimentel.myappcine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    ArrayList<DatosVO> listaDatos1 = new ArrayList<>();
    ArrayList<DatosVO> listaDatos2 = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.llenarDatos1();
        this.llenarDatos2();

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(listaDatos1);

        adaptadorRecycler.setOnItemClickListener(new AdaptadorRecycler.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                //Intent intent;
                switch (position){
                    case 0:
                        //intent = new Intent(getApplicationContext(), MainActivity2.class);
                        //intent.putExtra("sinopsis", listaDatos2.get(position).getSinopsisPelicula());
                        //intent.putExtra("dya", listaDatos2.get(position).getDirectoresActoresPelicula());
                        //intent.putExtra("pyr", listaDatos2.get(position).getPuntuacioRecaudacionPelicula());
                        //startActivity(intent);
                        intentDiverso(position,getApplicationContext(),MainActivity2.class);
                        break;
                    case 1:
                        intentDiverso(position,getApplicationContext(),MainActivity2.class);
                        break;
                    case 2:
                        intentDiverso(position,getApplicationContext(),MainActivity2.class);
                        break;
                    case 3:
                        intentDiverso(position,getApplicationContext(),MainActivity2.class);
                        break;
                    case 4:
                        intentDiverso(position,getApplicationContext(),MainActivity2.class);
                        break;
                    case 5:
                        intentDiverso(position,getApplicationContext(),MainActivity2.class);
                        break;
                }
            }
        });

        recyclerView.setAdapter(adaptadorRecycler);
    }

    private void llenarDatos1(){
        listaDatos1.add(new DatosVO(R.drawable.ic_peli1, "Godzilla vs. Kong","1h 53m",55));
        listaDatos1.add(new DatosVO(R.drawable.ic_peli2, "Black Widow","2h 14m",55));
        listaDatos1.add(new DatosVO(R.drawable.ic_peli3, "Space Jam: Una Nueva Era","2h",50));
        listaDatos1.add(new DatosVO(R.drawable.ic_peli4, "Mortal Kombat","1h 50m",50));
        listaDatos1.add(new DatosVO(R.drawable.ic_peli5, "Soul","1h 47m",40));
        listaDatos1.add(new DatosVO(R.drawable.ic_peli6, "La liga de la justicia de Zack Snyder","4h 2m",60));
    }
    private void llenarDatos2(){
        listaDatos2.add(new DatosVO(R.string.sinopsisString1, R.string.direcActString1, R.string.puntuaRecaString1));
        listaDatos2.add(new DatosVO(R.string.sinopsisString2, R.string.direcActString2, R.string.puntuaRecaString2));
        listaDatos2.add(new DatosVO(R.string.sinopsisString3, R.string.direcActString3, R.string.puntuaRecaString3));
        listaDatos2.add(new DatosVO(R.string.sinopsisString4, R.string.direcActString4, R.string.puntuaRecaString4));
        listaDatos2.add(new DatosVO(R.string.sinopsisString5, R.string.direcActString5, R.string.puntuaRecaString5));
        listaDatos2.add(new DatosVO(R.string.sinopsisString6, R.string.direcActString6, R.string.puntuaRecaString6));
    }

    public void intentDiverso(int p, Context context, Class cls){
        Intent intent = new Intent(context,cls);

        intent.putExtra("imagen", listaDatos1.get(p).getImagenPelicula());
        intent.putExtra("nombrePeli",listaDatos1.get(p).getNombrePelicula());
        intent.putExtra("precio", listaDatos1.get(p).getPrecioBoletoPelicula());

        intent.putExtra("sinopsis", listaDatos2.get(p).getSinopsisPelicula());
        intent.putExtra("dya", listaDatos2.get(p).getDirectoresActoresPelicula());
        intent.putExtra("pyr", listaDatos2.get(p).getPuntuacioRecaudacionPelicula());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.listaItem:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.gridItem:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}