package com.jpimentel.myapptuitsw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jpimentel.myapptuitsw.complementos.TuitVO;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder>{
    private ArrayList<TuitVO> listaDatos = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<TuitVO> listaDatos) {
        this.listaDatos = listaDatos;
    }
    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AdaptadorRecycler.ViewHolder holder, int position) {
        holder.asignarDatos(listaDatos.get(position).getTituloT(),
                listaDatos.get(position).getDescripcionT(),
                listaDatos.get(position).getFechaT());
    }

    @Override
    public int getItemCount() {
        return this.listaDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewT, textViewD, textViewF;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewT = itemView.findViewById(R.id.txtTitulo);
            textViewD = itemView.findViewById(R.id.txtDescripcion);
            textViewF = itemView.findViewById(R.id.txtFecha);
        }
        public void asignarDatos(String titulo, String descripcion, String fecha){
            textViewT.setText(titulo);
            textViewD.setText(descripcion);
            textViewF.setText(fecha);
        }
    }
}
