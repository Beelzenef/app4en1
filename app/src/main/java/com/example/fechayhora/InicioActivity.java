package com.example.fechayhora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fechayhora.EJ_AdivinarNumero.AdivinarNumeroActivity;
import com.example.fechayhora.EJ_Cafeses.ContadorCafesActivity;
import com.example.fechayhora.EJ_Divisas.DivisasActivity;
import com.example.fechayhora.EJ_EnviarMensaje.EnviarMensajeActivity;

/**
 * Clase Inicio, ¡Intents para todos!
 * @author Elena G (Beelzenef)
 */
public class InicioActivity extends AppCompatActivity {

    Intent unIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void manageOnClick(View v)
    {
        switch (v.getId())
        {
            // Divisas
            case R.id.btn_Ejercicio1:
                unIntent = new Intent(InicioActivity.this, DivisasActivity.class);
                startActivity(unIntent);
                break;
            // Navegacion, webView
            case R.id.btn_Ejercicio2:
                unIntent = new Intent(InicioActivity.this, NavegadorActivity.class);
                startActivity(unIntent);
                break;
            // Contador de cafés
            case R.id.btn_Ejercicio3:
                unIntent = new Intent(InicioActivity.this, ContadorCafesActivity.class);
                startActivity(unIntent);
                break;
            // Mensaje entre Activities
            case R.id.btn_Ejercicio4:
                unIntent = new Intent(InicioActivity.this, EnviarMensajeActivity.class);
                startActivity(unIntent);
                break;
            // Ejercicio propio
            case R.id.btn_Ejercicio5:
                unIntent = new Intent(InicioActivity.this, AdivinarNumeroActivity.class);
                startActivity(unIntent);
                break;
            // Mostrar fecha y hora
            case R.id.btn_Ejercicio6:
                unIntent = new Intent(InicioActivity.this, MostrarFechaHoraActivity.class);
                startActivity(unIntent);
                break;
        }
    }
}
