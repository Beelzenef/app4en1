package com.example.fechayhora.EJ_Cafeses;

/**
 * Created by usuario on 3/10/17.
 */

public final class CuantosCafes {

    private int cafes;
    private int minutos;
    private int segundos;

    public int getCafes() {
        return cafes;
    }

    public void setCafes(int cafes) {
        this.cafes = cafes;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {return segundos;}

    public void setSegundos(int segundos) { this.segundos = segundos; }

    public CuantosCafes()
    {
        cafes = 0;
        minutos = 5;
        segundos = 0;
    }


}
