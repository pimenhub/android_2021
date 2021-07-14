package com.jpimentel.myapp_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


//Errores a solventar
//1 implementar metodos abstractos
//2 crear la clase ViewHolder
//3 extender en la clase ViewHolder crear RecyclerView.ViewHolder
//4 crear el constructor de la clase
//5 si muestra @org.jetbrains.annotations.NotNull es de eliminarlo
public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {
    //se define la variable de tipo ArrayList
    private ArrayList<String> lista = new ArrayList<>();

    //se crear el constructor para la implementacion
    public AdaptadorRecycler(ArrayList<String> lista) {
        this.lista = lista;
    }

    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,null,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.asignarDatos(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtTexto);
        }

        public void asignarDatos(String datos){
            textView.setText(datos);
        }

    }
}
