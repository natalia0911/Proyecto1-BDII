/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


/**
 *
 * @author Admin
 */
public class ImageChooser {
    
    public BufferedImage ChooseImage() throws IOException{
        JFileChooser selector = new JFileChooser();
        BufferedImage image = ImageIO.read(selector.getSelectedFile());
        return image;
        
    };
    
    
}
