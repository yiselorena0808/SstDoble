package com.example.sstdoble.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_gestion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListaGestionItem item = lista.get(position);
        holder.nombreTextView.setText(item.getNombre());
        holder.fechaTextView.setText(item.getFecha());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        TextView fechaTextView;

        ViewHolder(View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.et_nombre);
            fechaTextView = itemView.findViewById(R.id.et_fecha);
        }
    }
}
