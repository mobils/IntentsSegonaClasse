package com.example.intentssegonaclasse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activitat2PerRecuperarDades extends AppCompatActivity {

    EditText nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitat2_per_recuperar_dades);

        nom = findViewById(R.id.nom_activitat2);

        Button boto2 = findViewById(R.id.boto_activitat2);

        boto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = nom.getText().toString();

                Intent in = new Intent();
                in.setData(Uri.parse(text));  //Posem dins del intent el text recuperat
                setResult(3,in);  //Torna a l'activitat que li ha cridat.

                finish();  //Cal posar finish per a que no es quedi esperant més ordres del intent
            }
        });
    }
}