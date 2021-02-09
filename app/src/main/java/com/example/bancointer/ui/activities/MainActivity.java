package com.example.bancointer.ui.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

        listaCartoes = new ArrayList<>();
        listaCartoes.add(new Cartao());
        listaCartoes.add(new Cartao());
        listaCartoes.add(new Cartao());
        adapterRecyclerView = new AdapterRecyclerView(listaCartoes, this);
        recyclerView = findViewById(R.id.recyclerviewCartoes);

        horizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);

        recyclerView.setLayoutManager(horizontalLayout);
        recyclerView.setAdapter(adapterRecyclerView);

//        SnapHelper helper = new LinearSnapHelper();
        SnapHelper helper = new PagerSnapHelper();
//        SnappingRecyclerView helper = new SnappingRecyclerView(this);
        helper.attachToRecyclerView(recyclerView);
//        adapterRecyclerView.atualizar();
        Log.d("RecyclerView", "Lista: " + adapterRecyclerView.getItemCount());

        imageViewOcultador = findViewById(R.id.imageview_ocultador);
        constraintLayout_segunda_linha = findViewById(R.id.constraint_layout_expansivel);
        constraintLayout_ocultador = findViewById(R.id.constraint_layout_ocultador);
        constraintLayout_slider = findViewById(R.id.constraint_layout_slider);

        imageViewOcultador.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Log.i("ImageView", "Clicado");

                if (constraintLayout_segunda_linha.getVisibility() == View.VISIBLE) {
                    TransitionManager.beginDelayedTransition(constraintLayout_segunda_linha,
                            new AutoTransition());
                    constraintLayout_segunda_linha.setVisibility(View.GONE);
                    TransitionManager.beginDelayedTransition(constraintLayout_ocultador,
                            new AutoTransition());
                    imageViewOcultador.setImageResource(R.drawable.ic_mostrar_mais);
                    TransitionManager.beginDelayedTransition(constraintLayout_slider,
                            new AutoTransition());
                }
                else {
                    TransitionManager.beginDelayedTransition(constraintLayout_segunda_linha,
                            new AutoTransition());
                    constraintLayout_segunda_linha.setVisibility(View.VISIBLE);
                    TransitionManager.beginDelayedTransition(constraintLayout_ocultador,
                            new AutoTransition());
                    imageViewOcultador.setImageResource(R.drawable.ic_mostrar_menos);
                    TransitionManager.beginDelayedTransition(constraintLayout_slider,
                            new AutoTransition());
                }
            }
        });

        imageViewEye = findViewById(R.id.imageViewEye);
        textViewSaldo = findViewById(R.id.textview_saldo);
        imageViewEye.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (mostrarSaldo){
                    imageViewEye.setImageResource(R.drawable.ic_eye_blocked);
                    textViewSaldo.setText("_ _ _");
                    mostrarSaldo = false;
                }
                else {
                    imageViewEye.setImageResource(R.drawable.ic_eye_open);
                    textViewSaldo.setText("2.916,18");
                    mostrarSaldo = true;
                }


            }
        });

    }
}