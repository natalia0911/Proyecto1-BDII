/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DateSorter;
import Data_Access_Object.HistorialUsuarioDAO;
import Model.HistorialUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class MisComentarios extends javax.swing.JFrame {

    /**
     * Creates new form MisComentarios
     */
    
    private int miID;
    private HistorialUsuarioDAO miHistorial;
    private DefaultTableModel modelo;
     private ArrayList<HistorialUsuario> lista;
     
    public MisComentarios(int miID) throws SQLException {
        initComponents();
        this.miID = miID;
        miHistorial = new HistorialUsuarioDAO();
        modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) jTableHistorial.getModel();
        llenarJTable();
        quitarNulos();
    }
    
    private MisComentarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void quitarNulos() throws SQLException{
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getComentario() == null){
                if(lista.get(i).getTipo().equals("Vendedor")){
                    miHistorial.UpdateComentarioVendedor(lista.get(i).getIdVendedor(),lista.get(i).getIdComprador(),lista.get(i).getIdSubasta()," ",lista.get(i).getCalificacion());
                }else{
                    miHistorial.UpdateComentarioComprador(lista.get(i).getIdVendedor(),lista.get(i).getIdComprador(),lista.get(i).getIdSubasta()," ",lista.get(i).getCalificacion());
                }
            }
        }
    }
    
    private void llenarJTable(){
        
        vaciarJTable();
        lista = miHistorial.mihistorialComprador(miID);
        lista.addAll(miHistorial.mihistorialVendedor(miID));
        lista.sort(new DateSorter());
        if(!lista.isEmpty()){
            for (int i = 0; i < lista.size(); i++){
                modelo.addRow(new Object[]{lista.get(i).getNombreComprador(), lista.get(i).getPrecioBase(),
                lista.get(i).getPrecioFinal(), lista.get(i).getCalificacion(), replaceNull(lista.get(i).getComentario()), lista.get(i).getFecha(),lista.get(i).getTipo()});  
                jTableHistorial.setModel(modelo);
            }       
        }
    }
    
    private String replaceNull(String entrada){
        if(entrada==null){return "Sin comentario";}
        else return entrada;
    }
    
    private void vaciarJTable(){
    
        DefaultTableModel temp = (DefaultTableModel) jTableHistorial.getModel();
        temp.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorial = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        sldCalificacion = new javax.swing.JSlider();
        lblCalificacion = new javax.swing.JLabel();
        lblComentario = new javax.swing.JLabel();
        btnCambiarComent = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAComentario = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Precio base", "Precio final", "Rating", "Comentario", "Fecha", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHistorialMouseClicked(evt);
            }
        });
        jTableHistorial.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jTableHistorialCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTableHistorial);

        jLabel1.setText("Subastas ganadas");

        sldCalificacion.setMajorTickSpacing(1);
        sldCalificacion.setMaximum(5);
        sldCalificacion.setMinimum(1);
        sldCalificacion.setMinorTickSpacing(1);
        sldCalificacion.setPaintLabels(true);
        sldCalificacion.setPaintTicks(true);
        sldCalificacion.setSnapToTicks(true);

        lblCalificacion.setText("Mi calificacion");

        lblComentario.setText("Mi comentario");

        btnCambiarComent.setText("Guardar");
        btnCambiarComent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarComentActionPerformed(evt);
            }
        });

        txtAComentario.setColumns(20);
        txtAComentario.setRows(5);
        jScrollPane2.setViewportView(txtAComentario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblComentario)
                                .addGap(100, 100, 100))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCalificacion)
                                        .addGap(83, 83, 83))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                    .addComponent(sldCalificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCambiarComent)
                        .addGap(105, 105, 105))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblComentario)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(lblCalificacion)
                        .addGap(18, 18, 18)
                        .addComponent(sldCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnCambiarComent)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableHistorialCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTableHistorialCaretPositionChanged
        
    }//GEN-LAST:event_jTableHistorialCaretPositionChanged

    private void jTableHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHistorialMouseClicked
        txtAComentario.setText(lista.get(jTableHistorial.getSelectedRow()).getComentario());
        sldCalificacion.setValue(lista.get(jTableHistorial.getSelectedRow()).getCalificacion());
    }//GEN-LAST:event_jTableHistorialMouseClicked

    private void btnCambiarComentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarComentActionPerformed
        
        int pos = jTableHistorial.getSelectedRow();
        if (pos != -1){

            try {
                if(lista.get(pos).getTipo().equals("Vendedor")){
                    miHistorial.UpdateComentarioVendedor(lista.get(pos).getIdVendedor(),lista.get(pos).getIdComprador(),lista.get(pos).getIdSubasta(),txtAComentario.getText(),sldCalificacion.getValue());
                }else{
                    miHistorial.UpdateComentarioComprador(lista.get(pos).getIdVendedor(),lista.get(pos).getIdComprador(),lista.get(pos).getIdSubasta(),txtAComentario.getText(),sldCalificacion.getValue());
                } 
            }catch (SQLException ex) {
                Logger.getLogger(MisComentarios.class.getName()).log(Level.SEVERE, null, ex);
        }
            llenarJTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar uan subasta");
        }
    }//GEN-LAST:event_btnCambiarComentActionPerformed

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
            java.util.logging.Logger.getLogger(MisComentarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MisComentarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MisComentarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MisComentarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MisComentarios().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarComent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableHistorial;
    private javax.swing.JLabel lblCalificacion;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JSlider sldCalificacion;
    private javax.swing.JTextArea txtAComentario;
    // End of variables declaration//GEN-END:variables
}
