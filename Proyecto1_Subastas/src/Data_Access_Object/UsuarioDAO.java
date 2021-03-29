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
        } finally {
            con.closeConnection();
        }
        return null;
        
    }
    
    
     public boolean insertarUsuario(Usuario user){
        /**
         * Funcion: Toma el usuario correspondiente de la BD
         * Entradas: Alias y contrasennia 
         * Salidas: Un objeto usuario
         */
    
        try {
            System.out.println("En el try del dao 1");
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_InsertUser (?,?,?,?,?,?,?)}");
           
             //se definen los parametros de entrada y salida
            cst.setString(1, user.getNombre());
            cst.setDouble(2, user.getCedula());
            cst.setString(3, user.getDireccion());
            cst.setString(4, user.getCorreo());
            
            System.out.println(Integer.valueOf(String.valueOf(user.isAdmin())));
            
            cst.setInt(5, Integer.valueOf(String.valueOf(user.isAdmin())));
            cst.setString(6, user.getAlias());
            cst.setString(7, user.getContrasennia());
            
            // Ejecuta el procedimiento almacenado
            int respuesta = cst.executeUpdate();
            return respuesta==1;  //t si insertó,f si no.

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
             System.out.println("En el cath dao >:c");
        } finally {
            con.closeConnection();
        }
        return false;
        
    }
    
  
}
