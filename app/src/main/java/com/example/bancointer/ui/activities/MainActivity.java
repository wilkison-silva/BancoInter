package com.example.bancointer.ui.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bancointer.R;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewOcultador;
    private ConstraintLayout constraintLayout;
    CardView cardView4;
    CardView cardView5;
    CardView cardView6;
    boolean mostrando = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewOcultador = findViewById(R.id.imageview_ocultador);
        cardView4 = findViewById(R.id.cardview_calendario4);
        cardView5 = findViewById(R.id.cardview_calendario5);
        cardView6 = findViewById(R.id.cardview_calendario6);
        constraintLayout = findViewById(R.id.constraint_layout_segunda_linha);

        imageViewOcultador.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Log.i("ImageView", "Clicado");

                if (mostrando) {
                    TransitionManager.beginDelayedTransition(constraintLayout,
                            new AutoTransition());
                    constraintLayout.setVisibility(View.GONE);
                    mostrando = false;
                }
                else {
                    TransitionManager.beginDelayedTransition(constraintLayout,
                            new AutoTransition());
                    constraintLayout.setVisibility(View.VISIBLE);
                    mostrando = true;
                }
            }
        });
    }
}