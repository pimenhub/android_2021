package com.jpimentel.myapptuitsw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jpimentel.myapptuitsw.complementos.MetodosSW;
import com.jpimentel.myapptuitsw.complementos.TuitVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    ArrayList<String> listaDatos;
    ArrayList<TuitVO> listaTuitsVO;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        refreshLayout = findViewById(R.id.refresh);

        this.mSW();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSW();
                refreshLayout.setRefreshing(false);
            }
        });

    }
    public void mSW(){
        metodosSW.consultarSW(this, this, this);
    }
    private void resultadoConsultaCompleta(JSONObject response){
        JSONArray jsonArray = response.optJSONArray("tbl_tuit");
        listaTuitsVO = new ArrayList<>();
        try {
            for(int i=0;i < jsonArray.length(); i++){
                TuitVO tvo = new TuitVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                tvo.setIdT(jsonObject.optInt("id_tuit"));
                tvo.setTituloT(jsonObject.optString("titulo_tuit"));
                tvo.setDescripcionT(jsonObject.optString("descripcion_tuit"));
                tvo.setFechaT(jsonObject.optString("fecha_tuit"));
                listaTuitsVO.add(tvo);
            }

            AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(listaTuitsVO);
            recyclerView.setAdapter(adaptadorRecycler);

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