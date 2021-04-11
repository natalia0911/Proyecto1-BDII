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
    
    public boolean verificarPuja(double subastaId,double precio) throws ParseException{
        
        System.out.println("que pex en verificar puja");
        System.out.println("ID"+String.valueOf(getMejorPuja(subastaId).getId()));
        System.out.println("porcentaje"+Parametros_Singleton.Parametros().getPorcentaje().getValue());
        if(getMejorPuja(subastaId).getId()>=0){
            double porcentaje = Parametros_Singleton.Parametros().getPorcentaje().getValue()/100;
            double mejorPrecio = getMejorPuja(subastaId).getPrecio();
            double mejora = (porcentaje*mejorPrecio)+mejorPrecio;
            System.out.println(porcentaje);
            System.out.println(mejorPrecio);
            System.out.println(mejora);
            if(precio>mejora){
                 System.out.println("True de verificar puja");
                return true;
            }
        }
        return false;
    }
    
    public double precioNecesarioPuja(double subastaId,double precio) throws ParseException{
        
        double porcentaje = Parametros_Singleton.Parametros().getPorcentaje().getValue()/100;
        double mejorPrecio = getMejorPuja(subastaId).getPrecio();
        double mejora = (porcentaje*mejorPrecio)+mejorPrecio;
        return mejora;
    }
}
