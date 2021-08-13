package com.jpimentel.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jpimentel.myappswlocal.complementos.ClienteVO;
import com.jpimentel.myappswlocal.complementos.MetodosSW;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivityMostrarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    ListView listView;
    ArrayList<String> listaDatos;
    ArrayList<ClienteVO> listaClienteVO;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar_sw);

        listView = findViewById(R.id.lvLitasClientes);
        metodosSW.consultarSW(this, this, this);
    }
    private void resultadoConsultaCompleta(JSONObject response){
        //ClienteVO clienteVO;
        JSONArray jsonArray = response.optJSONArray("tbl_cliente");
        listaClienteVO = new ArrayList<>();
        try {
            for(int i=0;i < jsonArray.length(); i++){
                ClienteVO  clienteVO = new ClienteVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);//1,2,3
                clienteVO.setIdCliente(jsonObject.optInt("id_cliente"));
                clienteVO.setNombreCliente(jsonObject.optString("nombre_cliente"));
                clienteVO.setApellidoCliente(jsonObject.optString("apellido_cliente"));
                clienteVO.setTelefonoCliente(jsonObject.optInt("telefono_cliente"));
                clienteVO.setDireccionCliente(jsonObject.optString("direccion_cliente"));

                listaClienteVO.add(clienteVO);//1-2-3
            }

            listaDatos = new ArrayList<>();//1*2*3
            for(int i=0;i < listaClienteVO.size();i++){
                if(listaClienteVO.get(i).getIdCliente() != 0) {
                    listaDatos.add(listaClienteVO.get(i).getIdCliente() + ". " + listaClienteVO.get(i).getNombreCliente());
                }
                else {
                    Toast.makeText(this, "Lista Vacia", Toast.LENGTH_SHORT).show();
                }
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
            listView.setAdapter(arrayAdapter);
        }
        catch (Exception e){
            Toast.makeText(this, "Error referente a C", Toast.LENGTH_LONG).show();
            System.err.println("C----- "+e.getCause()+" --- "+e.getMessage());
        }
    }
    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsultaCompleta(response);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error respuesta a C "+error, Toast.LENGTH_LONG).show();
        System.err.println("C***** "+error);
    }
}