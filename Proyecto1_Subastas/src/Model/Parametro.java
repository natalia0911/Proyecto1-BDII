/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dell
 */
public class Parametro {
    private String codParameter;
    private double value;

    public Parametro(String codParameter, double value) {
        this.codParameter = codParameter;
        this.value = value;
    }

    public Parametro() {}

    public String getCodParameter() {
        return codParameter;
    }

    public void setCodParameter(String codParameter) {
        this.codParameter = codParameter;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Parametro{" + "codParameter=" + codParameter + ", value=" + value + '}';
    }
    
    
}
