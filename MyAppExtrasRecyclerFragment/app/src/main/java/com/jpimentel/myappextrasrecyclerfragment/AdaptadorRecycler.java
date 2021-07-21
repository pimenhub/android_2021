package com.jpimentel.myappextrasrecyclerfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {
    //Declarar variable de tipo Click paso 1
    private static ClickListener clickListener;

    private ArrayList<DatosVO> list = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<DatosVO> list) {
        this.list = list;
    }

    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.asignarDatos(list.get(position).getImagen(), list.get(position).getTexto());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
                                                                    //Paso 2
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //paso 6
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.imgItem);
            textView = itemView.findViewById(R.id.txtTexto);

        }
        public void asignarDatos(int img, String texto){
            imageView.setImageResource(img);
            textView.setText(texto);
        }

        @Override
        public void onClick(View view) {
            //paso 5
            clickListener.onItemClick(getAdapterPosition(), view);
        }
    }
    //paso 4
    public void setOnItemClickListener(ClickListener clickListener){
        AdaptadorRecycler.clickListener = clickListener;
    }
    //paso 3
    public interface ClickListener{
        public void onItemClick(int position, View v);
    }
}
