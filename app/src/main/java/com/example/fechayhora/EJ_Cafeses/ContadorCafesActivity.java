package com.example.fechayhora.EJ_Cafeses;

import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fechayhora.R;

import org.w3c.dom.Text;

/**
 * Clase para Contador de cafes
 *
 * @author Elena G (Beelzenef)
 */
public class ContadorCafesActivity extends AppCompatActivity {

    // Instancias a utilizar
    private Button btn_masTiempo;
    private Button btn_menosTiempo;
    private Button btn_IniciarContador;
    private TextView txtV_LlevasXCafes;
    private TextView txtV_MarcadorTiempo;

    CuantosCafes cafeteador;

    private ContadorTiempo contadorTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_cafes);

        // Identificando vistas
        btn_masTiempo = (Button) findViewById(R.id.btn_MasTiempo);
        btn_menosTiempo = (Button) findViewById(R.id.btn_MenosTiempo);
        btn_IniciarContador = (Button) findViewById(R.id.btn_TimerComienza);
        txtV_LlevasXCafes = (TextView) findViewById(R.id.txtV_ContadorCafes);
        txtV_MarcadorTiempo = (TextView) findViewById(R.id.txtV_MarcadorTiempo);

        // Inicializando cafeteador y contador de tiempo
        cafeteador = new CuantosCafes();
        actualizarMarcadorMinutos();
    }

    public void manageOnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_MasTiempo:
                aumentarMinutos();
                break;
            case R.id.btn_MenosTiempo:
                disminuirMinutos();
                break;
            case R.id.btn_TimerComienza:
                iniciarContador();
                break;
        }
    }

    void iniciarContador() {
        // Desactivando botones, para no modificar el tiempo que lleva corriendo
        btn_IniciarContador.setEnabled(false);
        btn_menosTiempo.setEnabled(false);
        btn_masTiempo.setEnabled(false);

        contadorTiempo = new ContadorTiempo(cafeteador.getMinutos() * 60 * 1000, 1000);
        contadorTiempo.start();
    }

    void aumentarMinutos() {
        if (cafeteador.getMinutos() < 10)
            cafeteador.setMinutos(cafeteador.getMinutos() + 1);

        actualizarMarcadorMinutos();
    }

    void disminuirMinutos() {
        if (cafeteador.getMinutos() > 1)
            cafeteador.setMinutos(cafeteador.getMinutos() - 1);

        actualizarMarcadorMinutos();
    }

    void contadorFinalizado() {
        cafeteador.setCafes(cafeteador.getCafes() + 1);
        cafeteador.setSegundos(0);

        Toast.makeText(this, "Café terminado...", Toast.LENGTH_SHORT).show();
        txtV_LlevasXCafes.setText("Llevas " + cafeteador.getCafes() + " café(s)...");
        sonidoNotificacion();


        if (cafeteador.getCafes() == 10) {
            demasiadosCafes();
        }
        else {
            // Activando botones
            btn_menosTiempo.setEnabled(true);
            btn_masTiempo.setEnabled(true);
            btn_IniciarContador.setEnabled(true);
        }
    }

    void actualizarMarcadorMinutos(){
        txtV_MarcadorTiempo.setText(String.format("%02d", cafeteador.getMinutos()) + " : " + String.format("%02d", cafeteador.getSegundos()));
    }

    void sonidoNotificacion() {

    }

    void demasiadosCafes() {
        AlertDialog.Builder popup = new AlertDialog.Builder(this);
        popup.setTitle("Has tomado 10 cafeses");
        popup.setMessage("Demasiado elixir de los dioses por hoy");
        popup.setPositiveButton("Te odio", null);
        popup.show();
    }


    private class ContadorTiempo extends CountDownTimer {

        public ContadorTiempo(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            actualizarMarcadorMinutos();

            if (cafeteador.getSegundos() == 0) {
                cafeteador.setMinutos(cafeteador.getMinutos() - 1);
                cafeteador.setSegundos(59);
            } else
                cafeteador.setSegundos(cafeteador.getSegundos() - 1);

        }

        @Override
        public void onFinish() {
            contadorFinalizado();
        }
    }

}