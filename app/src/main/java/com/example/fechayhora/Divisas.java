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
public class Divisas extends AppCompatActivity implements View.OnClickListener {

    // Instancias a usar
    Button btn_ConvertirMoneda;
    EditText edt_aEuros;
    EditText edt_aDolares;
    RadioButton radB_aDolares;
    RadioButton radB_aEuros;

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

        // Suscripcion al evento onClick
        btn_ConvertirMoneda.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btn_ConvertirMoneda)
            actualizarMonedas();
    }

    void actualizarMonedas()
    {
        edt_aDolares.setText("0");
        edt_aEuros.setText("0");
    }
}
