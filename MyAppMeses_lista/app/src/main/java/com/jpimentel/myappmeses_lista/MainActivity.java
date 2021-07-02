package com.jpimentel.myappmeses_lista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    ArrayList<String> meses = new ArrayList<>();
    ArrayList<Integer> contenido = new ArrayList<>();
    ArrayList<Integer> num = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listaMeses);

        meses.add("ENERO");
        meses.add("FEBRERO");
        meses.add("MARZO");
        meses.add("ABRIL");
        meses.add("MAYO");
        meses.add("JUNIO");
        meses.add("JULIO");
        meses.add("AGOSTO");
        meses.add("SEPTIEMBRE");
        meses.add("OCTUBRE");
        meses.add("NOVIEMBRE");
        meses.add("DICIEMBRE");

        contenido.add(R.string.mes1);
        contenido.add(R.string.mes2);
        contenido.add(R.string.mes3);
        contenido.add(R.string.mes4);
        contenido.add(R.string.mes5);
        contenido.add(R.string.mes6);
        contenido.add(R.string.mes7);
        contenido.add(R.string.mes8);
        contenido.add(R.string.mes9);
        contenido.add(R.string.mes10);
        contenido.add(R.string.mes11);
        contenido.add(R.string.mes12);

        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        num.add(7);
        num.add(8);
        num.add(9);
        num.add(10);
        num.add(11);
        num.add(12);


        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, meses);
        //lista.setAdapter(arrayAdapter);
        AdaptadorLista adaptadorLista = new AdaptadorLista(this,R.layout.lista_personalizada,meses,num);
        lista.setAdapter(adaptadorLista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),MA_Meses.class);
                intent.putExtra("mes", meses.get(i));
                intent.putExtra("contenido", contenido.get(i));
                startActivity(intent);
            }
        });



    }

}