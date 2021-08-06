package com.jpimentel.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jpimentel.myappswlocal.complementos.ClienteVO;
import com.jpimentel.myappswlocal.complementos.MetodosSW;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivityBuscarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText editText;
    TextView textViewNombre, textViewApellido, textViewTelefono, textViewDireccion;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buscar_sw);
        editText = findViewById(R.id.edtBuscarCliente);
        textViewNombre = findViewById(R.id.txtNombreCliente);
        textViewApellido = findViewById(R.id.txtApellidoCliente);
        textViewTelefono = findViewById(R.id.txtTelefonoCliente);
        textViewDireccion = findViewById(R.id.txtDireccionCliente);
    }

    public void onClick(View view) {
        this.buscarID();
    }

    private void buscarID(){
        if(!editText.getText().toString().isEmpty()){
            metodosSW.buscarIDSW(this,Integer.parseInt(editText.getText().toString()), this, this);
        }
        else {
            Toast.makeText(this, "Debe de llenar el campo", Toast.LENGTH_LONG).show();
        }
    }
    private void resultadoConsulta(JSONObject response){
        ClienteVO clienteVO = new ClienteVO();
        JSONArray jsonArray = response.optJSONArray("tbl_cliente");
        try {
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                clienteVO.setNombreCliente(jsonObject.optString("nombre_cliente"));
                clienteVO.setApellidoCliente(jsonObject.optString("apellido_cliente"));
                clienteVO.setTelefonoCliente(jsonObject.optInt("telefono_cliente"));
                clienteVO.setDireccionCliente(jsonObject.optString("direccion_cliente"));

                String dato = clienteVO.getNombreCliente();
                if(!dato.equals("...")) {
                    textViewNombre.setText(clienteVO.getNombreCliente());
                    textViewApellido.setText(clienteVO.getApellidoCliente());
                    textViewTelefono.setText(String.valueOf(clienteVO.getTelefonoCliente()));
                    textViewDireccion.setText(clienteVO.getDireccionCliente());
                }
                else{
                    textViewNombre.setText("...");
                    textViewApellido.setText("...");
                    textViewTelefono.setText("...");
                    textViewDireccion.setText("...");
                    Toast.makeText(this, "Datos no Encontrados", Toast.LENGTH_SHORT).show();
                }
        }
        catch (Exception e){
            Toast.makeText(this, "Error referente a B "+e, Toast.LENGTH_LONG).show();
            System.err.println("B----- "+e.getCause()+" --- "+e.getMessage());
        }
    }
    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsulta(response);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error respuesta a B "+error, Toast.LENGTH_LONG).show();
        System.err.println("B***** "+error);
    }
}