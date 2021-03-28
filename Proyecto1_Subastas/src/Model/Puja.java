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
    private double id;
    private double compradorId;
    private double subastaId;
    private double precio;
    private Date fecha;

    public Puja() {}

    public Puja(double id, double compradorId, double subastaId, double precio, Date fecha) {
        this.id = id;
        this.compradorId = compradorId;
        this.subastaId = subastaId;
        this.precio = precio;
        this.fecha = fecha;
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
    
    
    
    
}
