package com.example.fechayhora.EJ_Divisas;

/**
 * Clase Conversor de cambio de divisas (EUR/USD), creada en 28/09/17.
 * @author Elena G (Beelzenef)
 */

public final class Conversor {

    // Variables
    private double cambioMoneda;

    // Constructores

    public Conversor()
    {
        this.cambioMoneda = 0.84;
    }

    public Conversor(double cM)
    {
        this.cambioMoneda = cM;
    }

    // Métodos

    public String cambioADolares(String valor)
    {
            return Double.toString(Double.parseDouble(valor) / cambioMoneda);
    }

    public String cambioAEuros(String valor)
    {
        return Double.toString(Double.parseDouble(valor) * cambioMoneda);
    }

}
