/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;


import java.sql.CallableStatement;
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
       
        objConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Natalia", "Hola1234"); //CONECTA LA BASE
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); //CARGA EL DRIVER DE ORACLE
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
  
