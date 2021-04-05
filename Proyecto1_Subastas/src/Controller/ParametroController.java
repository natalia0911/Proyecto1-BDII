/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data_Access_Object.ParametrosDAO;
import Model.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class ParametroController {
    private ParametrosDAO parametrosDao;

    public ParametroController() throws SQLException {
        this.parametrosDao = new ParametrosDAO();
    }
    
    public ArrayList<Parametro> getParametros(){
        return parametrosDao.getParametros();
    }
    
    public boolean modificarParametro(Parametro parametro){
        if(parametrosDao.modificarParametro(parametro)){
            return true;
        }
        return false;
    }
}
