/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Object;

import Model.Parametro;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;


/**
 *
 * @author Admin
 */
public class ImageDAO {
    private ConnectionBD con;

    public ImageDAO() throws SQLException {
        con = ConnectionBD.estate();
    }
    
    public void close(){
        con.closeConnection();
    }
    
//    public Image getImagen(double imageID) throws IOException{
//        /**
//         * Funcion: Listar los parametros
//         * Entradas: Ninguna 
//         * Salidas: lista de objetos categoria
//         */
//        Image graphics = null;
//        try {
//            CallableStatement cst = con.getConnection().prepareCall("{call SP_SelectImagen (?,?)}");
//             //se definen los parametros de entrada y salida
//            cst.setDouble(1, imageID);
//            cst.registerOutParameter(2, OracleTypes.CURSOR);
//            cst.execute();
//            
//            
//            ResultSet result = ((OracleCallableStatement)cst).getCursor(2);
//            while(result.next()){
//                java.sql.Blob blob = result.getBlob(1);  
//                InputStream in = blob.getBinaryStream();
//                BufferedImage temp = ImageIO.read(in);
//                graphics = (Image) temp;
//
//            }
//            return graphics;
//        } catch (SQLException ex) {
//            System.out.println("Error: " + ex.getMessage());
//        } finally {
//           // con.closeConnection();
//        }
//        return null;
//    }
}
