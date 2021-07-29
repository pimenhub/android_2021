package com.jpimentel.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jpimentel.myappbdsqlite.complementos.BebidaVO;
import com.jpimentel.myappbdsqlite.complementos.ConstantesSQL;

import java.util.ArrayList;

public class MainActivityMostrar extends AppCompatActivity {
    private ListView listView;
    //Arreglos
    //Llenar la lista
    ArrayList<String> listaDatos;
    ///Obtener los datos de la base de datos
    ArrayList<BebidaVO> listaBebida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar);
        listView = findViewById(R.id.listaMostrar);

        this.mostrarBebida();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                trasladoInformacion(i);
            }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
        listView.setAdapter(arrayAdapter);

    }


    private void mostrarBebida(){
        ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_BEBIDA, null, ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        try {
            BebidaVO bebidaVO;
            listaBebida = new ArrayList<>();
            String consultaCompleta;
            consultaCompleta = "SELECT * FROM "+ConstantesSQL.TABLA_BEBIDA+";";
            Cursor cursor = database.rawQuery(consultaCompleta, null);
            //llenado de las variables VO y el arreglo de tipo clase
            while (cursor.moveToNext()){
                bebidaVO = new BebidaVO();
                bebidaVO.setIdBebida(cursor.getInt(0));
                bebidaVO.setNombreBebida(cursor.getString(1));
                bebidaVO.setSaborBebida(cursor.getString(2));
                bebidaVO.setTipoBebida(cursor.getString(3));
                bebidaVO.setPrecioBebida(cursor.getInt(4));
                listaBebida.add(bebidaVO);
            }
            listaDatos = new ArrayList<>();
            for (int i = 0; i < listaBebida.size(); i++){
                listaDatos.add(listaBebida.get(i).getIdBebida()+". "+listaBebida.get(i).getNombreBebida());
            }
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    private void trasladoInformacion(int position){
        String idB, nombreB, saborB, tipoB, precioB;

        idB = String.valueOf(listaBebida.get(position).getIdBebida());
        nombreB = listaBebida.get(position).getNombreBebida();
        saborB = listaBebida.get(position).getSaborBebida();
        tipoB = listaBebida.get(position).getTipoBebida();
        precioB = String.valueOf(listaBebida.get(position).getPrecioBebida());

        Intent intent = new Intent(getApplicationContext(), MainActivityDetalle.class);
        intent.putExtra("id", idB);
        intent.putExtra("nombre", nombreB);
        intent.putExtra("sabor", saborB);
        intent.putExtra("tipo", tipoB);
        intent.putExtra("precio", precioB);
        startActivity(intent);
    }

}