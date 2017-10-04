package com.example.fechayhora.EJ_AdivinarNumero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fechayhora.R;

import java.util.Random;

public class AdivinarNumeroActivity extends AppCompatActivity {

    // Instancias a utilizar
    private EditText edT_nuevoPrueba;
    private TextView txtV_Pistas;
    private Button btn_NumeroSuperior;
    private Button btn_NumeroInferior;
    private Button btn_GenerarNumero;
    private Button btn_ProbarNumero;

    private Random dado;

    private int numeroGenerado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivinar_numero);

        // Identificando vistas
        edT_nuevoPrueba = (EditText) findViewById(R.id.edT_NumeroAProbar);
        txtV_Pistas = (TextView) findViewById(R.id.txtV_Pistas);
        btn_NumeroInferior = (Button) findViewById(R.id.btn_NumeroInferior);
        btn_NumeroSuperior = (Button) findViewById(R.id.btn_NumeroSuperior);
        btn_GenerarNumero = (Button) findViewById(R.id.btn_GenerarNuevoNumero);
        btn_ProbarNumero = (Button) findViewById(R.id.btn_ProbarNumero);

        // Inicializando
        numeroGenerado = 0;
        dado = new Random();

    }

    public void manageOnClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_NumeroInferior:
                disminuirNum(Integer.parseInt(edT_nuevoPrueba.getText().toString()));
                break;
            case R.id.btn_NumeroSuperior:
                aumentarNum(Integer.parseInt(edT_nuevoPrueba.getText().toString()));
                break;
            case R.id.btn_GenerarNuevoNumero:
                generarNuevoNumero();
                btn_GenerarNumero.setEnabled(false);
                break;
            case R.id.btn_ProbarNumero:
                comprobarNumero(Integer.parseInt(edT_nuevoPrueba.getText().toString()));
                break;
        }
    }

    private void aumentarNum(int num)
    {
        num++;
        edT_nuevoPrueba.setText(Integer.toString(num));
    }

    private void disminuirNum(int num)
    {
        num--;
        edT_nuevoPrueba.setText(Integer.toString(num));
    }

    private void comprobarNumero(int probandoNum)
    {
        if (probandoNum == numeroGenerado)
        {
            txtV_Pistas.setText("¡Has acertado!");
            deshabilitarBotones();
            btn_GenerarNumero.setEnabled(true);
        }
        if (probandoNum > numeroGenerado)
        {
            txtV_Pistas.setText("¡El número secreto es menor!");
        }
        if (probandoNum < numeroGenerado)
        {
            txtV_Pistas.setText("El número secreto es mayor!");
        }
    }

    private void generarNuevoNumero()
    {
        numeroGenerado = dado.nextInt(21);
        habilitarBotones();
        txtV_Pistas.setText("¡Nuevo número generado!");
    }

    private void habilitarBotones()
    {
        btn_NumeroSuperior.setEnabled(true);
        btn_NumeroInferior.setEnabled(true);
        btn_ProbarNumero.setEnabled(true);
    }

    private void deshabilitarBotones()
    {
        btn_NumeroSuperior.setEnabled(false);
        btn_NumeroInferior.setEnabled(false);
        btn_ProbarNumero.setEnabled(false);
    }
}
