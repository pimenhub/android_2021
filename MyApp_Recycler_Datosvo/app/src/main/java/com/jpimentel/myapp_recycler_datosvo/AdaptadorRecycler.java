package com.jpimentel.myapp_recycler_datosvo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder>{

    private ArrayList<DatosVO> listaDatos = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<DatosVO> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.asignarDatos(listaDatos.get(position).getNombreR(),// recorrido 1
                listaDatos.get(position).getCalidadR(),// recorrido 1
                listaDatos.get(position).getImagenR());// recorrido 1
    }

    @Override
    public int getItemCount() {
        return this.listaDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewN, textViewC;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewN = itemView.findViewById(R.id.txtNombreR);
            textViewC = itemView.findViewById(R.id.txtCalidadR);
            imageView = itemView.findViewById(R.id.imgR);

        }
        public void asignarDatos(String nom, String cali, int img){
            textViewN.setText(nom);
            textViewC.setText(cali);
            imageView.setImageResource(img);
        }


    }
}
