package com.example.fechayhora.EJ_EnviarMensaje;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fechayhora.R;

import org.w3c.dom.Text;

/**
 * Recibiendo mensaje de otra Activity, ¡saludando al usuario!
 * @author Elena G (Beelzenef)
 */
public class RecibirMensajeActivity extends AppCompatActivity {

    TextView txtV_RecibirSaludo;
    public static final String DATO = "DATO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibir_mensaje);

        // Identificando elementos
        txtV_RecibirSaludo = (TextView) findViewById(R.id.txtV_RecibirSaludo);

        txtV_RecibirSaludo.setText("Bienvenid@ al sistema, " + this.getIntent().getStringExtra(DATO));
    }
}
