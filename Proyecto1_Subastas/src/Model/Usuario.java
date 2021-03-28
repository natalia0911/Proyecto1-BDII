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
public class Usuario {
    private double id;
    private int cedula;
    private String nombre;
    private String direccion;
    private boolean esAdmin;
    private String alias;
    private String contraseña;
    private String correo;
    
    public Usuario() {}

    public Usuario(double id, int cedula, String nombre, String direccion, boolean esAdmin, String alias, String contraseña, String correo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.esAdmin = esAdmin;
        this.alias = alias;
        this.contraseña = contraseña;
        this.correo = correo;
    }


    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    
    
    
}
