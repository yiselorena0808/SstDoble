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

public class ListaChequeoAdapter extends RecyclerView.Adapter<ListaChequeoAdapter.ViewHolder> {

    private final Context context;
    private final List<ListaChequeoItem> lista;

    public ListaChequeoAdapter(Context context, List<ListaChequeoItem> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_lista_chequeo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListaChequeoItem item = lista.get(position);

        holder.txtNombreFecha.setText(item.getNombre() + " - " + item.getFecha());

        holder.btnDetalles.setOnClickListener(v -> {
            Intent intent = new Intent(context, Detalles_chequeo.class);
            intent.putExtra("usuario", item.getNombre());
            intent.putExtra("fecha", item.getFecha());
            intent.putExtra("hora", item.getHora());
            intent.putExtra("modelo", item.getModelo());
            intent.putExtra("marca", item.getMarca());
            intent.putExtra("soat", item.getSoat());
            intent.putExtra("tecnico", item.getTecnico());
            intent.putExtra("kilometraje", item.getKilometraje());

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // necesario si el context no es una activity
            context.startActivity(intent);
        });

        holder.btnDownload.setOnClickListener(v -> {
            // Implementa aquí la funcionalidad de descarga si deseas
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
