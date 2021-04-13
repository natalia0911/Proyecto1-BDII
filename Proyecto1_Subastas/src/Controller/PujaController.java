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
    

    public boolean insertarPuja(double compradorId, double subastaId, double precio) throws ParseException{
 
        Puja Puja = new Puja(compradorId,subastaId,precio);
        System.out.println("antes del if en puja controller");
       if (verificarPuja(subastaId,precio)){
            if(pujaDAO.insertarPuja(Puja)){
                System.out.println("Se insertó la puja");
                return true;
            }
        }
        return false;

    }
    
    public Puja getMejorPuja(double subastaId) throws ParseException{
        
        return pujaDAO.getMejorPuja(subastaId);
    }
    
    public boolean verificarPuja(ArrayList<Puja> listaPuja, double precio) throws ParseException{
            int i;
            double max = 0;
            for(i=0; i<listaPuja.size(); i++){
                if(max <= listaPuja.get(i).getPrecio()){
                    max = listaPuja.get(i).getPrecio();
                }
            }
            
        return true;
    }
    
    public double precioNecesarioPuja(double subastaId,double precio) throws ParseException{
        
        double porcentaje = Parametros_Singleton.Parametros().getPorcentaje().getValue()/100;
        double mejoraMinima = Parametros_Singleton.Parametros().getMontoMinimo().getValue();
        double mejorPrecio = getMejorPuja(subastaId).getPrecio();
            
        double precioConPorcentaje = (porcentaje*mejorPrecio)+mejorPrecio;
        double precioConMejora = mejoraMinima+mejorPrecio;
        return Math.max(precioConPorcentaje,precioConMejora);
    }
}
