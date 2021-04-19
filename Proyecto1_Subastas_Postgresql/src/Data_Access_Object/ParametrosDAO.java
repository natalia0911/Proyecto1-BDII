/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.Parametro;
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
public class ParametrosDAO {
    
    private ConnectionBD con;

    public ParametrosDAO() throws SQLException {
        con = ConnectionBD.estate();
    }
    
    public void close(){
        con.closeConnection();
    }
    
     public ArrayList<Parametro> getParametros(){
        /**
         * Funcion: Listar los parametros
         * Entradas: Ninguna 
         * Salidas: lista de objetos categoria
         */
        ArrayList<Parametro> parameters = new ArrayList();
        try {
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectParameters (?)}");
             //se definen los parametros de entrada y salida
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            
            ResultSet result = ((OracleCallableStatement)cst).getCursor(1);  
            while(result.next()){
                Parametro parameter = new Parametro();
                parameter.setCodParameter(result.getString(1));
                parameter.setValue(result.getDouble(2));
                parameters.add(parameter);
            }
            return parameters;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
           // con.closeConnection();
        }
        return parameters;
        
    }
      
     
    public boolean modificarParametro(Parametro parametro){
        /**
         * Funcion: Modificar parametro
         * Entradas: Objeto parametro
         * Salidas: booleano
         */
    
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_UpdateParameters (?,?)}");
             //se definen los parametros de entrada y salida
            cst.setString(1, parametro.getCodParameter());
            cst.setDouble(2, parametro.getValue());

            int respuesta = cst.executeUpdate();
            return respuesta==1;  //t si insertó,f si no. 
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return false;
        
    }
}
