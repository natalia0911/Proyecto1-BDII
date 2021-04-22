/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.Categoria;
import Model.SubCategoria;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Dell
 */
public class CategoriaDAO {
     private ConnectionBD con;

    public CategoriaDAO() throws SQLException {
          con = ConnectionBD.estate();
    }
    
    public void close(){
        con.closeConnection();
    }
      
    public ArrayList<Categoria> getCategorias(){
        /**
         * Funcion: Listar las categorias
         * Entradas: Ninguna 
         * Salidas: lista de objetos categoria
         */
        ArrayList<Categoria> categorias = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectCategories ()}");
            // result contiene las filas que vienen de la BD
            ResultSet result = cst.executeQuery();
            while(result.next()){
                Categoria categoria = new Categoria();
                categoria.setId(result.getDouble(1));
                categoria.setNombreCategoria(result.getString(2));
                categoria.setSubcategorias(getSubCategorias(result.getDouble(1)));
                categorias.add(categoria);
            }
            return categorias;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return categorias;
        
    }
     
    public ArrayList<SubCategoria> getSubCategorias(double categoriaId){
        /**
         * Funcion: Listar las subcategorias
         * Entradas: El id de la categoria 
         * Salidas: lista de subcategorias
         */
        ArrayList<SubCategoria> subcategorias = new ArrayList();
        try {
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectSubcategories (?)}");
            cst.setDouble(1,categoriaId);
 
            // result contiene las filas que vienen de la BD
            ResultSet result = cst.executeQuery();
            while(result.next()){
                SubCategoria subcat = new SubCategoria();
                subcat.setId(result.getDouble(1));
                subcat.setNombreSubCat(result.getString(2));
                subcategorias.add(subcat);
            }
            return subcategorias;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } 
        return subcategorias;
        
    }
}
