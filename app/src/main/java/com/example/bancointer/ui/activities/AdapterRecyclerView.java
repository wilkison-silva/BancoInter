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
    //private OnItemClickListener onItemClickListener;

    //public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    //    this.onItemClickListener = onItemClickListener;
    //}

    public void atualizar(){
        notifyDataSetChanged();
    }

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

//        Cartao cartao = this.list.get(position);
//        holder.vincularDados(cartao);
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
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
              //      onItemClickListener.OnItemClick(cartao, CartaoViewHolder.this.getAdapterPosition());
                }
            });
             */
        }

        public void vincularDados(Cartao cartao) {
            this.cartao = cartao;
//            mostrarDescricao(view, cartao);
//            mostrarCategoria(view, cartao);
//            mostrarLogin(view, cartao);
//            mostrarSenha(view, cartao);
//            configurarCorCortao(view, cartao);
        }

        /*
        private void configurarCorCortao(View view, Cartao cartao) {
            CardView cardView = view.findViewById(R.id.cardview_simulacao);
            cardView.setCardBackgroundColor(Color.parseColor(cartao.getCorCartao()));
        }

        private void mostrarSenha(View view, Cartao cartao) {
            TextView textViewSenha = view.findViewById(R.id.cardview_textview_senha);
            textViewSenha.setText(cartao.getSenha());
            textViewSenha.setTextColor(Color.parseColor(cartao.getCorTexto()));
        }

        private void mostrarLogin(View view, Cartao cartao) {
            TextView textViewLogin = view.findViewById(R.id.cardview_textview_login);
            textViewLogin.setText(cartao.getLogin());
            textViewLogin.setTextColor(Color.parseColor(cartao.getCorTexto()));
        }

        private void mostrarCategoria(View view, Cartao cartao) {
            TextView textViewCategoria = view.findViewById(R.id.cardview_textview_categoria);
            textViewCategoria.setText(cartao.getCategoria());
            textViewCategoria.setTextColor(Color.parseColor(cartao.getCorTexto()));
        }

        private void mostrarDescricao(View view, Cartao cartao) {
            TextView textViewDescricao = view.findViewById(R.id.cardview_textview_descricao);
            textViewDescricao.setText(cartao.getDescricao());
            textViewDescricao.setTextColor(Color.parseColor(cartao.getCorTexto()));
        }

         */

    }
}
