package com.jpimentel.myappswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jpimentel.myappswlocal.complementos.ClienteVO;
import com.jpimentel.myappswlocal.complementos.MetodosSW;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivityActualizarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText editTextBuscar, editTextNombre, editTextApellido, editTextTelefono, editTextDireccion;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar_sw);

        editTextBuscar = findViewById(R.id.edtBuscarClienteActualizar);
        editTextNombre = findViewById(R.id.edtNombreClienteActualizar);
        editTextApellido = findViewById(R.id.edtApellidoClienteActualizar);
        editTextTelefono = findViewById(R.id.edtTelefonoClienteActualizar);
        editTextDireccion = findViewById(R.id.edtDireccionClienteActualizar);
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnActualizarCliente:
                this.actualizar();
                break;
            case R.id.imgBuscarActualizar:
                this.buscarID();
                break;
        }

    }

    private void actualizar(){
        if(!editTextBuscar.getText().toString().isEmpty()&&!editTextNombre.getText().toString().isEmpty()&&
                !editTextApellido.getText().toString().isEmpty()&&!editTextTelefono.getText().toString().isEmpty()&&
                !editTextDireccion.getText().toString().isEmpty()){

            metodosSW.actualizarSW(this,Integer.parseInt(editTextBuscar.getText().toString()),
                    editTextNombre.getText().toString(),editTextApellido.getText().toString(),
                    Integer.parseInt(editTextTelefono.getText().toString()),editTextDireccion.getText().toString(),
                    this, this);

            editTextBuscar.setText("");
            editTextNombre.setText("...");
            editTextApellido.setText("...");
            editTextTelefono.setText("...");
            editTextDireccion.setText("...");
            Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Debe de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void buscarID(){
        if(!editTextBuscar.getText().toString().isEmpty()){
            metodosSW.buscarIDSW(this, Integer.parseInt(editTextBuscar.getText().toString()), this, this);
        }
        else {
            Toast.makeText(this, "Debe de llenar el campo", Toast.LENGTH_SHORT).show();
        }
    }

    private void resultadoBusqueda(JSONObject response){
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
                editTextNombre.setText(clienteVO.getNombreCliente());
                editTextApellido.setText(clienteVO.getApellidoCliente());
                editTextTelefono.setText(String.valueOf(clienteVO.getTelefonoCliente()));
                editTextDireccion.setText(clienteVO.getDireccionCliente());
            }
            else {
                editTextNombre.setText("...");
                editTextApellido.setText("...");
                editTextTelefono.setText("...");
                editTextDireccion.setText("...");
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
        this.resultadoBusqueda(response);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a A "+error, Toast.LENGTH_SHORT).show();
        System.err.println("A***** "+error);
    }
}