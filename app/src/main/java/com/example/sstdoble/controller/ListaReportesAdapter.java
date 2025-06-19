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

        holder.txtTituloReporte.setText(item.getNombre_usuario() + " - " + item.getFecha());

        holder.btnDetalles.setOnClickListener(v -> {
            Intent intent = new Intent(context, Detalles_reporte.class);
            intent.putExtra("id", item.getId());
            intent.putExtra("nombre_usuario", item.getNombre_usuario());
            intent.putExtra("cargo", item.getCargo());
            intent.putExtra("cedula", item.getCedula());
            intent.putExtra("fecha", item.getFecha());
            intent.putExtra("lugar", item.getLugar());
            intent.putExtra("descripcion", item.getDescripcionreportes());
            intent.putExtra("imagen", item.getImagenreportes());
            intent.putExtra("archivos", item.getArchivos());
            intent.putExtra("estado", item.getEstado());

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
        TextView txtTituloReporte;
        Button btnDetalles;
        ImageButton btnDownload;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTituloReporte = itemView.findViewById(R.id.tvNombreUsuario);
            btnDetalles = itemView.findViewById(R.id.btnDetalles);
            btnDownload = itemView.findViewById(R.id.btnDownload);
        }
    }
}