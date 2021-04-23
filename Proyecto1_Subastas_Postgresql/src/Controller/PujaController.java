/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data_Access_Object.PujaDAO;
import Data_Access_Object.SubastaDAO;
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
    

    public boolean insertarPuja(int compradorId, int subastaId, double precio, ArrayList<Puja> listaPuja) throws ParseException, SQLException{
 
       Puja Puja = new Puja(compradorId,subastaId,precio);
       System.out.println("antes del if en puja controller");
       if (verificarPuja(listaPuja,precio,subastaId)){
            if(pujaDAO.insertarPuja(Puja)){
                System.out.println("Se insertó la puja");
                return true;
            }
        }
        return false;

    }

    public boolean verificarPuja(ArrayList<Puja> listaPuja, double precio, double subastaId) throws ParseException, SQLException{
        /**
         * Funcion: Verifica si la puja es aceptable segun los parametros y si es la primer puja
         * toma como base el precio inicial y no la mejor pues no existe.
         * Entradas: Las pujas de una subasta, el precio de la nueva, y el id de la subasta
         */
        SubastaDAO subastaObj =  new SubastaDAO();
        double porcentaje = Parametros_Singleton.Parametros().getPorcentaje().getValue()/100;
        double mejoraMinima = Parametros_Singleton.Parametros().getMontoMinimo().getValue();
        
        double mejorPrecio = 1;
        if (!listaPuja.isEmpty()){
            mejorPrecio = listaPuja.get(0).getPrecio();
        }
        else{
            mejorPrecio = subastaObj.getSubasta(subastaId).getPrecioInicial();
        }
        double precioConPorcentaje = (porcentaje*mejorPrecio)+mejorPrecio;
        double precioConMejora = mejoraMinima+mejorPrecio;
        double max = Math.max(precioConPorcentaje,precioConMejora);

        if(precio>max){
            System.out.println("True de verificar puja");
            return true;
        }
        return false;
    }
    
    public double precioNecesarioPuja( ArrayList<Puja> listaPuja,double precio,double subastaId) throws ParseException, SQLException{
        
        SubastaDAO subastaObj =  new SubastaDAO();
        double porcentaje = Parametros_Singleton.Parametros().getPorcentaje().getValue()/100;
        double mejoraMinima = Parametros_Singleton.Parametros().getMontoMinimo().getValue();
        double mejorPrecio = 1;
        if (!listaPuja.isEmpty()){
            mejorPrecio = listaPuja.get(0).getPrecio();
        }
        else{
            mejorPrecio = subastaObj.getSubasta(subastaId).getPrecioInicial();
        }
            
        double precioConPorcentaje = (porcentaje*mejorPrecio)+mejorPrecio;
        double precioConMejora = mejoraMinima+mejorPrecio;
        return Math.max(precioConPorcentaje,precioConMejora);
    }
}
