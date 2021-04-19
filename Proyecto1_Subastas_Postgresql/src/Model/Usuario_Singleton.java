/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dell
 */
public class Usuario_Singleton {
    /**
     * Clase usuario singleton para tener una unica instancia de usuario en el programa
     * Se accede como Usuario_Singleton user = Usuario_Singleton.UsuarioSingleton().getUsuario()/setUsuario(Usuario usuario) 
     */
    private static Usuario usuario;
    private static Usuario_Singleton singleton;

    public Usuario_Singleton() {}

    public static synchronized Usuario_Singleton UsuarioSingleton(){

        if (singleton == null){
            singleton = new Usuario_Singleton();
        }
        return singleton;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        Usuario_Singleton.usuario = usuario;
    }

    

    
    
}
