package com.jpimentel.myapp_repaso4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {
    private ArrayList<DatosVO> listaVO = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<DatosVO> listaVO) {
        this.listaVO = listaVO;
    }

    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.asignarDatos(listaVO.get(position).getMarca(),
                listaVO.get(position).getPrecio(),
                listaVO.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return this.listaVO.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewM, textViewP;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewM = itemView.findViewById(R.id.marcaID);
            textViewP = itemView.findViewById(R.id.precioID);
            imageView = itemView.findViewById(R.id.imgID);
        }
        public void asignarDatos(String marca, int precio, int img){
            textViewM.setText(marca);
            textViewP.setText(String.valueOf(precio));
            imageView.setImageResource(img);
        }
    }
}
