package com.example.fechayhora.EJ_Cafeses;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fechayhora.R;

/**
 * Clase para Contador de cafes
 * @author Elena G (Beelzenef)
 */
public class ContadorCafesActivity extends AppCompatActivity {

    // Instancias a utilizar
    Button btn_masTiempo;
    Button btn_menosTiempo;
    Button btn_IniciarContador;

    CuantosCafes cafeteador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_cafes);

        // Identificando vistas
        btn_masTiempo = (Button)findViewById(R.id.btn_MasTiempo);
        btn_menosTiempo = (Button)findViewById(R.id.btn_MenosTiempo);
        btn_IniciarContador = (Button)findViewById(R.id.btn_TimerComienza);

        // Inicializando cafeteador
        cafeteador = new CuantosCafes();
    }

    public void manageOnClick(View v)
    {
        switch (v.getId()) {
            case R.id.btn_MasTiempo:
                break;
            case R.id.btn_MenosTiempo:
                break;
            case R.id.btn_TimerComienza:
                iniciarContador();
                break;
        }
    }

    void iniciarContador()
    {
        // Desactivando botones, para no modificar el tiempo que lleva corriendo
        btn_IniciarContador.setEnabled(false);
        btn_menosTiempo.setEnabled(false);
        btn_masTiempo.setEnabled(false);
    }

    void contadorFinalizado()
    {
        cafeteador.cafes++;

        if (cafeteador.cafes == 10)
        {
            demasiadosCafes();
        }
        else
        {
            // Activando botones
            btn_menosTiempo.setEnabled(true);
            btn_masTiempo.setEnabled(true);
            btn_IniciarContador.setEnabled(true);
        }
    }

    void sonidoNotificacion()
    {

    }

    void demasiadosCafes()
    {
        AlertDialog.Builder popup = new AlertDialog.Builder(this);
        popup.setTitle("Has tomado 10 cafeses");
        popup.setMessage("Demasiado elixir de los dioses por hoy");
        popup.setPositiveButton("Te odio", null);
        popup.show();
    }
}
