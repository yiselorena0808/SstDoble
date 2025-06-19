package com.example.sstdoble.controller;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.sstdoble.R;

import java.util.List;


public class PubliAdapter extends RecyclerView.Adapter<PubliAdapter.ViewHolder> {
    private List<PubliBlog> lista;

    public PubliAdapter(List<PubliBlog> lista) {
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvDescripcion;
        ImageView imgPublicacion;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            imgPublicacion = itemView.findViewById(R.id.imgPublicacion);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_publi, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PubliBlog pub = lista.get(position);
        holder.tvTitulo.setText(pub.getTitulo());
        holder.tvDescripcion.setText(pub.getDescripcion());
            Uri uri = Uri.parse(pub.getImagenUri());
            holder.imgPublicacion.setImageURI(uri);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}

