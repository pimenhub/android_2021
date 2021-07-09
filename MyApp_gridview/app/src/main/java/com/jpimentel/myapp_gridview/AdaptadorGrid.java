package com.jpimentel.myapp_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorGrid extends BaseAdapter {

    private Context context;
    private int referencia;
    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<Integer> imagenes = new ArrayList<>();

    public AdaptadorGrid(Context context, int referencia, ArrayList<String> nombres, ArrayList<Integer> imagenes) {
        this.context = context;
        this.referencia = referencia;
        this.nombres = nombres;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return this.nombres.size();
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
        View v = view;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.grid_personalizado, null);

        String nom;
        nom = this.nombres.get(i);
        int img;
        img = this.imagenes.get(i);

        TextView campoNombre;
        ImageView campoImagen;
        campoNombre = v.findViewById(R.id.txtGrid);
        campoImagen = v.findViewById(R.id.imgGrid);

        campoNombre.setText(String.valueOf(nom));
        campoImagen.setImageResource(img);
        return v;
    }
}
