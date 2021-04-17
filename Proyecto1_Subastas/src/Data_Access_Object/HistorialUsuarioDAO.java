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
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Natalia
 */
public class HistorialUsuarioDAO {
    private ConnectionBD con;

    public HistorialUsuarioDAO() throws SQLException {
         con = ConnectionBD.estate();
    }
     
    public ArrayList<HistorialUsuario> historialVendedor(double idVendedor){
        
       ArrayList<HistorialUsuario> hVendedor = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectHistorialVendedor (?,?)}");
           
             //se definen los parametros de entrada y salida
            cst.setDouble(1, idVendedor);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // result contiene las filas que vienen de la BD
            ResultSet result = ((OracleCallableStatement)cst).getCursor(2);  
            while(result.next()){
                HistorialUsuario hv = new HistorialUsuario();
                hv.setIdVendedor(result.getDouble(1));
                hv.setNombreVendedor(result.getString(2));
                hv.setIdComprador(result.getDouble(3));
                hv.setNombreComprador(result.getString(4));
                hv.setIdSubasta(result.getDouble(5));
                hv.setPrecioBase(result.getDouble(6));
                hv.setPrecioFinal(result.getDouble(7)); 
               hv.setComentario(result.getString(8));
                hv.setCalificacion(result.getInt(9));
                hVendedor.add(hv);
            }
            return hVendedor;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return hVendedor;
        
    }
    
    public ArrayList<HistorialUsuario> historialComprador(double idComprador){
        
       ArrayList<HistorialUsuario> hComprador = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectHistorialComprador (?,?)}");
           
             //se definen los parametros de entrada y salida
            cst.setDouble(1, idComprador);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // result contiene las filas que vienen de la BD
            ResultSet result = ((OracleCallableStatement)cst).getCursor(2);  
            while(result.next()){
                HistorialUsuario hc = new HistorialUsuario();
                hc.setIdComprador(result.getDouble(1));
                hc.setNombreComprador(result.getString(2));
                hc.setIdVendedor(result.getDouble(3));
                hc.setNombreVendedor(result.getString(4));
                hc.setIdSubasta(result.getDouble(5));
                hc.setPrecioBase(result.getDouble(6));
                hc.setPrecioFinal(result.getDouble(7)); 
               // hc.setComentario(result.getString(8));
                hc.setCalificacion(result.getInt(9));
                hComprador.add(hc);
            }
            return hComprador;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return hComprador;
        
    }
 
}
