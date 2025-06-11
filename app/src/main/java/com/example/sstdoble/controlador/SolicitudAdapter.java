package com.example.sstdoble.controlador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sstdoble.R;

import java.util.List;

public class SolicitudAdapter extends RecyclerView.Adapter<SolicitudAdapter.ViewHolder> {
    private List<SolicitudEPP> lista;
    private Context context;

    public SolicitudAdapter(List<SolicitudEPP> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_gestion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        SolicitudEPP item = lista.get(position);
        holder.txtNombreFecha.setText(item.getNombre() + " - " + item.getFecha());

        holder.btnDetalles.setOnClickListener(v -> {
            Toast.makeText(context, "Detalles de " + item.getNombre(), Toast.LENGTH_SHORT).show();
        });

        holder.btnDownload.setOnClickListener(v -> {
            Toast.makeText(context, "Descargando PDF para " + item.getNombre(), Toast.LENGTH_SHORT).show();
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
