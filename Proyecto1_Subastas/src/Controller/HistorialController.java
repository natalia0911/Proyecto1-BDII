/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data_Access_Object.HistorialUsuarioDAO;
import Model.HistorialUsuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Natalia
 */
public class HistorialController {
    private HistorialUsuarioDAO hUsuarioDao;

    public HistorialController() throws SQLException {
         hUsuarioDao = new HistorialUsuarioDAO();
    }
    
    public ArrayList<HistorialUsuario> getHistorialVendedor(double idVendedor)
    {
        return hUsuarioDao.historialVendedor(idVendedor);
    }
                   
    public ArrayList<HistorialUsuario> getHistorialComprador(double idComprador)
    {
        return hUsuarioDao.historialComprador(idComprador);
    }
    
    public ArrayList<HistorialUsuario> getMiHistorialVendedor(double idVendedor)
    {
        return hUsuarioDao.mihistorialVendedor(idVendedor);
    }
                   
    public ArrayList<HistorialUsuario> getMiHistorialComprador(double idComprador)
    {
        return hUsuarioDao.mihistorialComprador(idComprador);
    }
    
    
}
