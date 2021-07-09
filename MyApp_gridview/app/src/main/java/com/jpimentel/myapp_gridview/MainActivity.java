package com.jpimentel.myapp_gridview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<Integer> imagenesA = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridViewId);

        nombres.add("Perro");
        nombres.add("Gato");
        nombres.add("Hamster");
        nombres.add("Tortuga");
        nombres.add("Loro");
        nombres.add("Hurón");
        nombres.add("Perro");
        nombres.add("Gato");
        nombres.add("Hamster");
        nombres.add("Tortuga");
        nombres.add("Loro");
        nombres.add("Hurón");
        nombres.add("Perro");
        nombres.add("Gato");
        nombres.add("Hamster");
        nombres.add("Tortuga");
        nombres.add("Loro");
        nombres.add("Hurón");

        imagenesA.add(R.drawable.ic_dog);
        imagenesA.add(R.drawable.ic_cat);
        imagenesA.add(R.drawable.ic_hamster);
        imagenesA.add(R.drawable.ic_tortoise);
        imagenesA.add(R.drawable.ic_loro);
        imagenesA.add(R.drawable.ic_huron);
        imagenesA.add(R.drawable.ic_dog);
        imagenesA.add(R.drawable.ic_cat);
        imagenesA.add(R.drawable.ic_hamster);
        imagenesA.add(R.drawable.ic_tortoise);
        imagenesA.add(R.drawable.ic_loro);
        imagenesA.add(R.drawable.ic_huron);
        imagenesA.add(R.drawable.ic_dog);
        imagenesA.add(R.drawable.ic_cat);
        imagenesA.add(R.drawable.ic_hamster);
        imagenesA.add(R.drawable.ic_tortoise);
        imagenesA.add(R.drawable.ic_loro);
        imagenesA.add(R.drawable.ic_huron);

       /* ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nombres);
        gridView.setAdapter(adapter);*/

        AdaptadorGrid adaptadorGrid = new AdaptadorGrid(this, R.layout.grid_personalizado, nombres, imagenesA);
        gridView.setAdapter(adaptadorGrid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "A pulsado "+nombres.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MA_imagen.class);
                intent.putExtra("imagen", imagenesA.get(i));
                startActivity(intent);

            }
        });


    }

}