/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CategoriaController;
import Model.Categoria;
import Model.SubCategoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Admin
 */
public class ClientesPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ClientesPrincipal
     */
    DefaultComboBoxModel modeloCat;
    DefaultComboBoxModel modeloSubcat;
    private CategoriaController categoriaController;
    
    public ClientesPrincipal() throws SQLException {
        initComponents();
        categoriaController = new CategoriaController();
        modeloCat =  new DefaultComboBoxModel();
        modeloCat = (DefaultComboBoxModel)cbxCategoria.getModel();
        modeloSubcat =  new DefaultComboBoxModel();
        modeloSubcat = (DefaultComboBoxModel)cbxSubcategoria.getModel();
        llenarComboCategorias();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabSubastas = new javax.swing.JTabbedPane();
        jPanelSubastar = new javax.swing.JPanel();
        jPanelRegistrarSubasta = new javax.swing.JPanel();
        lblProducto = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblSubCategoria = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        lblPrecioInicial = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        cbxCategoria = new javax.swing.JComboBox<>();
        cbxSubcategoria = new javax.swing.JComboBox<>();
        jPanelListarSubasta = new javax.swing.JPanel();
        jPanelListado = new javax.swing.JPanel();
        btnDetallesSubasta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnHistorial = new javax.swing.JButton();
        btnPujar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelRegistrarSubasta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar subasta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblProducto.setText("Producto");

        lblFecha.setText("Fecha");

        lblCategoria.setText("Categoria");

        lblSubCategoria.setText("SubCategoria");

        lblImagen.setText("Imagen");

        lblPrecioInicial.setText("Precio propuesto");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelRegistrarSubastaLayout = new javax.swing.GroupLayout(jPanelRegistrarSubasta);
        jPanelRegistrarSubasta.setLayout(jPanelRegistrarSubastaLayout);
        jPanelRegistrarSubastaLayout.setHorizontalGroup(
            jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImagen)
                            .addComponent(lblProducto)
                            .addComponent(lblFecha)
                            .addComponent(lblSubCategoria)
                            .addComponent(lblCategoria)
                            .addComponent(lblPrecioInicial))
                        .addGap(37, 37, 37)
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(txtPrecio)
                            .addComponent(cbxSubcategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(btnRegistrar)))
                .addContainerGap(689, Short.MAX_VALUE))
        );
        jPanelRegistrarSubastaLayout.setVerticalGroup(
            jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(lblFecha)
                .addGap(32, 32, 32)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubCategoria)
                    .addComponent(cbxSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(lblImagen)
                .addGap(78, 78, 78)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioInicial)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnRegistrar)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jPanelSubastarLayout = new javax.swing.GroupLayout(jPanelSubastar);
        jPanelSubastar.setLayout(jPanelSubastarLayout);
        jPanelSubastarLayout.setHorizontalGroup(
            jPanelSubastarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubastarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelRegistrarSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanelSubastarLayout.setVerticalGroup(
            jPanelSubastarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubastarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanelRegistrarSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        tabSubastas.addTab("Subastar", jPanelSubastar);

        jPanelListado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de subastas activas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnDetallesSubasta.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnDetallesSubasta.setText("Detalles");
        btnDetallesSubasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesSubastaActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Producto", "Precio", "Categoría", "Subcategoría", "Vendedor"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnHistorial.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnPujar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnPujar.setText("PUJAR");
        btnPujar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPujarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelListadoLayout = new javax.swing.GroupLayout(jPanelListado);
        jPanelListado.setLayout(jPanelListadoLayout);
        jPanelListadoLayout.setHorizontalGroup(
            jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListadoLayout.createSequentialGroup()
                .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelListadoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelListadoLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnDetallesSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(btnPujar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanelListadoLayout.setVerticalGroup(
            jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetallesSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnPujar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanelListarSubastaLayout = new javax.swing.GroupLayout(jPanelListarSubasta);
        jPanelListarSubasta.setLayout(jPanelListarSubastaLayout);
        jPanelListarSubastaLayout.setHorizontalGroup(
            jPanelListarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListarSubastaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanelListarSubastaLayout.setVerticalGroup(
            jPanelListarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListarSubastaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanelListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        tabSubastas.addTab("Listar", jPanelListarSubasta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabSubastas, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabSubastas, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        System.out.println("Just a dummy button");
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnDetallesSubastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesSubastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetallesSubastaActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnPujarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPujarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPujarActionPerformed

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        System.out.println(modeloCat.getSelectedItem());
                //cbxCategoria
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void cbxSubcategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxSubcategoriaMouseClicked

    }//GEN-LAST:event_cbxSubcategoriaMouseClicked

    private void cbxCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoriaMouseClicked

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
    
    public void llenarComboCategorias(){
        /**
         * Funcion: Llenar el cbx con objetos de tipo categoria
         * Entradas: Ninguna
         * Salidas: Ninguna
         */
        ArrayList<Categoria> lista = categoriaController.devolverCategorias();
        /*
        PRUEBA
        ArrayList<Categoria> categorias = categoriaController.devolverCategorias();
        System.out.println(categorias);
        
        for(int i = 0 ; i<categorias.size() ; i++){
            System.out.println("------------------------------------------------------");
            System.out.println(categorias.get(i).getNombreCategoria()); 
            ArrayList<SubCategoria> subcategorias = categorias.get(i).getSubcategorias();
            for(int j = 0 ; j<subcategorias.size() ; j++){
                System.out.println(subcategorias.get(j).getNombreSubCat()); 
            }
        }
        */
        for (int i = 0; i < lista.size(); i++){
            modeloCat.addElement(lista.get(i));
            cbxCategoria.setModel(modeloCat);
        }
       
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetallesSubasta;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnPujar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxSubcategoria;
    private javax.swing.JPanel jPanelListado;
    private javax.swing.JPanel jPanelListarSubasta;
    private javax.swing.JPanel jPanelRegistrarSubasta;
    private javax.swing.JPanel jPanelSubastar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblPrecioInicial;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblSubCategoria;
    private javax.swing.JTabbedPane tabSubastas;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
