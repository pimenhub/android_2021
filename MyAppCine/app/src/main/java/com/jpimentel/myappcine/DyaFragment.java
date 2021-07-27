package com.jpimentel.myappcine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DyaFragment extends Fragment {

    private int directoresActores;

    public DyaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            directoresActores = getArguments().getInt("dya");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dya, container, false);
        TextView textView;
        textView = v.findViewById(R.id.txtDirecActores);
        textView.setText(directoresActores);
        return v;
    }
}