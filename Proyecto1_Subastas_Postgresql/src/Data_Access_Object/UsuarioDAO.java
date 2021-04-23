/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;
;

import Model.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Natalia
 */
public class UsuarioDAO {
    private ConnectionBD con;

    public UsuarioDAO() throws SQLException {
        con = ConnectionBD.estate();
    }
    
    public void close(){
        con.closeConnection();
    }
    
    public Usuario getUsuario(String alias,String contrasennia){
        /**
         * Funcion: Toma el usuario correspondiente de la BD
         * Entradas: Alias y contrasennia 
         * Salidas: Un objeto usuario
         */
    
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectUsers (?,?)}");
            cst.setString(1, alias);
            cst.setString(2, contrasennia);
    
            ResultSet result = cst.executeQuery();
            Usuario user = new Usuario();
            while(result.next()){
                user.setId(result.getInt(1));
                user.setNombre(result.getString(2));
                user.setCedula(result.getInt(3));
                user.setDireccion(result.getString(4));
                user.setCorreo(result.getString(5));
                user.setEsAdmin(result.getBoolean(6));
                user.setAlias(result.getString(7));
                user.setContrasennia(result.getString(8));

            }
            return user;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
        
    }
    
    public ArrayList<Usuario> getAllUsers(){
        /**
         * Funcion: Lista los usuarios existentes
         * Entradas: Ninguna
         * Salidas: Una lista de usuarios
         */
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectAllUsers ()}");
            // result contiene las filas que vienen de la BD
             ResultSet result = cst.executeQuery();
            while(result.next()){
                Usuario user = new Usuario();
                user.setId(result.getInt(1));
                user.setNombre(result.getString(2));
                user.setCedula(result.getInt(3));
                user.setDireccion(result.getString(4));
                user.setCorreo(result.getString(5));
                user.setEsAdmin(result.getBoolean(6));
                user.setAlias(result.getString(7));
                user.setContrasennia(result.getString(8));
                usuarios.add(user);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
           // con.closeConnection();
        }
        return usuarios;
        
    }
    
    public boolean insertarUsuario(Usuario user){
        /**
         * Funcion: Inserta un usuario en la BD
         * Entradas: Objeto usuario
         * Salidas: booleano
         */
    
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_InsertUser (?,?,?,?,?,?,?)}");
           
             //se definen los parametros de entrada y salida            
            cst.setString(1, user.getNombre());
            cst.setInt(2, user.getCedula());
            cst.setString(3, user.getDireccion());
            cst.setString(4, user.getCorreo());
            cst.setBoolean(5,user.isAdmin());
            cst.setString(6, user.getAlias());
            cst.setString(7, user.getContrasennia());
            // Ejecuta el procedimiento almacenado
            return cst.execute();
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());           
        } finally {
            //con.closeConnection();
        }
        return false;
        
    }
    
  
    public boolean modificarUsuario(Usuario user){
        /**
         * Funcion: Modificar un usuario en la BD
         * Entradas: Objeto usuario
         * Salidas: booleano
         */
    
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_UpdateUser (?,?,?,?,?,?)}");
           
             //se definen los parametros de entrada 
            cst.setString(1, user.getNombre());
            cst.setInt(2, user.getCedula());
            cst.setString(3, user.getDireccion());
            cst.setString(4, user.getCorreo());
            cst.setString(5, user.getAlias());
            cst.setString(6, user.getContrasennia());
            
            // Ejecuta el procedimiento almacenado
            return cst.execute();//t si insertó,f si no. 
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            //con.closeConnection();
        }
        return false;
        
    }
    
}
