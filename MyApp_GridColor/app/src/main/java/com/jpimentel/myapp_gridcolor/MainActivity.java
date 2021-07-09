package com.jpimentel.myapp_gridcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<String> colorN = new ArrayList<>();
    ArrayList<Integer> color = new ArrayList<>();
    ArrayList<String> hexa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridId);



        colorN.add("ROJO");
        colorN.add("AMARILLO");
        colorN.add("AZUL");
        colorN.add("VERDE");

        color.add(Color.parseColor("#ff0000"));
        color.add(Color.parseColor("#ffff00"));
        color.add(Color.parseColor("#0000ff"));
        color.add(Color.parseColor("#008f39"));

        hexa.add("#ff0000");
        hexa.add("#ffff00");
        hexa.add("#0000ff");
        hexa.add("#008f39");

        AdaptadorGrid adaptadorGrid = new AdaptadorGrid(this,R.layout.grid_personalizado, colorN, color);
        gridView.setAdapter(adaptadorGrid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), MA_color.class);
                intent.putExtra("color", color.get(i));
                intent.putExtra("hexa", hexa.get(i));
                startActivity(intent);
            }
        });


    }

}