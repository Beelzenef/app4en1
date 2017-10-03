package com.example.fechayhora.EJ_EnviarMensaje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fechayhora.R;

/**
 * Enviando mensaje a otra Activity
 * @author Elena G (Beelzenef)
 */
public class EnviarMensajeActivity extends AppCompatActivity {

    // Instancias a usar
    Button btn_EnviarMensaje;
    EditText edT_NombreUsuario;

    public static final String DATO = "DATO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mensaje);

        // Identificando vistas
        btn_EnviarMensaje = (Button) findViewById(R.id.btn_EnviarMensaje);
        edT_NombreUsuario = (EditText) findViewById(R.id.edt_NombreUsuario);
    }

    public void enviarSaludo(View v)
    {
        switch (v.getId()){
            case R.id.btn_EnviarMensaje:
                enviarSaludo(edT_NombreUsuario.getText().toString());
                break;
        }
    }

    void enviarSaludo(String saludito)
    {
        Intent unIntent = new Intent(EnviarMensajeActivity.this, RecibirMensajeActivity.class);
        unIntent.putExtra(DATO, saludito);

        startActivity(unIntent);
    }
}
