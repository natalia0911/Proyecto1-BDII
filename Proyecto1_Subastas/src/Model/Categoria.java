/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Array;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Categoria {
    private double id;
    private String nombreCategoria;
    private ArrayList<SubCategoria> subcategorias;

    public Categoria() {}

    public Categoria(double id, String nombreCategoria, ArrayList<SubCategoria> subcategorias) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
        this.subcategorias = subcategorias;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public ArrayList<SubCategoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(ArrayList<SubCategoria> subcategorias) {
        this.subcategorias = subcategorias;
    }

    @Override
    public String toString() {
        return this.nombreCategoria;
    }
   
    
}
