/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CategoriaController;
import Controller.ImageChooser;
import Controller.SubastaController;
import Data_Access_Object.HistorialUsuarioDAO;
import Model.Categoria;
import Model.FormatosUtilitaria;
import Model.HistorialUsuario;
import Model.SubCategoria;
import Model.TextPrompt;
import Model.Usuario;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ClientesPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ClientesPrincipal
     */
    private DefaultComboBoxModel modeloCat;
    private DefaultComboBoxModel modeloSubcat;
    private CategoriaController categoriaController;
    private SubastaController subastaController;
    private Image img;
    private Usuario usuario;
    private HistorialUsuarioDAO miHistorial;
    private ArrayList<HistorialUsuario> lista;

    public ClientesPrincipal() throws SQLException {
        initComponents();
        categoriaController = new CategoriaController();
        subastaController = new SubastaController();
        modeloCat =  new DefaultComboBoxModel();
        miHistorial = new HistorialUsuarioDAO();
        modeloCat = (DefaultComboBoxModel)cbxCategoria.getModel();
        modeloSubcat =  new DefaultComboBoxModel();
        modeloSubcat = (DefaultComboBoxModel)cbxSubcategoria.getModel();
        llenarComboCategorias();
        placeHolder();
        
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        tabSubastas = new javax.swing.JTabbedPane();
        jPanelSubastar = new javax.swing.JPanel();
        jPanelRegistrarSubasta = new javax.swing.JPanel();
        lblProducto = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblSubCategoria = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        lblPrecioInicial = new javax.swing.JLabel();
        txtDetalles = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        cbxCategoria = new javax.swing.JComboBox<>();
        cbxSubcategoria = new javax.swing.JComboBox<>();
        jDateChooserSubasta = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtFHora = new javax.swing.JFormattedTextField();
        btnImage = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        btnVerSubastas = new javax.swing.JButton();
        btnComentarios = new javax.swing.JToggleButton();
        btnHistorial = new javax.swing.JToggleButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelRegistrarSubasta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar subasta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblProducto.setText("Detalles de entrega");

        lblFecha.setText("Fecha de cierre");

        lblCategoria.setText("Categoria");

        lblSubCategoria.setText("SubCategoria");

        lblImagen.setText("Imagen del producto");

        lblPrecioInicial.setText("Precio propuesto");

        txtDetalles.setText("detalles");

        txtPrecio.setText("12000");
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        cbxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCategoriaItemStateChanged(evt);
            }
        });
        cbxCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxCategoriaFocusLost(evt);
            }
        });
        cbxCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxCategoriaMouseClicked(evt);
            }
        });
        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });

        cbxSubcategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxSubcategoriaMouseClicked(evt);
            }
        });

        jLabel1.setText("Hora");

        txtFHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        txtFHora.setText("12:12:12");
        txtFHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFHoraActionPerformed(evt);
            }
        });

        btnImage.setText("Cargar");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnVerSubastas.setText("Ver subastas");
        btnVerSubastas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSubastasActionPerformed(evt);
            }
        });

        btnComentarios.setText("Mis comentarios");
        btnComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentariosActionPerformed(evt);
            }
        });

        btnHistorial.setText("Mis Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRegistrarSubastaLayout = new javax.swing.GroupLayout(jPanelRegistrarSubasta);
        jPanelRegistrarSubasta.setLayout(jPanelRegistrarSubastaLayout);
        jPanelRegistrarSubastaLayout.setHorizontalGroup(
            jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrarSubastaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubCategoria)
                            .addComponent(lblCategoria)
                            .addComponent(lblPrecioInicial)
                            .addComponent(lblProducto))
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrarSubastaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxSubcategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDetalles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnVerSubastas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrarSubastaLayout.createSequentialGroup()
                                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(99, 99, 99))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrarSubastaLayout.createSequentialGroup()
                                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)))
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnImage)
                            .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooserSubasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFHora, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addComponent(btnComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );
        jPanelRegistrarSubastaLayout.setVerticalGroup(
            jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoria))
                        .addGap(46, 46, 46)
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubCategoria))
                        .addGap(48, 48, 48)
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProducto)
                            .addComponent(txtDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioInicial)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(107, 107, 107)
                        .addComponent(btnRegistrar))
                    .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                                .addComponent(lblFecha)
                                .addGap(46, 46, 46)
                                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtFHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblImagen)
                                    .addComponent(btnImage))))
                        .addGap(31, 31, 31)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVerSubastas))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSubastarLayout = new javax.swing.GroupLayout(jPanelSubastar);
        jPanelSubastar.setLayout(jPanelSubastarLayout);
        jPanelSubastarLayout.setHorizontalGroup(
            jPanelSubastarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubastarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelRegistrarSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelSubastarLayout.setVerticalGroup(
            jPanelSubastarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubastarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanelRegistrarSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        tabSubastas.addTab("Subastar", jPanelSubastar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabSubastas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabSubastas, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        ImageChooser Selector = new ImageChooser();
        ImageIcon icono = new ImageIcon();
        try {
            img = Selector.elegir(lblImage.getWidth(),lblImage.getHeight());
            if(img != null){
                icono.setImage(img);
                lblImage.setIcon(icono);
            }

        } catch (IOException ex) {
            System.out.println("No es una imagen");
            lblImage.setText("Imagen colocada correctamente");
        }
    }//GEN-LAST:event_btnImageActionPerformed

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
     //   notifiNulls();
    }
    
    private void notifiNulls(){
        lista = miHistorial.mihistorialComprador(usuario.getId());
        lista.addAll(miHistorial.mihistorialVendedor(usuario.getId()));
    
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getComentario() == null){
                JOptionPane.showMessageDialog(null, "Tienes comentarios sin escribir desde la ultima vez que iniciaste sesion");
                break;
            }
        }
    }
    
    private void txtFHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFHoraActionPerformed

    private void cbxSubcategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxSubcategoriaMouseClicked

    }//GEN-LAST:event_cbxSubcategoriaMouseClicked

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed

    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void cbxCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoriaMouseClicked

    private void cbxCategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxCategoriaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoriaFocusLost

    private void cbxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCategoriaItemStateChanged
        /**
        * Funcion: Refresca el cbx con los objetos subcategoria correspondientes segun la categoria seleccionada al
        * hacer click en el cbx de categorias.
        * Entradas: Ninguna
        * Salidas: Ninguna
        */
        Categoria cat = (Categoria) modeloCat.getSelectedItem();
        createSubCat(cat);

    }//GEN-LAST:event_cbxCategoriaItemStateChanged

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        /**
        * Funcion: Registra una nueva subasta
        */

        String fechaFin = FormatosUtilitaria.formatoFecha(jDateChooserSubasta.getDate())+" "+txtFHora.getText();
        SubCategoria subcat = (SubCategoria) modeloSubcat.getSelectedItem();

        try {
            subastaController.insertarSubasta(subcat.getId(),Double.parseDouble(txtPrecio.getText()),txtDetalles.getText(),fechaFin);
            if(!(img==null)){
                subastaController.insertarImagenSubasta(img);
            }
        } catch (ParseException | IOException ex) {
            Logger.getLogger(ClientesPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnVerSubastasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSubastasActionPerformed
       
        try {
            ListaSubastas ventanaSubastas = new ListaSubastas();
            ventanaSubastas.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVerSubastasActionPerformed

    private void btnComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentariosActionPerformed
        try {
                int idVendedor = usuario.getId();
                MisComentarios ventanaVendedor = new MisComentarios(idVendedor);
                ventanaVendedor.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ListaSubastas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnComentariosActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        try {
                VentanaHistorialComprador ventanaComprador = new VentanaHistorialComprador(usuario.getId());
                ventanaComprador.addVendedor(usuario.getId());
                ventanaComprador.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(VentanaHistorialPujas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnHistorialActionPerformed
    
    public void llenarComboCategorias(){
        /**
         * Funcion: Llenar el cbx con objetos de tipo categoria
         * Entradas: Ninguna
         * Salidas: Ninguna
         */
        ArrayList<Categoria> lista = categoriaController.devolverCategorias();

        for (int i = 0; i < lista.size(); i++){
            modeloCat.addElement(lista.get(i));
            cbxCategoria.setModel(modeloCat);
        }
       
    }
    
   
    
    public void createSubCat(Categoria cat){
        ArrayList<SubCategoria> lista = cat.getSubcategorias();
        modeloSubcat.removeAllElements();
        for (int i = 0; i < lista.size(); i++){
                modeloSubcat.addElement(lista.get(i));
            }
        cbxSubcategoria.setModel(modeloSubcat);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ClientesPrincipal().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ClientesPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    public void placeHolder(){
      TextPrompt prueba = new TextPrompt("HH:mm:ss", txtFHora);
      TextPrompt detalle = new TextPrompt("Detalles", txtDetalles);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnComentarios;
    private javax.swing.JToggleButton btnHistorial;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVerSubastas;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxSubcategoria;
    private com.toedter.calendar.JDateChooser jDateChooserSubasta;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelRegistrarSubasta;
    private javax.swing.JPanel jPanelSubastar;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblPrecioInicial;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblSubCategoria;
    private javax.swing.JTabbedPane tabSubastas;
    private javax.swing.JTextField txtDetalles;
    private javax.swing.JFormattedTextField txtFHora;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
