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
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

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
            cst.setDouble(1, puja.getCompradorId());
            cst.setDouble(2, puja.getSubastaId());
            cst.setDouble(3, puja.getPrecio());
            
            // Ejecuta el procedimiento almacenado
            int respuesta = cst.executeUpdate();
            return respuesta==1;  //t si insertó,f si no. 
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());           
        }
        return false;
        
    }
    
    public ArrayList<Puja> listarPujas(double subastaId){
        
        ArrayList<Puja> pujas = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectPujas (?,?)}");
           
             // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.setInt(1, (int) subastaId);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado
            ResultSet result = ((OracleCallableStatement)cst).getCursor(2);  //Tiene las filas que vienen de la BD
         
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
    
    
     public Puja getMejorPuja(double subastaId){
        
        Puja puja = new Puja();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_MejorPuja (?,?)}");
             // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.setDouble(1, subastaId);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado
            ResultSet result = ((OracleCallableStatement)cst).getCursor(2);  
         
            while(result.next()){
                puja.setId(result.getInt(1));
                puja.setPrecio(result.getDouble(2));
            }
            return puja;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return puja;
    }
}
