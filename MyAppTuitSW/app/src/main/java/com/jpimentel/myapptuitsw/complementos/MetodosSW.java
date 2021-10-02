package com.jpimentel.myapptuitsw.complementos;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MetodosSW {
    //Declarar una constante de la IP del servidor local en mi Red LAN
    //AZURE
    //public static final String IP_SERVER = "https://intecap2021.azurewebsites.net/";

    //INSTANCIA DE GOOGLE CLOUD
    public static final String IP_SERVER = "http://34.135.204.225/";

    //Implementar variables para la conexion y obtencion de informacion
    Context context;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public MetodosSW() {
    }
    //Metodo Consultar
    public void consultarSW(Context context, Response.Listener listener,
                            Response.ErrorListener errorListener) {
        this.context = context;
        try {
            String url;
            url = IP_SERVER+"tuit_sw/ver_tuits.php";
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);
        }
        catch (Exception e){
            Toast.makeText(context, "ConflictoC "+e.getMessage(), Toast.LENGTH_LONG).show();
            System.err.println("C----- "+e.getCause()+" --- "+e.getMessage());
        }
    }
}
