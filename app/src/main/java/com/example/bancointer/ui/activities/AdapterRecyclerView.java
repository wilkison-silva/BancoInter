package com.example.bancointer.ui.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bancointer.R;

import java.util.List;


public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.CartaoViewHolder> {


    private List<Cartao> list;
    private final Context context;

    @Override
    public int getItemViewType(int position) {

        switch (position) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 3:
                return 2;
        }
        return -1;
    }

    public AdapterRecyclerView(List<Cartao> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CartaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 0){
            view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view_portabilidade, parent, false);
        }
        else if (viewType == 1){
            view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view_cashback, parent, false);
        }
        else {
            view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view_investimento, parent, false);
        }

        return new CartaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartaoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    class CartaoViewHolder extends RecyclerView.ViewHolder {

        private final View view;
        private Cartao cartao;

        public CartaoViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }
}
