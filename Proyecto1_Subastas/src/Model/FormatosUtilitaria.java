/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;


/**
 *
 * @author Natalia
 */
public class FormatosUtilitaria {
    
    private static SimpleDateFormat pfecha = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat phora = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat pfechaYhora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static java.util.Date fecha = new Date();
    
    /**
     * Pasa un date fecha a un string
     * @param fecha
     * @return un string
     */
    public static String formatoFecha(Date fecha){

        return pfecha.format(fecha);
    }
    /**
     * Pasa un date hora a un string
     * @param hora
     * @return un string
     */
    public static String formatoHora(Date hora){
        
        return phora.format(hora);
    }
    
    /**
     * Convierte un string de fecha a un date
     * @param fecha
     * @return un date
     * @throws ParseException 
     */
    public static Date convertirAFecha(String fecha) throws ParseException{

        return pfecha.parse(fecha);
    }
    
    public static Date convertirAFechaYHora(String fecha) throws ParseException{

        return pfechaYhora.parse(fecha);
    }
    
    /**
     * Convierte un string de hora a date
     * @param hora
     * @return
     * @throws ParseException 
     */
    public static Date convertirAHora(String hora) throws ParseException{

        return phora.parse(hora);
    }
    
    /**
     * Valida que la fecha sea una fecha valida en el calendario
     * @param campoFecha
     * @return true o false
     * @throws ParseException 
     */
   public static boolean validarFecha(String campoFecha) throws ParseException {

         try{
            pfecha.setLenient(false);
            pfecha.parse(campoFecha);
            return true;
        }
        catch(ParseException e){
            return false;
        }
    }

   /**
    * Valida que la hora sea  valida
    * @param campoHora
    * @return
    * @throws ParseException 
    */
    public static boolean validarHora(String campoHora) throws ParseException {
        
        try{
            phora.setLenient(false);
            phora.parse(campoHora);
            return true; 
        }
        catch(ParseException e){
            return false;
        }
        
    }
    
    public static Date devolverFechaSistema() throws ParseException{
        return FormatosUtilitaria.convertirAFechaYHora(pfechaYhora.format(fecha));
    }
    
    
    public static ByteArrayInputStream convertirImagenABlob ( Image img ) throws IOException {
        /**
         * Funcion: Convertir la imagen a ByteArrayInputStream 
         * Entradas: una imagen 
         * Salidas: ByteArrayInputStream
         */
        
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", baos);
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
            }
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        return bais;
   }
         
    
}


