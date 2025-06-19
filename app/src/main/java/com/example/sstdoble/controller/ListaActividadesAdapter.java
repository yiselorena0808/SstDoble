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

public class ListaActividadesAdapter extends RecyclerView.Adapter<ListaActividadesAdapter.ViewHolder> {

    private Context context;
    private List<ListaActividadesItem> lista;

    public ListaActividadesAdapter(Context context, List<ListaActividadesItem> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_lista_item_actividades, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListaActividadesItem item = lista.get(position);
        holder.txtNombreFecha.setText(item.getNombreActividad() + " - " + item.getFecha());

        holder.btnDetalles.setOnClickListener(v -> {
            Intent intent = new Intent(context, CreaActividades.class);
            intent.putExtra("id", item.getId());
            intent.putExtra("usuario", item.getUsuario());
            intent.putExtra("nombreActividad", item.getNombreActividad());
            intent.putExtra("fecha", item.getFecha());
            intent.putExtra("descripcion", item.getDescripcion());
            intent.putExtra("evidencia", item.getEvidencia());
            context.startActivity(intent);
        });

        holder.btnDownload.setOnClickListener(v -> {



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
