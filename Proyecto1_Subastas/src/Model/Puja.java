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
    private int id=-1;
    private int compradorId;
    private String nombreComprador;
    private int subastaId;
    private double precio;
    private Date fecha;

    public Puja() {}

    public Puja(int id, int compradorId,String nombreComprador,int subastaId, double precio, Date fecha) {
        this.id = id;
        this.compradorId = compradorId;
        this.nombreComprador = nombreComprador;
        this.subastaId = subastaId;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Puja(int compradorId,int subastaId, double precio) {
        this.compradorId = compradorId;
        this.subastaId = subastaId;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(int compradorId) {
        this.compradorId = compradorId;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public int getSubastaId() {
        return subastaId;
    }

    public void setSubastaId(int subastaId) {
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
    
    @Override
    public String toString() {
        return "Puja{" + "id=" + id + ", compradorId=" + compradorId + ", nombreComprador=" + nombreComprador + ", subastaId=" + subastaId + ", precio=" + precio + ", fecha=" + fecha + '}';
    }
    

}
