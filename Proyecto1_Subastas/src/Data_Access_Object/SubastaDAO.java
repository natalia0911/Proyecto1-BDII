/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.Subasta;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Icon;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Natalia
 */
public class SubastaDAO {
     private ConnectionBD con;

    public SubastaDAO() throws SQLException {
         con = ConnectionBD.estate();
    }
    
        
    public boolean InsertarSubastas(Subasta auction){
    
        /**
         * Funcion: Inserta una subasta a la BD
         * Entradas: Objeto subasta
         * Salidas: booleano
         */
    
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_InsertAuction (?,?,?,?,?,?)}");
            
            java.sql.Date sqlStartDate = new java.sql.Date(auction.getFechaInicio().getTime());
            System.out.println(sqlStartDate);
             //se definen los parametros de entrada y salida            
            cst.setDouble(1, auction.getUsuarioId());
            cst.setDouble(2, auction.getSubcategoriaId());
            cst.setDouble(3, auction.getPrecioInicial());
            cst.setString(4, auction.getDetallesEntrega());
            cst.setDate(5, new java.sql.Date(auction.getFechaInicio().getTime()));
            cst.setDate(6, new java.sql.Date(auction.getFechaFin().getTime()));
            
            // Ejecuta el procedimiento almacenado
            int respuesta = cst.executeUpdate();
            return respuesta==1;  //t si insertó,f si no. 
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());           
        } finally {
            //con.closeConnection();
        }
        return false;
        
    }
    
    public boolean InsertarImgSubastas(Icon img){
    
        /**
         * Funcion: Insertar una imagen a la ultims subasta
         * Entradas: Objeto Icon
         * Salidas: booleano
         */
    
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_INSERTIMAGE (?)}");
             //se definen los parametros de entrada y salida            
            cst.setBlob(1, (Blob) img);
            // Ejecuta el procedimiento almacenado
            int respuesta = cst.executeUpdate();
            return respuesta==1;  //t si insertó,f si no. 
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());           
        } finally {
            //con.closeConnection();
        }
        return false;
        
    }
    
    
    
    public ArrayList<Subasta> getSubastas(double idSubCat){
        /**
         * Funcion: Lista las subastas que cierta subcategoria
         * Entradas: Id de la subcategoria
         * Salidas: lista de subastas
         */
        ArrayList<Subasta> subastas = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectAuction (?,?)}");
           
             //se definen los parametros de entrada y salida
            cst.setDouble(1, idSubCat);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado
            // result contiene las filas que vienen de la BD
            ResultSet result = ((OracleCallableStatement)cst).getCursor(2);  
            while(result.next()){
                Subasta subasta = new Subasta();
                subasta.setId(result.getInt(1));
                subasta.setUsuarioId(result.getDouble(2));
                subasta.setSubcategoriaId(result.getInt(3));
                subasta.setPrecioInicial(result.getDouble(4));
                subasta.setPrecioFinal(result.getDouble(5));
                subasta.setDetallesEntrega(result.getString(6));
                subasta.setFechaInicio(result.getDate(7));
                subasta.setFechaFin(result.getDate(8));
                subastas.add(subasta);
            }
            return subastas;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
           // con.closeConnection();
        }
        return subastas;
        
    }
    
     
}
