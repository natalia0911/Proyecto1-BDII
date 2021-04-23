/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ParametroController;
import Controller.UsuarioController;
import Model.Parametro;
import Model.Parametros_Singleton;
import Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class AdminPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form AdminPrincipal
     */
    private DefaultTableModel modelo;
    private UsuarioController userController;
    private ParametroController parametroController;
    
    public AdminPrincipal() throws SQLException {
        initComponents();
        buttonGroupEsAdmin.add(rdbAdmi);
        buttonGroupEsAdmin.add(rdbNormal);
        userController = new UsuarioController();
        modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) jTableModiificar.getModel();
        parametroController = new ParametroController();
        llenarJTable();
        setearParametros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupEsAdmin = new javax.swing.ButtonGroup();
        tabModificar = new javax.swing.JTabbedPane();
        jPanelRegistrar = new javax.swing.JPanel();
        jPanelRegistrarBorde = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblAlias = new javax.swing.JLabel();
        lblContrasennia = new javax.swing.JLabel();
        lblEsAdmin = new javax.swing.JLabel();
        jPanelRadios = new javax.swing.JPanel();
        rdbAdmi = new javax.swing.JRadioButton();
        rdbNormal = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtAlias = new javax.swing.JTextField();
        txtContrasennia = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jPanelModificar = new javax.swing.JPanel();
        jPanelRegistrarBordeM = new javax.swing.JPanel();
        lblNombre1 = new javax.swing.JLabel();
        lblCedula1 = new javax.swing.JLabel();
        lblDireccion1 = new javax.swing.JLabel();
        lblCorreo1 = new javax.swing.JLabel();
        lblAlias1 = new javax.swing.JLabel();
        lblContrasennia1 = new javax.swing.JLabel();
        txtNombreM = new javax.swing.JTextField();
        txtCedulaM = new javax.swing.JTextField();
        txtDireccionM = new javax.swing.JTextField();
        txtCorreoM = new javax.swing.JTextField();
        txtAliasM = new javax.swing.JTextField();
        txtContrasenniaM = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jScrollPaneModificar = new javax.swing.JScrollPane();
        jTableModiificar = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        lblMejora = new javax.swing.JLabel();
        lblIncremento = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        txtIncremento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabModificarMouseClicked(evt);
            }
        });

        jPanelRegistrarBorde.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Usuario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        lblNombre.setText("Nombre");

        lblCedula.setText("Cédula");

        lblDireccion.setText("Dirección");

        lblCorreo.setText("Correo");

        lblAlias.setText("Alias");

        lblContrasennia.setText("Contraseña");

        lblEsAdmin.setText("Tipo Usuario");

        jPanelRadios.setBackground(new java.awt.Color(0, 255, 204));

        rdbAdmi.setText("Administrador");

        rdbNormal.setText("Usuario común");

        javax.swing.GroupLayout jPanelRadiosLayout = new javax.swing.GroupLayout(jPanelRadios);
        jPanelRadios.setLayout(jPanelRadiosLayout);
        jPanelRadiosLayout.setHorizontalGroup(
            jPanelRadiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRadiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbAdmi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbNormal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRadiosLayout.setVerticalGroup(
            jPanelRadiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRadiosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelRadiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbAdmi)
                    .addComponent(rdbNormal))
                .addContainerGap())
        );

        txtNombre.setText("Nata");

        txtCedula.setText("123456");

        txtDireccion.setText("pital");

        txtCorreo.setText("nata@gmail.com");
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        txtAlias.setText("nat");

        txtContrasennia.setText("nat");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRegistrarBordeLayout = new javax.swing.GroupLayout(jPanelRegistrarBorde);
        jPanelRegistrarBorde.setLayout(jPanelRegistrarBordeLayout);
        jPanelRegistrarBordeLayout.setHorizontalGroup(
            jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarBordeLayout.createSequentialGroup()
                .addGroup(jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarBordeLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlias)
                            .addComponent(lblEsAdmin)
                            .addComponent(lblNombre)
                            .addComponent(lblCedula)
                            .addComponent(lblCorreo)
                            .addComponent(lblDireccion)
                            .addComponent(lblContrasennia))
                        .addGap(37, 37, 37)
                        .addGroup(jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelRadios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDireccion)
                            .addComponent(txtCedula)
                            .addComponent(txtNombre)
                            .addComponent(txtAlias)
                            .addComponent(txtContrasennia)
                            .addComponent(txtCorreo)))
                    .addGroup(jPanelRegistrarBordeLayout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(btnRegistrar)))
                .addContainerGap(695, Short.MAX_VALUE))
        );
        jPanelRegistrarBordeLayout.setVerticalGroup(
            jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarBordeLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrarBordeLayout.createSequentialGroup()
                        .addComponent(lblEsAdmin)
                        .addGap(34, 34, 34)
                        .addGroup(jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAlias)
                            .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanelRegistrarBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContrasennia)
                            .addComponent(txtContrasennia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrarBordeLayout.createSequentialGroup()
                        .addComponent(jPanelRadios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)))
                .addComponent(btnRegistrar)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jPanelRegistrarLayout = new javax.swing.GroupLayout(jPanelRegistrar);
        jPanelRegistrar.setLayout(jPanelRegistrarLayout);
        jPanelRegistrarLayout.setHorizontalGroup(
            jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanelRegistrarBorde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanelRegistrarLayout.setVerticalGroup(
            jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanelRegistrarBorde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        tabModificar.addTab("Registrar", jPanelRegistrar);

        jPanelRegistrarBordeM.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar Usuario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelRegistrarBordeM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanelRegistrarBordeMFocusGained(evt);
            }
        });

        lblNombre1.setText("Nombre");

        lblCedula1.setText("Cédula");

        lblDireccion1.setText("Dirección");

        lblCorreo1.setText("Correo");

        lblAlias1.setText("Alias");

        lblContrasennia1.setText("Contraseña");

        txtCorreoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoMActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jTableModiificar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cédula", "Direccion", "Correo", "Tipo usuario", "Alias", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneModificar.setViewportView(jTableModiificar);

        javax.swing.GroupLayout jPanelRegistrarBordeMLayout = new javax.swing.GroupLayout(jPanelRegistrarBordeM);
        jPanelRegistrarBordeM.setLayout(jPanelRegistrarBordeMLayout);
        jPanelRegistrarBordeMLayout.setHorizontalGroup(
            jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarBordeMLayout.createSequentialGroup()
                .addGroup(jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarBordeMLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlias1)
                            .addComponent(lblNombre1)
                            .addComponent(lblCedula1)
                            .addComponent(lblCorreo1)
                            .addComponent(lblDireccion1)
                            .addComponent(lblContrasennia1))
                        .addGap(42, 42, 42)
                        .addGroup(jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccionM, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(txtCedulaM)
                            .addComponent(txtNombreM)
                            .addComponent(txtAliasM)
                            .addComponent(txtContrasenniaM)
                            .addComponent(txtCorreoM))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistrarBordeMLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnModificar)
                        .addGap(167, 167, 167)))
                .addComponent(jScrollPaneModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanelRegistrarBordeMLayout.setVerticalGroup(
            jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarBordeMLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelRegistrarBordeMLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre1)
                            .addComponent(txtNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula1)
                            .addComponent(txtCedulaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion1)
                            .addComponent(txtDireccionM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCorreo1)
                            .addComponent(txtCorreoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAliasM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlias1))
                        .addGap(34, 34, 34)
                        .addGroup(jPanelRegistrarBordeMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtContrasenniaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContrasennia1))
                        .addGap(113, 113, 113)
                        .addComponent(btnModificar))
                    .addComponent(jScrollPaneModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout jPanelModificarLayout = new javax.swing.GroupLayout(jPanelModificar);
        jPanelModificar.setLayout(jPanelModificarLayout);
        jPanelModificarLayout.setHorizontalGroup(
            jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanelRegistrarBordeM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelModificarLayout.setVerticalGroup(
            jPanelModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanelRegistrarBordeM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        tabModificar.addTab("Modificar usuario", jPanelModificar);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambiar parámetros del sistema", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblMejora.setText("Porcentaje de mejora");

        lblIncremento.setText("Incremento mínimo");

        txtIncremento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIncrementoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMejora)
                    .addComponent(lblIncremento))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPorcentaje)
                    .addComponent(txtIncremento, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addGap(32, 32, 32))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(btnGuardar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMejora)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIncremento)
                    .addComponent(txtIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnGuardar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(691, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(438, Short.MAX_VALUE))
        );

        tabModificar.addTab("Cambiar parametros", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tabModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(tabModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed
    
    private void setearParametros(){
        System.out.println(Parametros_Singleton.Parametros().getMontoMinimo());
        double perc = Parametros_Singleton.Parametros().getPorcentaje().getValue();
        double min = Parametros_Singleton.Parametros().getMontoMinimo().getValue();
       
        txtPorcentaje.setText(String.valueOf(perc));
        txtIncremento.setText(String.valueOf(min));
    }
    
    private void removeAllRows(){
        /**
         * Funcion: Borrar todas las filas de un Jtable
         */
        DefaultTableModel temp = (DefaultTableModel) jTableModiificar.getModel();
        temp.setRowCount(0);
        
        
    }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        /**
        * Funcion: Agrega una usuario a la BD
        */

       boolean tipo = true;
       if(rdbNormal.isSelected()){
           tipo = false;
       }
       if(userController.insertarUsuario(txtNombre.getText(),Integer.valueOf(txtCedula.getText()),txtDireccion.getText(),
                                      txtCorreo.getText(), tipo, txtAlias.getText(),txtContrasennia.getText())){
           removeAllRows(); 
           JOptionPane.showMessageDialog(null, "¡Usuario agregado!");
       }
       else{
            JOptionPane.showMessageDialog(null, "¡No se pudo agregar el usuario!");
       }
       llenarJTable();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtCorreoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoMActionPerformed

    
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        /**
         * Funcion: Modificar un usuario de la BD
         */
        removeAllRows();
        int posicion = jTableModiificar.getSelectedRow(); 
        System.out.println(posicion);


        if(userController.modificarUsuario(txtNombreM.getText(),Integer.valueOf(txtCedulaM.getText()),txtDireccionM.getText(),
                                   txtCorreoM.getText(), true, txtAliasM.getText(),txtContrasenniaM.getText())){
            JOptionPane.showMessageDialog(null, "¡Usuario modificado!");
       }
       else{
            JOptionPane.showMessageDialog(null, "¡No se pudo modificar el usuario!");
       }
       llenarJTable();
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tabModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabModificarMouseClicked
       
        
    }//GEN-LAST:event_tabModificarMouseClicked

    private void jPanelRegistrarBordeMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanelRegistrarBordeMFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelRegistrarBordeMFocusGained

    private void txtIncrementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIncrementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIncrementoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Parametro p1 = new Parametro("PERC",Double.parseDouble(txtPorcentaje.getText()));
        Parametro p2 = new Parametro("MIN",Double.parseDouble(txtIncremento.getText()));
        if(parametroController.modificarParametro(p1) && parametroController.modificarParametro(p2)){
            parametroController.setParametrosPorcentaje(p1);
            parametroController.setParametrosPMinimo(p2);
            JOptionPane.showMessageDialog(null, "Actulizado con éxito!");
        }
        else{
            JOptionPane.showMessageDialog(null, "No se pudo actualizar");
        }
    
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    private void llenarJTable(){
        ArrayList<Usuario> lista = userController.getAllUser();
                
        for (int i = 0; i < lista.size(); i++){
                modelo.addRow(new Object[]{lista.get(i).getNombre(),lista.get(i).getCedula(),lista.get(i).getDireccion(),
                    lista.get(i).getCorreo(),lista.get(i).isAdmin(),lista.get(i).getAlias(),lista.get(i).getContrasennia()});
                jTableModiificar.setModel(modelo);
            }
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
            java.util.logging.Logger.getLogger(AdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup buttonGroupEsAdmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelModificar;
    private javax.swing.JPanel jPanelRadios;
    private javax.swing.JPanel jPanelRegistrar;
    private javax.swing.JPanel jPanelRegistrarBorde;
    private javax.swing.JPanel jPanelRegistrarBordeM;
    private javax.swing.JScrollPane jScrollPaneModificar;
    private javax.swing.JTable jTableModiificar;
    private javax.swing.JLabel lblAlias;
    private javax.swing.JLabel lblAlias1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedula1;
    private javax.swing.JLabel lblContrasennia;
    private javax.swing.JLabel lblContrasennia1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreo1;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccion1;
    private javax.swing.JLabel lblEsAdmin;
    private javax.swing.JLabel lblIncremento;
    private javax.swing.JLabel lblMejora;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JRadioButton rdbAdmi;
    private javax.swing.JRadioButton rdbNormal;
    private javax.swing.JTabbedPane tabModificar;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtAliasM;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaM;
    private javax.swing.JTextField txtContrasennia;
    private javax.swing.JTextField txtContrasenniaM;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCorreoM;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionM;
    private javax.swing.JTextField txtIncremento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreM;
    private javax.swing.JTextField txtPorcentaje;
    // End of variables declaration//GEN-END:variables
}
