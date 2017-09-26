package com.example.fechayhora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

/**
 *  Obteniendo fecha y hora
 *  @author Elena G (Beelzenef)
 */
public class MostrarFechaHora extends AppCompatActivity implements View.OnClickListener {

    // Controles a modificar
    TextView txtV_fechaYHora;
    Button btn_NuevaFechaYHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_fechahora);

        // Obteniendo controles para modificar / identificar
        txtV_fechaYHora = (TextView)findViewById(R.id.txtV_FechaHora);
        btn_NuevaFechaYHora = (Button)findViewById(R.id.btn_ObtenerFechaHora);

        // Actualizando reloj desde el inicio
        actualizarFechaHora();

        // Suscripcion al evento onClick
        btn_NuevaFechaYHora.setOnClickListener(this);
    }

    // Implementando click de botón
    @Override
    public void onClick(View v) {
        // Si quien lo ha llamado es el botón creado, actualizamos el textView
        if (v == btn_NuevaFechaYHora)
            actualizarFechaHora();
    }

    // Actualizando textView
    void actualizarFechaHora()
    {
        txtV_fechaYHora.setText(new Date().toString());
    }
}
