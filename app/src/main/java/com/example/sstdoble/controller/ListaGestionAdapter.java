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

    private final Context context;
    private final List<ListaGestionItem> lista;

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

        // ✅ Solo mostrar nombre + fecha
        holder.txtNombreFecha.setText(item.getNombre() + " - " + item.getFechaCreacion());

        // ✅ Enviar todos los datos al detalle
        holder.btnDetalles.setOnClickListener(v -> {
            Intent intent = new Intent(context, detalles_gestion.class);
            intent.putExtra("idUsuario", item.getIdUsuario());
            intent.putExtra("nombre", item.getNombre());
            intent.putExtra("apellido", item.getApellido());
            intent.putExtra("cedula", item.getCedula());
            intent.putExtra("cargo", item.getCargo());
            intent.putExtra("productos", item.getProductos());
            intent.putExtra("cantidad", String.valueOf(item.getCantidad()));
            intent.putExtra("importancia", item.getImportancia());
            intent.putExtra("estado", item.getEstado());
            intent.putExtra("fechaCreacion", item.getFechaCreacion());

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });

        holder.btnDownload.setOnClickListener(v -> {
            // Aquí lógica de descarga si la necesitas
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
            btnDownload = itemView.findViewById(R.id.btnDownload);
        }
    }
}
