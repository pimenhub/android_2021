package com.jpimentel.myappmeses_lista;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

//Extends de la clase BaseAdapter para tener los metodos necesarios y asi crear nuestro
//propio adaptador
public class AdaptadorLista extends BaseAdapter {

    private Context context;
    private int referenciaLista;
    private ArrayList<String> dato = new ArrayList<>();
    private ArrayList<Integer> num = new ArrayList<>();
    private ArrayList<Integer> datos = new ArrayList<>();

    //creacion del constructor para las referencias del parametro
    public AdaptadorLista(Context context, int referenciaLista, ArrayList<String> dato, ArrayList<Integer> num, ArrayList<Integer> datos) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.dato = dato;
        this.num = num;
        this.datos = datos;
    }


    @Override
    public int getCount() {
        return this.dato.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Variabla de tipo vista, que sera el retorno
        View v = view;
        //reconoce el contexto donde se va mostrar la lista personalizada
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        //crea la referecia para el retorno de la nueva lista personalizada
        v = layoutInflater.inflate(R.layout.lista_personalizada, null);

        //Recibir informacion del arraylist
        String mes;
        int numero;
        int contenido2;
        mes = this.dato.get(i);
        numero = this.num.get(i);
        contenido2 = this.datos.get(i);


        //Setteo de datos a los componetes
        TextView campo;
        TextView numeroCampo;
        Button btn;



        campo = v.findViewById(R.id.txtLista);
        numeroCampo = v.findViewById(R.id.txtNum);
        btn = v.findViewById(R.id.btnBoton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MA_Meses.class);
                intent.putExtra("mes", mes);
                intent.putExtra("contenido", contenido2);
                context.startActivity(intent);
            }
        });

        campo.setText(String.valueOf(mes));
        numeroCampo.setText(String.valueOf(numero));
        return v;
    }
}
