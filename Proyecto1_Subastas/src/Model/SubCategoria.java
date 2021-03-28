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
public class SubCategoria {
    
    private double id;
    private String nombreSubCat;

    public SubCategoria() {
    }

    public SubCategoria(double id, String nombreSubCat) {
        this.id = id;
        this.nombreSubCat = nombreSubCat;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getNombreSubCat() {
        return nombreSubCat;
    }

    public void setNombreSubCat(String nombreSubCat) {
        this.nombreSubCat = nombreSubCat;
    }
    
}
