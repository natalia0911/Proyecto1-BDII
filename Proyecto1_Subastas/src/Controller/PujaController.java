/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data_Access_Object.PujaDAO;
import Model.Parametros_Singleton;
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
    

    public boolean insertarPuja(double compradorId, double subastaId, double precio, ArrayList<Puja> listaPuja) throws ParseException{
 
       Puja Puja = new Puja(compradorId,subastaId,precio);
       System.out.println("antes del if en puja controller");
       if (verificarPuja(listaPuja,precio)){
            if(pujaDAO.insertarPuja(Puja)){
                System.out.println("Se insertó la puja");
                return true;
            }
        }
        return false;

    }

    public boolean verificarPuja(ArrayList<Puja> listaPuja, double precio) throws ParseException{

        double porcentaje = Parametros_Singleton.Parametros().getPorcentaje().getValue()/100;
        double mejoraMinima = Parametros_Singleton.Parametros().getMontoMinimo().getValue();

        
        double mejorPrecio = listaPuja.get(0).getPrecio();
        
        double precioConPorcentaje = (porcentaje*mejorPrecio)+mejorPrecio;
        double precioConMejora = mejoraMinima+mejorPrecio;
        double max = Math.max(precioConPorcentaje,precioConMejora);

        if(precio>max){
            System.out.println("True de verificar puja");
            return true;
        }
        return false;
    }
    
    public double precioNecesarioPuja( ArrayList<Puja> listaPuja,double precio) throws ParseException{
        
        double porcentaje = Parametros_Singleton.Parametros().getPorcentaje().getValue()/100;
        double mejoraMinima = Parametros_Singleton.Parametros().getMontoMinimo().getValue();
        double mejorPrecio = listaPuja.get(0).getPrecio();
            
        double precioConPorcentaje = (porcentaje*mejorPrecio)+mejorPrecio;
        double precioConMejora = mejoraMinima+mejorPrecio;
        return Math.max(precioConPorcentaje,precioConMejora);
    }
}
