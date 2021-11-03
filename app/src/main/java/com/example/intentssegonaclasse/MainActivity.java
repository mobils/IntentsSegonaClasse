package com.example.intentssegonaclasse;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boto_main = findViewById(R.id.btn_main);

        boto_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Cridar a l'activitat2 per recuperar les dades que introdueixi allà.
                Intent i = new Intent(getApplicationContext(), Activitat2PerRecuperarDades.class);
                startActivityForResult(i,3);
                //el codi (requestCode) es per comunicar amb la segona activitat, trio el que vulgui
            }
        });


        Button boto_main_envia = findViewById(R.id.btn_main_envia);

        boto_main_envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Recupero el text i li envio a l'activitat 3

                EditText text_nom_jugador = findViewById(R.id.nom_per_activitat3);

                Intent in3 = new Intent(getApplicationContext(), Activitat3PerEnviarDades.class);
                //Fico les dades en un sac (Bundle) i dins del intent
                Bundle sac = new Bundle();

                sac.putString("nomJugador", text_nom_jugador.getText().toString());
                //nomJugador és el nom de l'etiqueta per saber com es dirà el que vull recuperar després.
                in3.putExtras(sac);  //sac dins del intent

                startActivity(in3);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Què farà quan recuperi les dades de la segona activitat.
        if (requestCode==3) {
            Uri recuperat = data.getData();
            String nom_recuperat = recuperat.toString();  ///? ??

            // mostrar nom_recuperat per pantalla.

            TextView text = findViewById(R.id.text_recuperat_act2);
            text.setText(nom_recuperat);
        }



    }
}