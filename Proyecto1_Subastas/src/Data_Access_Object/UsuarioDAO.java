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
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;


/**
 *
 * @author Natalia
 */
public class UsuarioDAO {
    private ConnectionBD con;

    public UsuarioDAO() throws SQLException {
        con = ConnectionBD.estate();
    }
    
    public Usuario getUsuario(String alias,String contrasennia){
        /**
         * Funcion: Toma el usuario correspondiente de la BD
         * Entradas: Alias y contrasennia 
         * Salidas: Un objeto usuario
         */
        Usuario user = new Usuario();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectUsers (?,?,?)}");
           
             //se definen los parametros de entrada y salida
            cst.setString(1, alias);
            cst.setString(2, contrasennia);
            cst.registerOutParameter(3, OracleTypes.CURSOR);
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado
            // result contiene las filas que vienen de la BD
            ResultSet result = ((OracleCallableStatement)cst).getCursor(3);  
            while(result.next()){
                user.setId(Integer.parseInt(result.getString(1)));
                user.setNombre(result.getString(2));
                user.setCedula(Integer.parseInt(result.getString(3)));
                user.setDireccion(result.getString(4));
                user.setCorreo(result.getString(5));
                user.setEsAdmin(Boolean.valueOf(result.getString(6)));
                user.setAlias(result.getString(7));
                user.setContraseña(result.getString(8));

            }
            return user;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            con.closeConnection();
        }
        return user;
        
    }
    
  
}
