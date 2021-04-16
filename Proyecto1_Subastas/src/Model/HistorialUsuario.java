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
public class HistorialUsuario {
    private double idComprador;
    private String nombreComprador;
    private double idVendedor;
    private String nombreVendedor;
    private double idSubasta;
    private double precioBase;
    private double precioFinal;
    private int calificacion;
    private String comentario;
    

    public HistorialUsuario() {}

    public HistorialUsuario(double idComprador, String nombreComprador, double idVendedor, String nombreVendedor, double idSubasta, double precioBase, double precioFinal, String comentario) {
        this.idComprador = idComprador;
        this.nombreComprador = nombreComprador;
        this.idVendedor = idVendedor;
        this.nombreVendedor = nombreVendedor;
        this.idSubasta = idSubasta;
        this.precioBase = precioBase;
        this.precioFinal = precioFinal;
        this.comentario = comentario;
    }


    public double getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(double idComprador) {
        this.idComprador = idComprador;
    }

    public double getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(double idVendedor) {
        this.idVendedor = idVendedor;
    }

    public double getIdSubasta() {
        return idSubasta;
    }

    public void setIdSubasta(double idSubasta) {
        this.idSubasta = idSubasta;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    
    @Override
    public String toString() {
        return "HistorialUsuario{" + "idComprador=" + idComprador + ", idVendedor=" + idVendedor + ", idSubasta=" + idSubasta + ", calificacion=" + calificacion + ", cpmentario=" + comentario + '}';
    }

    
}
