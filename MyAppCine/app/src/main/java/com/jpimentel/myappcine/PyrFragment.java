package com.jpimentel.myappcine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PyrFragment extends Fragment {

    private int puntuacionRecaudacion;

    public PyrFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            puntuacionRecaudacion = getArguments().getInt("pyr");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pyr, container, false);
        TextView textView;
        textView = v.findViewById(R.id.txtPuntuaReca);
        textView.setText(puntuacionRecaudacion);
        return v;
    }
}