/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CategoriaController;
import Controller.ImageChooser;
import Controller.SubastaController;
import Model.Categoria;
import Model.FormatosUtilitaria;
import Model.SubCategoria;
import Model.Subasta;
import Model.TextPrompt;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

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
    DefaultComboBoxModel modeloCat2;
    DefaultComboBoxModel modeloSubcat2;
    DefaultTableModel modelo;
    private CategoriaController categoriaController;
    private SubastaController subastaController;
    
    public ClientesPrincipal() throws SQLException {
        initComponents();
        categoriaController = new CategoriaController();
        subastaController = new SubastaController();
        modeloCat =  new DefaultComboBoxModel();
        modeloCat = (DefaultComboBoxModel)cbxCategoria.getModel();
        modeloSubcat =  new DefaultComboBoxModel();
        modeloSubcat = (DefaultComboBoxModel)cbxSubcategoria.getModel();
        modeloCat2 =  new DefaultComboBoxModel();
        modeloCat2 = (DefaultComboBoxModel)cbxCategoria2.getModel();
        modeloSubcat2 =  new DefaultComboBoxModel();
        modeloSubcat2 = (DefaultComboBoxModel)cbxSubcategoria2.getModel();
        modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) jTableSubastas.getModel();
        llenarComboCategorias();
        llenarComboCategorias2();
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
        jPanelListarSubasta = new javax.swing.JPanel();
        jPanelListado = new javax.swing.JPanel();
        btnDetallesSubasta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSubastas = new javax.swing.JTable();
        btnHistorial = new javax.swing.JButton();
        btnPujar = new javax.swing.JButton();
        lblCategoria1 = new javax.swing.JLabel();
        lblSubCategoria1 = new javax.swing.JLabel();
        cbxCategoria2 = new javax.swing.JComboBox<>();
        cbxSubcategoria2 = new javax.swing.JComboBox<>();

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

        lblImage.setText("image none");

        javax.swing.GroupLayout jPanelRegistrarSubastaLayout = new javax.swing.GroupLayout(jPanelRegistrarSubasta);
        jPanelRegistrarSubasta.setLayout(jPanelRegistrarSubastaLayout);
        jPanelRegistrarSubastaLayout.setHorizontalGroup(
            jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubCategoria)
                    .addComponent(lblCategoria)
                    .addComponent(lblPrecioInicial)
                    .addComponent(lblProducto))
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnRegistrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrarSubastaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxSubcategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDetalles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(43, 43, 43)
                                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooserSubasta, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(txtFHora))))
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnImage)
                            .addComponent(lblImage))
                        .addGap(165, 165, 165))))
        );
        jPanelRegistrarSubastaLayout.setVerticalGroup(
            jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelRegistrarSubastaLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoria)
                            .addComponent(lblFecha))
                        .addGap(46, 46, 46)
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubCategoria)
                            .addComponent(jLabel1)
                            .addComponent(txtFHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProducto)
                            .addComponent(txtDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImagen))))
                .addGap(51, 51, 51)
                .addGroup(jPanelRegistrarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioInicial)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(lblImage)
                .addGap(68, 68, 68)
                .addComponent(btnRegistrar)
                .addGap(73, 73, 73)
                .addComponent(btnImage)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanelSubastarLayout = new javax.swing.GroupLayout(jPanelSubastar);
        jPanelSubastar.setLayout(jPanelSubastarLayout);
        jPanelSubastarLayout.setHorizontalGroup(
            jPanelSubastarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubastarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelRegistrarSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelSubastarLayout.setVerticalGroup(
            jPanelSubastarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubastarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanelRegistrarSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
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

        jTableSubastas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio", "Categoría", "Subcategoría", "Vendedor"
            }
        ));
        jScrollPane1.setViewportView(jTableSubastas);

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

        lblCategoria1.setText("Categoria");

        lblSubCategoria1.setText("SubCategoria");

        cbxCategoria2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCategoria2ItemStateChanged(evt);
            }
        });
        cbxCategoria2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxCategoria2FocusLost(evt);
            }
        });
        cbxCategoria2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxCategoria2MouseClicked(evt);
            }
        });
        cbxCategoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoria2ActionPerformed(evt);
            }
        });

        cbxSubcategoria2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSubcategoria2ItemStateChanged(evt);
            }
        });
        cbxSubcategoria2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxSubcategoria2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelListadoLayout = new javax.swing.GroupLayout(jPanelListado);
        jPanelListado.setLayout(jPanelListadoLayout);
        jPanelListadoLayout.setHorizontalGroup(
            jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubCategoria1)
                    .addComponent(lblCategoria1))
                .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelListadoLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(cbxCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListadoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSubcategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelListadoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnDetallesSubasta, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)
                        .addComponent(btnPujar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanelListadoLayout.setVerticalGroup(
            jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListadoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetallesSubasta)
                    .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPujar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
            .addGroup(jPanelListadoLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria1))
                .addGap(46, 46, 46)
                .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxSubcategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubCategoria1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelListarSubastaLayout = new javax.swing.GroupLayout(jPanelListarSubasta);
        jPanelListarSubasta.setLayout(jPanelListarSubastaLayout);
        jPanelListarSubastaLayout.setHorizontalGroup(
            jPanelListarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListarSubastaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelListado, javax.swing.GroupLayout.PREFERRED_SIZE, 1115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanelListarSubastaLayout.setVerticalGroup(
            jPanelListarSubastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListarSubastaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanelListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        tabSubastas.addTab("Listar", jPanelListarSubasta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabSubastas, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
        /**
         * Funcion: Registra una nueva subasta
         */
        //System.out.println();
        String fechaFin = FormatosUtilitaria.formatoFecha(jDateChooserSubasta.getDate())+" "+txtFHora.getText();
        SubCategoria subcat = (SubCategoria) modeloSubcat.getSelectedItem();
        
        try {
            subastaController.insertarSubasta(subcat.getId(),Double.parseDouble(txtPrecio.getText()),txtDetalles.getText(),fechaFin);
        } catch (ParseException ex) {
            Logger.getLogger(ClientesPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed
    
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
    
    public void llenarComboCategorias2(){
        /**
         * Funcion: Llenar el cbx con objetos de tipo categoria
         * Entradas: Ninguna
         * Salidas: Ninguna
         */
        ArrayList<Categoria> lista = categoriaController.devolverCategorias();

        for (int i = 0; i < lista.size(); i++){
            modeloCat2.addElement(lista.get(i));
            cbxCategoria2.setModel(modeloCat2);
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
    
    public void createSubCat2(Categoria cat){
        ArrayList<SubCategoria> lista = cat.getSubcategorias();
        modeloSubcat2.removeAllElements();
        for (int i = 0; i < lista.size(); i++){
                modeloSubcat2.addElement(lista.get(i));
            }
        cbxSubcategoria2.setModel(modeloSubcat2);
    }
    
    
    private void llenarJTable(double idSubcat){
        ArrayList<Subasta> lista = subastaController.listarSubastas(idSubcat);
                
        for (int i = 0; i < lista.size(); i++){
                modelo.addRow(new Object[]{lista.get(i)});  //Poner acá los datos en orden a poner en la fila
                jTableSubastas.setModel(modelo);
            }
    }
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

    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void cbxSubcategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxSubcategoriaMouseClicked
        
    }//GEN-LAST:event_cbxSubcategoriaMouseClicked

    private void cbxCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoriaMouseClicked

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

    private void cbxCategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxCategoriaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoriaFocusLost

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtFHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFHoraActionPerformed

    private void cbxCategoria2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCategoria2ItemStateChanged
        /**
         * Funcion: Refresca el cbx con los objetos subcategoria correspondientes segun la categoria seleccionada al 
         * hacer click en el cbx de categorias.
         * Entradas: Ninguna
         * Salidas: Ninguna
         */
        Categoria cat = (Categoria) modeloCat2.getSelectedItem();
        createSubCat2(cat);
    }//GEN-LAST:event_cbxCategoria2ItemStateChanged

    private void cbxCategoria2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxCategoria2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoria2FocusLost

    private void cbxCategoria2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCategoria2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoria2MouseClicked

    private void cbxCategoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoria2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoria2ActionPerformed

    private void cbxSubcategoria2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxSubcategoria2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSubcategoria2MouseClicked

    private void cbxSubcategoria2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSubcategoria2ItemStateChanged
        SubCategoria subcat = (SubCategoria) modeloSubcat2.getSelectedItem();
        llenarJTable(subcat.getId());  //Ponerlo en otra funcion
    }//GEN-LAST:event_cbxSubcategoria2ItemStateChanged

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        try {
            lblImage.setIcon(new ImageIcon(ImageChooser.ChooseImage()));
        } catch (IOException ex) {
            System.out.println("No es una imagen lo cargado");
        }
    }//GEN-LAST:event_btnImageActionPerformed

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
    private javax.swing.JButton btnDetallesSubasta;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnPujar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxCategoria2;
    private javax.swing.JComboBox<String> cbxSubcategoria;
    private javax.swing.JComboBox<String> cbxSubcategoria2;
    private com.toedter.calendar.JDateChooser jDateChooserSubasta;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelListado;
    private javax.swing.JPanel jPanelListarSubasta;
    private javax.swing.JPanel jPanelRegistrarSubasta;
    private javax.swing.JPanel jPanelSubastar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSubastas;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCategoria1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblPrecioInicial;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblSubCategoria;
    private javax.swing.JLabel lblSubCategoria1;
    private javax.swing.JTabbedPane tabSubastas;
    private javax.swing.JTextField txtDetalles;
    private javax.swing.JFormattedTextField txtFHora;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
