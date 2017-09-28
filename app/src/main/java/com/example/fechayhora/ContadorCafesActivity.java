package com.example.fechayhora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Clase para Contador de cafes
 * @author Elena G (Beelzenef)
 */
public class ContadorCafesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_cafes);
    }

    public void manageOnClick(View v)
    {
        switch (v.getId()) {
            case R.id.btn_MasTiempo:
                break;
            case R.id.btn_MenosTiempo:
                break;
        }
    }
}
