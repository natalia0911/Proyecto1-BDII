/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;



/**
 *
 * @author Natalia
 */
public class Subasta {
    private double id;
    private double usuarioId;
    private double subcategoriaId;
    private String foto;
    private double precioInicial;
    private double precioFinal;
    private String detallesEntrega;
    private Date fechaInicio;
    private Date fechaFin;
    
    public Subasta() {}
    
    public Subasta(double id, double usuarioId, double subcategoriaId, String foto, double precioInicial, double precioFinal, String detallesEntrega, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.subcategoriaId = subcategoriaId;
        this.foto = foto;
        this.precioInicial = precioInicial;
        this.precioFinal = precioFinal;
        this.detallesEntrega = detallesEntrega;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(double usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getSubcategoriaId() {
        return subcategoriaId;
    }

    public void setSubcategoriaId(double subcategoriaId) {
        this.subcategoriaId = subcategoriaId;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(double precioInicial) {
        this.precioInicial = precioInicial;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getDetallesEntrega() {
        return detallesEntrega;
    }

    public void setDetallesEntrega(String detallesEntrega) {
        this.detallesEntrega = detallesEntrega;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    
}
