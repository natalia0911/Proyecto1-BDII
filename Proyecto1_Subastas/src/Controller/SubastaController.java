/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data_Access_Object.SubastaDAO;
import Model.FormatosUtilitaria;
import Model.Subasta;
import Model.Usuario_Singleton;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class SubastaController {

    private SubastaDAO subastaDao;

    public SubastaController() throws SQLException {
        subastaDao = new SubastaDAO();
    }
   

    public boolean insertarSubasta(double subCatId, double precioInicial, String detalle,String fechaFin) throws ParseException{
        double idUser = Usuario_Singleton.UsuarioSingleton().getUsuario().getId();
        System.out.println(FormatosUtilitaria.devolverFechaSistema());
        System.out.println(fechaFin);
        System.out.println(FormatosUtilitaria.convertirAFecha(fechaFin));  
        //No entiendo por qué da la fechaFin con hora en 00:00:00
        //Pero desde la bd si da 12:12:12
        
        Subasta subasta = new Subasta(idUser,subCatId,precioInicial,detalle,FormatosUtilitaria.devolverFechaSistema(),FormatosUtilitaria.convertirAFechaYHora(fechaFin));
        if (subastaDao.InsertarSubastas(subasta)){
            System.out.println("Se insertó la subasta");
            return true;
        }
        else{
            return false;
        }
       // return false;
    }
    
    public ArrayList<Subasta> listarSubastas(double idSubcat){
        return subastaDao.getSubastas(idSubcat);
    }
    
}
