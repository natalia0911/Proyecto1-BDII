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
                puja.setId(result.getDouble(1));
                puja.setCompradorId(result.getDouble(2));
                puja.setSubastaId(result.getDouble(3));
                puja.setPrecio(result.getDouble(4));
                puja.setFecha(result.getDate(5));
                pujas.add(puja);
            }
            return pujas;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            //con.closeConnection();
        }
        return pujas;
    }
}
