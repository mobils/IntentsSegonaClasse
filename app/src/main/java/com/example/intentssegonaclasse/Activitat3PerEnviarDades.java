package com.example.intentssegonaclasse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activitat3PerEnviarDades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitat3_per_enviar_dades);

        Bundle sac_recuperat = getIntent().getExtras();  //recupero el sac amb les dades enviades des del main Activity
        String nom = sac_recuperat.getString("nomJugador");

        //TODO: mostrar nom per pantalla

        TextView text = findViewById(R.id.text_activitat3);
        text.setText(nom);

    }
}