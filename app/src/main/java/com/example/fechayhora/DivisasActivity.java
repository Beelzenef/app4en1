package com.example.fechayhora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
        Conversión de monedas
        @author Elena G (Beelzenef)
 */
public class DivisasActivity extends AppCompatActivity {

    // Instancias a usar
    Button btn_ConvertirMoneda;
    EditText edt_aEuros;
    EditText edt_aDolares;
    RadioButton radB_aDolares;
    RadioButton radB_aEuros;

    Conversor miConversor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisa);

        // Identificando controles
        btn_ConvertirMoneda = (Button)findViewById(R.id.btn_Conversion);
        edt_aDolares = (EditText)findViewById(R.id.edT_ADolares);
        edt_aEuros = (EditText)findViewById(R.id.edT_AEuros);
        radB_aDolares = (RadioButton)findViewById(R.id.radB_ADolares);
        radB_aEuros = (RadioButton)findViewById(R.id.radB_AEuros);

        // Creando un conversor de monedas
        miConversor = new Conversor();

    }

    public void manageOnClick(View v)
    {
        if (v == (Button)findViewById(R.id.btn_Conversion))
        {
            // Seleccionando tipo de cambio
            if (radB_aDolares.isChecked())
            {
                if (edt_aEuros.getText().length() != 0 && edt_aEuros.getText().toString() != ".") {
                    edt_aDolares.setText(miConversor.cambioADolares(edt_aEuros.getText().toString()));
                    Toast.makeText(this, "EUR --> USD", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                if (edt_aDolares.getText().length() != 0 && edt_aDolares.getText().toString() != ".") {
                    edt_aEuros.setText(miConversor.cambioAEuros(edt_aDolares.getText().toString()));
                    Toast.makeText(this, "USD --> EUR", Toast.LENGTH_SHORT).show();
                }
            }
        }
        // Mostrando tostadita de notificacion
    }
}
