package com.jpimentel.myappbdsqlite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetalleFragment extends Fragment {

    private String id, nombre, sabor, tipo, precio;

    public DetalleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString("id");
            nombre = getArguments().getString("nombre");
            sabor = getArguments().getString("sabor");
            tipo = getArguments().getString("tipo");
            precio = getArguments().getString("precio");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detalle, container, false);

        TextView textViewId, textViewNombre, textViewSabor, textViewTipo, textViewPrecio;
        textViewId = v.findViewById(R.id.idFrag);
        textViewNombre = v.findViewById(R.id.nombreFrag);
        textViewSabor = v.findViewById(R.id.saborFrag);
        textViewTipo = v.findViewById(R.id.tipoFrag);
        textViewPrecio = v.findViewById(R.id.precioFrag);

        textViewId.setText(id);
        textViewNombre.setText(nombre);
        textViewSabor.setText(sabor);
        textViewTipo.setText(tipo);
        textViewPrecio.setText(precio);

        return v;

    }
}