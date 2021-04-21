/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Natalia
 */
public class ConnectionBD {
    
    /**
     * Patrón singleton, para establecer una única conexión en la ejecución
     */
    private static ConnectionBD con  = null;
    private Connection objConnection;
   
    
    public ConnectionBD() throws SQLException{
        objConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Casa_Subastas",  "postgres", "hola123");
        System.out.println("Conexion exitosa");
    }
    
    
    public static ConnectionBD estate() throws SQLException
    {
        if (con == null)
        {
            con =  new ConnectionBD();
        }
        return con;
    }

    public Connection getConnection()
    {
        return objConnection;
    }
    
    public void closeConnection()
    {
       objConnection = null;
    }

   
    
    
}
  
