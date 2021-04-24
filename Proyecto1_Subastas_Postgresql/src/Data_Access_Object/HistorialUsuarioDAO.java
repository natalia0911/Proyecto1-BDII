/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.HistorialUsuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Natalia
 */
public class HistorialUsuarioDAO {
    private ConnectionBD con;

    public HistorialUsuarioDAO() throws SQLException {
         con = ConnectionBD.estate();
    }
     
    public ArrayList<HistorialUsuario> historialVendedor(int idVendedor){
        
       ArrayList<HistorialUsuario> hVendedor = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectHistorialVendedor(?)}");
           
             //se definen los parametros de entrada y salida
            cst.setInt(1, idVendedor);
            ResultSet result = cst.executeQuery();
            while(result.next()){
                HistorialUsuario hv = new HistorialUsuario();
                hv.setIdVendedor(result.getInt(1));
                hv.setNombreVendedor(result.getString(2));
                hv.setIdComprador(result.getInt(3));
                hv.setNombreComprador(result.getString(4));
                hv.setIdSubasta(result.getInt(5));
                hv.setPrecioBase(result.getDouble(6));
                hv.setPrecioFinal(result.getDouble(7)); 
                hv.setComentario(result.getString(8));
                hv.setCalificacion(result.getInt(9));
                hv.setFecha(result.getDate(10));
                hv.setTipo("Vendedor");
                hVendedor.add(hv);
            }
            return hVendedor;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return hVendedor;
        
    }
    
    public ArrayList<HistorialUsuario> mihistorialVendedor(int idVendedor){
        
       ArrayList<HistorialUsuario> hVendedor = new ArrayList();
        try {
         
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectMiHistoVend(?)}");
           
             //se definen los parametros de entrada y salida
            cst.setInt(1, idVendedor);
            ResultSet result = cst.executeQuery();
            while(result.next()){
                HistorialUsuario hv = new HistorialUsuario();
                hv.setIdVendedor(result.getInt(1));
                hv.setNombreVendedor(result.getString(2));
                hv.setIdComprador(result.getInt(3));
                hv.setNombreComprador(result.getString(4));
                hv.setIdSubasta(result.getInt(5));
                hv.setPrecioBase(result.getDouble(6));
                hv.setPrecioFinal(result.getDouble(7)); 
                hv.setComentario(result.getString(8));
                hv.setCalificacion(result.getInt(9));
                hv.setFecha(result.getDate(10));
                hv.setTipo("Vendedor");
                hVendedor.add(hv);
            }

            return hVendedor;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return hVendedor;
        
    }
    
    
    public ArrayList<HistorialUsuario> historialComprador(int idComprador){
        
       ArrayList<HistorialUsuario> hComprador = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectHistorialComprador (?)}");
           
             //se definen los parametros de entrada y salida
            cst.setInt(1, idComprador);
            ResultSet result = cst.executeQuery();
            while(result.next()){
                HistorialUsuario hc = new HistorialUsuario();
                hc.setIdComprador(result.getInt(1));
                hc.setNombreComprador(result.getString(2));
                hc.setIdVendedor(result.getInt(3));
                hc.setNombreVendedor(result.getString(4));
                hc.setIdSubasta(result.getInt(5));
                hc.setPrecioBase(result.getDouble(6));
                hc.setPrecioFinal(result.getDouble(7)); 
                hc.setComentario(result.getString(8));
                hc.setCalificacion(result.getInt(9));
                hc.setFecha(result.getDate(10));
                hc.setTipo("comprador");
                hComprador.add(hc);
            }
            return hComprador;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return hComprador;
        
    }
    
    public ArrayList<HistorialUsuario> mihistorialComprador(int idComprador){
        
       ArrayList<HistorialUsuario> hComprador = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectMiHistoComp (?)}");
           
             //se definen los parametros de entrada y salida
            cst.setInt(1, idComprador);
            ResultSet result = cst.executeQuery();
            while(result.next()){
                HistorialUsuario hc = new HistorialUsuario();
                hc.setIdComprador(result.getInt(1));
                hc.setNombreComprador(result.getString(2));
                hc.setIdVendedor(result.getInt(3));
                hc.setNombreVendedor(result.getString(4));
                hc.setIdSubasta(result.getInt(5));
                hc.setPrecioBase(result.getDouble(6));
                hc.setPrecioFinal(result.getDouble(7)); 
                hc.setComentario(result.getString(8));
                hc.setCalificacion(result.getInt(9));
                hc.setFecha(result.getDate(10));
                hc.setTipo("comprador");
                hComprador.add(hc);
            }
            return hComprador;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return hComprador;
        
    }
    
    
    public void UpdateComentarioVendedor(int idVendedor, int idComprador, int idSubasta, String Comentario, int Rating) throws SQLException{
    
    try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_UpdateHistorialVendedor (?,?,?,?,?)}");
           
             //se definen los parametros de entrada y salida
            cst.setInt(1, idVendedor);
            cst.setInt(2, idComprador);
            cst.setInt(3, idSubasta);
            cst.setString(4, Comentario);
            cst.setDouble(5, Rating);
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
    
        }catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
    }
    
    public void UpdateComentarioComprador(int idVendedor, int idComprador, int idSubasta, String Comentario, int Rating) throws SQLException{
    
    try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_UpdateHistorialComprador (?,?,?,?,?)}");
           
             //se definen los parametros de entrada y salida
            cst.setInt(1, idVendedor);
            cst.setInt(2, idComprador);
            cst.setInt(3, idSubasta);
            cst.setString(4, Comentario);
            cst.setInt(5, Rating);
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
            //return cst.execute();//t si insertó,f si no.  
    
        }catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
    }
    
 
}
