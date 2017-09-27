package com.example.fechayhora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
        Conversión de monedas
        @author Elena G (Beelzenef)
 */
public class Divisas extends AppCompatActivity {

    // Instancias a usar
    Button btn_ConvertirMoneda;
    EditText edt_aEuros;
    EditText edt_aDolares;
    RadioButton radB_aDolares;
    RadioButton radB_aEuros;

    private double cambioMoneda = 0.85;

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

    }

    public void manageOnClick(View v)
    {
        if (v == (Button)findViewById(R.id.btn_Conversion))
        {
            // Seleccionando tipo de cambio
            if (radB_aDolares.isChecked())
            {
                cambioADolares();
            }
            if (radB_aEuros.isChecked())
            {
                cambioAEuros();
            }
        }
    }

    void cambioAEuros()
    {
        double valorCambiado;

        if (edt_aDolares.getText().length() != 0) {
            valorCambiado = Double.parseDouble(edt_aDolares.getText().toString()) * cambioMoneda;
            edt_aEuros.setText(Double.toString(valorCambiado)) ;
        }
    }

    void cambioADolares()
    {
        double valorCambiado;

        if (edt_aEuros.getText().length() != 0) {
            valorCambiado = Double.parseDouble(edt_aEuros.getText().toString()) / cambioMoneda;
            edt_aDolares.setText(Double.toString(valorCambiado)) ;
        }
    }
}
