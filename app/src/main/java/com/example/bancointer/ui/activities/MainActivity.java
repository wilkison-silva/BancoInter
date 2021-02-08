package com.example.bancointer.ui.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.bancointer.R;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewOcultador;
    private ConstraintLayout constraintLayout_segunda_linha;
    private ConstraintLayout constraintLayout_ocultador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewOcultador = findViewById(R.id.imageview_ocultador);
        constraintLayout_segunda_linha = findViewById(R.id.constraint_layout_expansivel);
        constraintLayout_ocultador = findViewById(R.id.constraint_layout_ocultador);

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
                }
                else {
                    TransitionManager.beginDelayedTransition(constraintLayout_segunda_linha,
                            new AutoTransition());
                    constraintLayout_segunda_linha.setVisibility(View.VISIBLE);
                    TransitionManager.beginDelayedTransition(constraintLayout_ocultador,
                            new AutoTransition());
                    imageViewOcultador.setImageResource(R.drawable.ic_mostrar_menos);
                }
            }
        });
    }
}