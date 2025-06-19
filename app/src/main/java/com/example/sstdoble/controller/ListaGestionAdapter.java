package com.example.sstdoble.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sstdoble.R;

import java.util.List;

public class ListaGestionAdapter extends RecyclerView.Adapter<ListaGestionAdapter.ViewHolder> {

    private Context context;
    private List<ListaGestionItem> lista;

    public ListaGestionAdapter(Context context, List<ListaGestionItem> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_gestion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListaGestionItem item = lista.get(position);
        holder.txtNombreFecha.setText(item.getNombre() + " - " + item.getFecha());

        holder.btnDetalles.setOnClickListener(v -> {
            Intent intent = new Intent(context, FormGestion.class);
            intent.putExtra("nombre", item.getNombre());
            intent.putExtra("fecha", item.getFecha());
            context.startActivity(intent);
        });

        holder.btnDownload.setOnClickListener(v -> {
            // Lógica para descarga, si la deseas implementar
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreFecha;
        Button btnDetalles;
        ImageButton btnDownload;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombreFecha = itemView.findViewById(R.id.txtNombreFecha);
            btnDetalles = itemView.findViewById(R.id.btnDetalles);
            btnDownload = itemView.findViewById(R.id.btnDownloadl);
        }
    }
}

