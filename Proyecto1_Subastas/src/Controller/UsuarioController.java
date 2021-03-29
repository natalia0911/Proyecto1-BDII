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
    
    public boolean validarUsuario(String alias,String contrasennia){
        Usuario user = usuarioDao.getUsuario(alias, contrasennia);
        if(user.getAlias()!=null){
            Usuario_Singleton.UsuarioSingleton().setUsuario(user);  //Se hace el usuario global
            System.out.println(user.isAdmin());
            return true;
        }
        else{
            //Objetoi usuario llegó nulo;
            return false; 
        }
        
    }
    public boolean getTipoUsuario(){
        System.out.println("-----Direccion: "+Usuario_Singleton.UsuarioSingleton().getUsuario().getDireccion());
        return Usuario_Singleton.UsuarioSingleton().getUsuario().isAdmin();
    }
    
    public boolean insertarUsuario(String nombre, int cedula, String direccion,String correo, boolean esAdmin, String alias,String contrasennia){
        Usuario user = new Usuario(cedula,nombre,direccion,esAdmin,alias,contrasennia,correo);
        if (usuarioDao.insertarUsuario(user)){
            System.out.println("Se insertó");
            return true;
        }
        else{
            return false;
        }
        
    }
    
}
