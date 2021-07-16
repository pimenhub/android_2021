package com.jpimentel.myappfragmentdinamico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class FragmentTres extends Fragment {

    public FragmentTres() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tres, container, false);
        Button button, button1;
        button = v.findViewById(R.id.btnF3H);
        button1 = v.findViewById(R.id.btnF3A);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se encuentra en el Fragmento 3 Hola", Toast.LENGTH_SHORT).show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se encuentra en el Fragmento 3 Adios", Toast.LENGTH_SHORT).show();
            }
        });
        return  v;
    }
}