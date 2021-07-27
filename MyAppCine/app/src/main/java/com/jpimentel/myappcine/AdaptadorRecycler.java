package com.jpimentel.myappcine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    private ArrayList<DatosVO> listVO = new ArrayList<>();
    private static ClickListener clickListener;
    public AdaptadorRecycler(ArrayList<DatosVO> listVO) {
        this.listVO = listVO;
    }

    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.asignarDatos(listVO.get(position).getImagenPelicula(), listVO.get(position).getNombrePelicula(),
                listVO.get(position).getDuracionPelicula());
    }

    @Override
    public int getItemCount() {
        return this.listVO.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textViewN, textViewD;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.imgPe);
            textViewN = itemView.findViewById(R.id.txtNombrePe);
            textViewD = itemView.findViewById(R.id.txtDuracionPe);
        }
        public void asignarDatos(int img, String nombre, String duracion){
            imageView.setImageResource(img);
            textViewN.setText(nombre);
            textViewD.setText(duracion);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }
    }
    public interface ClickListener{
        public void onItemClick(int position, View v);
    }
    public void setOnItemClickListener(ClickListener clickListener){
        AdaptadorRecycler.clickListener = clickListener;
    }
}
