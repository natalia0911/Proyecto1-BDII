/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Natalia
 */
public class Parametros_Singleton {
    
    private static Parametros_Singleton parametros;
    private static Parametro porcentaje;
    private static Parametro montoMinimo;

    public Parametros_Singleton() {}
    
    public static synchronized Parametros_Singleton Parametros(){

        if (parametros == null){
            parametros = new Parametros_Singleton();
        }
        return parametros;
    }

    public static Parametro getPorcentaje() {
        return porcentaje;
    }

    public static void setPorcentaje(Parametro porcentaje) {
        Parametros_Singleton.porcentaje = porcentaje;
    }

    public static Parametro getMontoMinimo() {
        return montoMinimo;
    }

    public static void setMontoMinimo(Parametro montoMinimo) {
        Parametros_Singleton.montoMinimo = montoMinimo;
    }


    
}

