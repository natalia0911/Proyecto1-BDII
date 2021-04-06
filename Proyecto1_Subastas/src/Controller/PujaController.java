/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data_Access_Object.PujaDAO;
import Model.Puja;
import java.sql.SQLException;
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
    
}
