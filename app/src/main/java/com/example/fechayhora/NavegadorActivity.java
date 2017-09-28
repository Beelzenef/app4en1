package com.example.fechayhora;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Clase Navegador, para busqueda de URLs
 * @author Elena G (Beelzenef)
 */
public class NavegadorActivity extends AppCompatActivity {

    // Instancias a utilizar
    EditText edT_webAVisitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);

        // Identificando controles
        edT_webAVisitar = (EditText) findViewById(R.id.edT_webAVisitar);
    }

    public void manageOnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_VisitarWeb:
                AbrirWeb(edT_webAVisitar.getText().toString());
                break;
        }
    }

    void AbrirWeb(String url) {

        // Comprobando que hay una URL que buscar
        if (url.length() != 0) {
            Uri direccion = Uri.parse(url);
            Intent unIntento = new Intent(Intent.ACTION_VIEW, direccion);
            if (unIntento.resolveActivity(getPackageManager()) != null) {
                startActivity(unIntento);
            } else {
                Toast.makeText(this, "¿Has escrito la URL?", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
