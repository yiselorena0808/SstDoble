package com.example.sstdoble;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder> {

    private final Context context;
    private final List<BlogItem> lista;

    public BlogAdapter(Context context, List<BlogItem> lista){
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_gestion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        BlogItem item = lista.get(position);
        holder.titulo.setText(item.getTitulo());

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo, imgUri, desc;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            titulo = itemView.findViewById(R.id.txttitu);
            imgUri = itemView.findViewById(R.id.btnAgregarImagen);
            desc = itemView.findViewById(R.id.txtdesc);
        }
    }
}
