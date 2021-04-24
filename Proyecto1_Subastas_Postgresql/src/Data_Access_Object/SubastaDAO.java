/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.FormatosUtilitaria;
import Model.Subasta;
import java.awt.Image;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
            cst.setInt(1, auction.getUsuarioId());
            cst.setInt(2, auction.getSubcategoriaId());
            cst.setDouble(3, auction.getPrecioInicial());
            cst.setString(4, auction.getDetallesEntrega());
            cst.setDate(5, new java.sql.Date(auction.getFechaInicio().getTime()));
            cst.setDate(6, new java.sql.Date(auction.getFechaFin().getTime()));
            
            return cst.execute();
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());           
        } finally {
            //con.closeConnection();
        }
        return false;
        
    }
    
    public boolean InsertarImgSubastas(Image img) throws IOException{
    
        /**
         * Funcion: Insertar una imagen a la ultims subasta
         * Entradas: Objeto Icon
         * Salidas: booleano
         */
    
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_INSERTIMAGE (?)}");
             //se definen los parametros de entrada y salida            
            //cst.setBlob(1, );
            cst.setBinaryStream(1, FormatosUtilitaria.convertirImagenABlob(img));
            // Ejecuta el procedimiento almacenado
            return cst.execute(); 
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());           
        } finally {
            //con.closeConnection();
        }
        return false;
        
    }
    
    
    
    
    public ArrayList<Subasta> getSubastas(int idSubCat){
        /**
         * Funcion: Lista las subastas que cierta subcategoria
         * Entradas: Id de la subcategoria
         * Salidas: lista de subastas
         */
        ArrayList<Subasta> subastas = new ArrayList();
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectAuction (?)}");         
             //se definen los parametros de entrada y salida
            cst.setInt(1, idSubCat);
            // result contiene las filas que vienen de la BD
            ResultSet result = cst.executeQuery();
            while(result.next()){
                Subasta subasta = new Subasta();
                subasta.setId(result.getInt(1));
                subasta.setUsuarioId(result.getInt(2));
                subasta.setNombreUsuario(result.getString(3));
                subasta.setSubcategoriaId(result.getInt(4));
                subasta.setNombreSubcat(result.getString(5));
                subasta.setPrecioInicial(result.getDouble(6));
                subasta.setPrecioFinal(result.getDouble(7));
                subasta.setDetallesEntrega(result.getString(8));
                subasta.setFechaInicio(result.getDate(9));
                subasta.setFechaFin(result.getDate(10));
                subastas.add(subasta);
            }
            return subastas;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return subastas;
        
    }
    
    
    public Subasta getSubasta(int id){
        /**
         * Funcion: Lista las subastas que cierta subcategoria
         * Entradas: Id de la subcategoria
         * Salidas: lista de subastas
         */
        Subasta subasta = new Subasta();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectAuctionById (?)}");
             //se definen los parametros de entrada y salida
            cst.setInt(1, id);
            // result contiene las filas que vienen de la BD
            ResultSet result = cst.executeQuery(); 
            while(result.next()){
                subasta.setId(result.getInt(1));
                subasta.setUsuarioId(result.getInt(2));
                subasta.setSubcategoriaId(result.getInt(3));
                subasta.setPrecioInicial(result.getDouble(4));
            }
            return subasta;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return subasta;
        
    }
    
     
}
