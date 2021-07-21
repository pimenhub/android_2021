package com.jpimentel.myappextrasrecyclerfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DatosVO> listVO = new ArrayList<>();
    private ArrayList<DatosVO> listVO2 = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerID);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        this.insertarDatos();
        this.insertarInformacion();
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(listVO);

        adaptadorRecycler.setOnItemClickListener(new AdaptadorRecycler.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent;
                switch (position){
                    case 0:
                      intent = new Intent(getApplicationContext(), MainActivity2.class);
                      intent.putExtra("detalle", listVO2.get(position).getDetalle());
                      intent.putExtra("especificaciones", listVO2.get(position).getEspecificaciones());
                      startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), MainActivity2.class);
                        intent.putExtra("detalle", listVO2.get(position).getDetalle());
                        intent.putExtra("especificaciones", listVO2.get(position).getEspecificaciones());
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), MainActivity2.class);
                        intent.putExtra("detalle", listVO2.get(position).getDetalle());
                        intent.putExtra("especificaciones", listVO2.get(position).getEspecificaciones());
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), MainActivity2.class);
                        intent.putExtra("detalle", listVO2.get(position).getDetalle());
                        intent.putExtra("especificaciones", listVO2.get(position).getEspecificaciones());
                        startActivity(intent);
                        break;
                }
            }
        });


        recyclerView.setAdapter(adaptadorRecycler);


    }

    public void insertarDatos(){
        listVO.add(new DatosVO(R.drawable.ic_electronic, "Computadora"));
        listVO.add(new DatosVO(R.drawable.ic_electronic, "Smartphone"));
        listVO.add(new DatosVO(R.drawable.ic_electronic, "Audifonos"));
        listVO.add(new DatosVO(R.drawable.ic_electronic, "Television"));
    }
    public void insertarInformacion(){
        listVO2.add(new DatosVO(R.string.detalleString1, R.string.especificacionesString1));
        listVO2.add(new DatosVO(R.string.detalleString2, R.string.especificacionesString2));
        listVO2.add(new DatosVO(R.string.detalleString3, R.string.especificacionesString3));
        listVO2.add(new DatosVO(R.string.detalleString4, R.string.especificacionesString4));
    }
}