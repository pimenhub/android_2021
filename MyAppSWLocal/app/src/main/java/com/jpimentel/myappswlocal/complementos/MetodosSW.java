package com.jpimentel.myappswlocal.complementos;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MetodosSW {
    //Declarar una constante de la IP del servidor local en mi Red LAN
    public static final String IP_SERVER = "http://192.168.0.3/";

    //Implementar variables para la conexion y obtencion de informacion
    Context context;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public MetodosSW() {
    }

    //Metodo de Insertar
    public void insertarSW(Context context, String nombre, String apellido,
                           int telefono, String direccion,
                           Response.Listener listener, Response.ErrorListener errorListener){
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"cliente_sw/insertar_sw.php?nombre_cliente="+nombre+"&apellido_cliente="+apellido+
                "&telefono_cliente="+telefono+"&direccion_cliente="+direccion;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoI "+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("I----- "+e.getCause()+" --- "+e.getMessage());
        }

    }
    //Metodo Buscar por ID
    public void buscarIDSW(Context context, int id, Response.Listener listener,
                           Response.ErrorListener errorListener){
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"cliente_sw/buscar_id.php?id_cliente="+id;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoB "+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("B----- "+e.getCause()+" --- "+e.getMessage());
        }

    }
    //Metodo Consultar
    public void consultarSW(Context context, Response.Listener listener,
                            Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"cliente_sw/mostrar_sw.php";
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoC "+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("C----- "+e.getCause()+" --- "+e.getMessage());
        }
    }

    //Metodo Eliminar
    public void eliminarSW(Context context, int id, Response.Listener listener,
                           Response.ErrorListener errorListener){
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"cliente_sw/eliminar_sw.php?id_cliente="+id;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoE "+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("E----- "+e.getCause()+" --- "+e.getMessage());
        }
    }

    //Metodo Actualizar
    public void actualizarSW(Context context, int id, String nombre, String apellido,
                             int telefono, String direccion,Response.Listener listener,
                             Response.ErrorListener errorListener){
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"cliente_sw/actualizar_sw.php?id_cliente="+id+"&nombre_cliente="+nombre+
                    "&apellido_cliente="+apellido+"&telefono_cliente="+telefono+"&direccion_cliente="+direccion;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoA "+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("A----- "+e.getCause()+" --- "+e.getMessage());
        }

    }

}
