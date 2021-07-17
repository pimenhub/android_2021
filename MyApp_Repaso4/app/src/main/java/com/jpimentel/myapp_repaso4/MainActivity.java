package com.jpimentel.myapp_repaso4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ArrayList<DatosVO> list = new ArrayList<>();
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerID);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        this.insertarDatos();

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(list);
        recyclerView.setAdapter(adaptadorRecycler);

        button = findViewById(R.id.btnMostrar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnMostrar:
                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }

    public void insertarDatos(){
        list.add(new DatosVO("Toyota",40000,R.drawable.ic_car));
        list.add(new DatosVO("Honda",30000,R.drawable.ic_car));
        list.add(new DatosVO("Hiuday",25000,R.drawable.ic_car));
        list.add(new DatosVO("Suzuki",40000,R.drawable.ic_car));
        list.add(new DatosVO("Mazda",35000,R.drawable.ic_car));
        list.add(new DatosVO("Nissan",55000,R.drawable.ic_car));
    }

}