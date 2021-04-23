/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data_Access_Object.ImageDAO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


/**
 *
 * @author Admin
 */
public class ImageChooser {
    
    private ImageDAO Imagenes;
    
    public ImageChooser () throws SQLException{
    
        Imagenes = new ImageDAO();
    }
    
    public Image elegir(int X,int Y) throws IOException{
        JFileChooser selector = new JFileChooser();
        int rtunrval = selector.showOpenDialog(selector);
        String Directorio = null;
        if(rtunrval == JFileChooser.APPROVE_OPTION){
            Directorio = selector.getSelectedFile().getAbsolutePath();
            BufferedImage image = ImageIO.read(selector.getSelectedFile());
            Image resized = image.getScaledInstance(X, Y, Image.SCALE_SMOOTH);
            return resized;
        }else{
            System.out.println("Se pucho cancel");
            return null;
        }
        
    }
    
    public Image getImage(double ID) throws IOException{
        
       return  Imagenes.getImagen(ID);
        
        
    }
    
    
}
