/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.Puja;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class PujaDAO {
    private ConnectionBD con;

    public PujaDAO() throws SQLException {
        con = ConnectionBD.estate();
    }
    
    
        public boolean insertarPuja(Puja puja){
    
        /**
         * Funcion: Inserta una puja a la BD
         * Entradas: Objeto subasta
         * Salidas: booleano
         */
    
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_InsertPuja (?,?,?)}");
            
             //se definen los parametros de entrada y salida            
            cst.setInt(1, puja.getCompradorId());
            cst.setInt(2, puja.getSubastaId());
            cst.setDouble(3, puja.getPrecio());
            
            // Ejecuta el procedimiento almacenado
            return cst.execute();
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());           
        }
        return false;
        
    }
    
    public ArrayList<Puja> listarPujas(int subastaId){
        
        ArrayList<Puja> pujas = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectPujas (?)}");
             // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.setInt(1, subastaId);
            ResultSet result = cst.executeQuery();
            while(result.next()){
                Puja puja = new Puja();
                puja.setId(result.getInt(1));
                puja.setCompradorId(result.getInt(2));
                puja.setNombreComprador(result.getString(3));
                puja.setSubastaId(result.getInt(4));
                puja.setPrecio(result.getDouble(5));
                puja.setFecha(result.getDate(6));
                pujas.add(puja);
            }
            return pujas;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return pujas;
    }
    
    
}
