/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class Puja {
    private double id=-1;
    private double compradorId;
    private String nombreComprador;
    private double subastaId;
    private double precio;
    private Date fecha;

    public Puja() {}

    public Puja(double id, double compradorId,String nombreComprador,double subastaId, double precio, Date fecha) {
        this.id = id;
        this.compradorId = compradorId;
        this.nombreComprador = nombreComprador;
        this.subastaId = subastaId;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Puja(double compradorId,double subastaId, double precio) {
        this.compradorId = compradorId;
        this.subastaId = subastaId;
        this.precio = precio;
    }
    
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(double compradorId) {
        this.compradorId = compradorId;
    }

    public double getSubastaId() {
        return subastaId;
    }

    public void setSubastaId(double subastaId) {
        this.subastaId = subastaId;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    @Override
    public String toString() {
        return "Puja{" + "id=" + id + ", compradorId=" + compradorId + ", nombreComprador=" + nombreComprador + ", subastaId=" + subastaId + ", precio=" + precio + ", fecha=" + fecha + '}';
    }
    

}
