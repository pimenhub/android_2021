package com.jpimentel.myapp_repaso3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {

    private Context context;
    private int referencia;
    private ArrayList<Integer> num = new ArrayList<>();

    public AdaptadorLista(Context context, int referencia, ArrayList<Integer> num) {
        this.context = context;
        this.referencia = referencia;
        this.num = num;
    }

    @Override
    public int getCount() {
        return this.num.size();
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
        v = layoutInflater.inflate(R.layout.lista_personalizada, null);

        int n = this.num.get(i);

        TextView textView;
        textView = v.findViewById(R.id.txtN);

        textView.setText(String.valueOf(n));

        return v;
    }
}
