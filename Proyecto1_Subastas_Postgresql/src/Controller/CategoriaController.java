/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data_Access_Object.CategoriaDAO;
import Model.Categoria;
import Model.SubCategoria;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class CategoriaController {
    
    private CategoriaDAO categoriaDao;
    
    public CategoriaController() throws SQLException {
        categoriaDao = new CategoriaDAO();
    }
    
    public ArrayList<Categoria> devolverCategorias(){
         return categoriaDao.getCategorias();
    }
     
   
}
