/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import java.sql.SQLException;

/**
 *
 * @author Natalia
 */
public class HistorialUsuarioDAO {
    private ConnectionBD con;

    public HistorialUsuarioDAO() throws SQLException {
         con = ConnectionBD.estate();
    }
     
    //public ArrayList<HistorialUsuario> getSubastas(double idVendedor){}
    
    //public ArrayList<HistorialUsuario> getSubastas(double idComprador){}
    
}
