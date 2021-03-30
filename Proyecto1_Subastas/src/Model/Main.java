/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Data_Access_Object.PujaDAO;
import Data_Access_Object.UsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        UsuarioDAO connectionUser = new UsuarioDAO();
       // connectionUser.modificarUsuario(new Usuario(12363,"Vane","Pital SC",true,"nat","nat","nat"));
        
        //PujaDAO connectionPuja = new PujaDAO();
        //connectionPuja.listarPujas(2);\
        
      //  Usuario_Singleton user = Usuario_Singleton.UsuarioSingleton().setUsuario(usuario);
               
        

        
  
    }
    
}
