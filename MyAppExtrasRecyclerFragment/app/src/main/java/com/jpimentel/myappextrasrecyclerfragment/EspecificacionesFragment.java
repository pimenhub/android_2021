package com.jpimentel.myappextrasrecyclerfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EspecificacionesFragment extends Fragment {

    private int especificacionesF1;

    public EspecificacionesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            especificacionesF1 = getArguments().getInt("espe");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_especificaciones, container, false);
        TextView textView;
        textView = v.findViewById(R.id.txtEspecificaciones);
        textView.setText(especificacionesF1);
        return v;
    }
}