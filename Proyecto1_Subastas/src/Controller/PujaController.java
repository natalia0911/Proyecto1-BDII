/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data_Access_Object.PujaDAO;
import Model.Puja;
import Model.Usuario_Singleton;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PujaController {
    
    private PujaDAO pujaDAO;
    
    public PujaController() throws SQLException {
        pujaDAO = new PujaDAO();
    }
    
    
    public ArrayList<Puja> listarPujas(double idSubcat){
        return pujaDAO.listarPujas(idSubcat);
    }
    
        public boolean insertarPuja(double subCatId, double precioInicial, String detalle,String fechaFin) throws ParseException{
        /*double idUser = Usuario_Singleton.UsuarioSingleton().getUsuario().getId();
        
        Puja Puja = new Puja(idUser,subCatId,precioInicial,detalle,FormatosUtilitaria.devolverFechaSistema(),FormatosUtilitaria.convertirAFechaYHora(fechaFin));
        if (subastaDao.InsertarSubastas(subasta)){
            System.out.println("Se insertó la subasta");
            return true;
        }
        else{
            return false;
        }
*/
        return false;
    }
    
}
