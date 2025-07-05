package com.example.sstdoble.controller;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sstdoble.R;
import com.example.sstdoble.model.Constantes;
import java.util.List;

public class PubliAdapter extends RecyclerView.Adapter<PubliAdapter.PubliViewHolder> {

    private List<PubliBlog> publicaciones;

    public PubliAdapter(List<PubliBlog> publicaciones) {
        this.publicaciones = publicaciones;
    }

    @NonNull
    @Override
    public PubliViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_publi, parent, false);
        return new PubliViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PubliViewHolder holder, int position) {
        PubliBlog publi = publicaciones.get(position);
        holder.tituloTextView.setText(publi.getTitulo());
        holder.descripcionTextView.setText(publi.getDescripcion());

        // Cargar la imagen si la URI no es nula
        if (publi.getImagenUri() != null) {
            // Usar Glide o Picasso para cargar la imagen (comentado para que lo implementes)
            // Glide.with(holder.itemView.getContext()).load(publi.getImagenUri()).into(holder.imagenView);
        }
    }

    @Override
    public int getItemCount() {
        return publicaciones.size();
    }

    static class PubliViewHolder extends RecyclerView.ViewHolder {
        TextView tituloTextView;
        TextView descripcionTextView;
        ImageView imagenView;

        @SuppressLint("WrongViewCast")
        public PubliViewHolder(View itemView) {
            super(itemView);
            tituloTextView = itemView.findViewById(R.id.tvTitulo);
            descripcionTextView = itemView.findViewById(R.id.tvDescripcion);
            imagenView = itemView.findViewById(R.id.btnAgregarImagen);
        }
    }
}
