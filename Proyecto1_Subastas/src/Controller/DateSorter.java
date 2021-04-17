/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HistorialUsuario;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class DateSorter implements Comparator<HistorialUsuario>{

    @Override
    public int compare(HistorialUsuario o1, HistorialUsuario o2) {
        return o2.getFecha().compareTo(o1.getFecha());
    }
    
}
