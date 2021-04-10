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
    private double idVendedor;
    private double idSubasta;
    private int calificacion;
    private String comentario;

    public HistorialUsuario() {}
    
    public HistorialUsuario(double idComprador, double idVendedor, double idSubasta, int calificacion, String comentario) {
        this.idComprador = idComprador;
        this.idVendedor = idVendedor;
        this.idSubasta = idSubasta;
        this.calificacion = calificacion;
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

    @Override
    public String toString() {
        return "HistorialUsuario{" + "idComprador=" + idComprador + ", idVendedor=" + idVendedor + ", idSubasta=" + idSubasta + ", calificacion=" + calificacion + ", cpmentario=" + comentario + '}';
    }

    
}
