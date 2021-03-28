/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data_Access_Object.UsuarioDAO;
import Model.Usuario;
import Model.Usuario_Singleton;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class UsuarioController {
    private UsuarioDAO usuarioDao;
   

    public UsuarioController() throws SQLException {
        usuarioDao = new UsuarioDAO();
    }
    
    public void validarUsuario(String alias,String contrasennia){
        Usuario user = usuarioDao.getUsuario(alias, contrasennia);
        if(user!=null){
            System.out.println("Todo bien");
            Usuario_Singleton.UsuarioSingleton().setUsuario(user);  //Se hace el usuario global
        }
        else{
            System.out.println("Objetoi usuario llegó nulo");
            
        }
        
        
    
    }
    
}
