package com.example.sstdoble;

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

import java.util.List;

public class ListaReportesAdapter extends RecyclerView.Adapter<ListaReportesAdapter.ViewHolder> {

    private final Context context;
    private final List<ListaReporterItem> lista;

    public ListaReportesAdapter(Context context, List<ListaReporterItem> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_lista_reporte, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListaReporterItem item = lista.get(position);
        holder.txtNombreFecha.setText(item.getNombre() + " - " + item.getFecha());

        // Acción del botón "Detalles"
        holder.btnDetalles.setOnClickListener(v -> {
            Intent intent = new Intent(context, FormChequeo.class);
            intent.putExtra("nombre", item.getNombre());
            intent.putExtra("fecha", item.getFecha());
            context.startActivity(intent);
        });

        // Acción del botón de descarga
        holder.btnDownload.setOnClickListener(v -> {
            // Aquí podrías agregar lógica de descarga si lo necesitas
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
            btnDownload = itemView.findViewById(R.id.btnDownloadl); // Asegúrate que este ID coincida exactamente con el XML
        }
    }
}

