package com.example.sstdoble;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;




import java.util.ArrayList;
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

