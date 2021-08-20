package com.jpimentel.myappdiccionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jpimentel.myappdiccionario.complementos.MetodosSW;
import com.jpimentel.myappdiccionario.complementos.PalabraVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private ListView listView;
    ArrayList<String> listaDatos;
    ArrayList<PalabraVO> listaPalabra;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lvPalabras);
        metodosSW.consultarSW(this,this,this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                trasladarDatos(i);
            }
        });
    }

    private void consultarPalabras(JSONObject response){
        PalabraVO palabraVO;
        JSONArray jsonArray = response.optJSONArray("tbl_palabra");
        listaPalabra = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                palabraVO = new PalabraVO();
                JSONObject jsonObject = null;
                jsonObject = jsonArray.getJSONObject(i);
                palabraVO.setId_palabra(jsonObject.optInt("id_palabra"));
                palabraVO.setTermino_palabra(jsonObject.optString("termino_palabra"));
                palabraVO.setSignificado_palabra(jsonObject.optString("significado_palabra"));
                listaPalabra.add(palabraVO);
            }
            listaDatos = new ArrayList<>();
            for(int i=0;i < listaPalabra.size();i++){
                if(listaPalabra.get(i).getId_palabra() != 0) {
                    listaDatos.add(listaPalabra.get(i).getTermino_palabra());
                }
                else {
                    Toast.makeText(this, "Lista Vacia", Toast.LENGTH_SHORT).show();
                }
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
            listView.setAdapter(arrayAdapter);
        }
        catch (Exception e){
            Toast.makeText(this, "Error regerente a "+e, Toast.LENGTH_SHORT).show();
            System.err.println(e.getCause()+" - **"+e.getMessage());
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        consultarPalabras(response);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a "+error, Toast.LENGTH_SHORT).show();
    }

    private void trasladarDatos(int position){
        String termino;
        String significado;
        termino = listaPalabra.get(position).getTermino_palabra();
        significado = listaPalabra.get(position).getSignificado_palabra();
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        intent.putExtra("termino", termino);
        intent.putExtra("significado", significado);
        startActivity(intent);
    }


}