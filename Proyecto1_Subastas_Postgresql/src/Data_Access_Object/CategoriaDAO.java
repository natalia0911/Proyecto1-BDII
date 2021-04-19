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
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

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
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectCategories (?)}");
           
             //se definen los parametros de entrada y salida
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado
            // result contiene las filas que vienen de la BD
            ResultSet result = ((OracleCallableStatement)cst).getCursor(1);  
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
        } finally {
           // con.closeConnection();
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
            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectSubcategories (?,?)}");
           
             //se definen los parametros de entrada y salida
            cst.setDouble(1,categoriaId);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
            
            // Ejecuta el procedimiento almacenado
            cst.execute();
            // Se obtienen la salida del procedimineto almacenado
            // result contiene las filas que vienen de la BD
            ResultSet result = ((OracleCallableStatement)cst).getCursor(2);  
            while(result.next()){
                SubCategoria subcat = new SubCategoria();
                subcat.setId(result.getDouble(1));
                subcat.setNombreSubCat(result.getString(2));
                subcategorias.add(subcat);
            }
            return subcategorias;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
           // con.closeConnection();
        }
        return subcategorias;
        
    }
}
