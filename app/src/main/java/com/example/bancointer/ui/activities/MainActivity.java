package com.example.bancointer.ui.activities;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.bancointer.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewOcultador;
    private ConstraintLayout constraintLayout_segunda_linha;
    private ConstraintLayout constraintLayout_ocultador;
    private ConstraintLayout constraintLayout_slider;
    private ImageView imageViewEye;
    private boolean mostrarSaldo = true;
    private TextView textViewSaldo;

    private RecyclerView recyclerView;
    private AdapterRecyclerView adapterRecyclerView;
    private List<Cartao> listaCartoes;
    LinearLayoutManager horizontalLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuraLista();
        configuraRecyclerView();
        configuraMenuExpansivel();
        configuraOpcaoEsconderSaldo();

    }

    private void configuraOpcaoEsconderSaldo() {
        imageViewEye = findViewById(R.id.imageViewEye);
        textViewSaldo = findViewById(R.id.textview_saldo);
        imageViewEye.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (mostrarSaldo){
                    esconderSaldo(R.drawable.ic_eye_blocked, "_ _ _", false);
                }
                else {
                    esconderSaldo(R.drawable.ic_eye_open, "2.916,18", true);
                }
            }
        });
    }

    private void esconderSaldo(int p, String s, boolean b) {
        imageViewEye.setImageResource(p);
        textViewSaldo.setText(s);
        mostrarSaldo = b;
    }

    private void configuraMenuExpansivel() {
        imageViewOcultador = findViewById(R.id.imageview_ocultador);
        constraintLayout_segunda_linha = findViewById(R.id.constraint_layout_expansivel);
        constraintLayout_ocultador = findViewById(R.id.constraint_layout_ocultador);
        constraintLayout_slider = findViewById(R.id.constraint_layout_slider);

        imageViewOcultador.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                if (constraintLayout_segunda_linha.getVisibility() == View.VISIBLE) {
                    transicaoParaEsconder(View.GONE, R.drawable.ic_mostrar_mais);
                }
                else {
                    transicaoParaEsconder(View.VISIBLE, R.drawable.ic_mostrar_menos);
                }
            }
        });
    }














    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void transicaoParaEsconder(int gone, int p) {
        TransitionManager.beginDelayedTransition(constraintLayout_segunda_linha,
                new AutoTransition());
        constraintLayout_segunda_linha.setVisibility(gone);
        TransitionManager.beginDelayedTransition(constraintLayout_ocultador,
                new AutoTransition());
        imageViewOcultador.setImageResource(p);
        TransitionManager.beginDelayedTransition(constraintLayout_slider,
                new AutoTransition());
    }

    private void configuraRecyclerView() {
        adapterRecyclerView = new AdapterRecyclerView(listaCartoes, this);
        recyclerView = findViewById(R.id.recyclerviewCartoes);

        horizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);

        recyclerView.setLayoutManager(horizontalLayout);
        recyclerView.setAdapter(adapterRecyclerView);

        SnapHelper helper = new PagerSnapHelper();
        helper.attachToRecyclerView(recyclerView);
    }

    private void configuraLista() {
        listaCartoes = new ArrayList<>();
        listaCartoes.add(new Cartao());
        listaCartoes.add(new Cartao());
        listaCartoes.add(new Cartao());
    }
}