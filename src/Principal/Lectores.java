/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import javax.swing.JOptionPane;
import java.io.*;
/**
 *
 * @author DuchetCR
 */
public class Lectores extends javax.swing.JFrame {
    private ClaseLectores lector;

    public Lectores() {
        initComponents();
        lector = new ClaseLectores();
        lector.cargarLectores(jTable_lectores);
        setupTableListener();
    }

    private void setupTableListener() {
        jTable_lectores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_lectoresMouseClicked(evt);
            }
        });
    }

    private void jTable_lectoresMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable_lectores.getSelectedRow();
        jTxtNombre.setText(jTable_lectores.getValueAt(selectedRow, 1).toString());
        jTxtDireccion.setText(jTable_lectores.getValueAt(selectedRow, 2).toString());
        jTxtTelefono.setText(jTable_lectores.getValueAt(selectedRow, 3).toString());
        jTxtCiudad.setText(jTable_lectores.getValueAt(selectedRow, 4).toString());
        jTxtCorreo.setText(jTable_lectores.getValueAt(selectedRow, 5).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLblNombre = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jTxtDireccion = new javax.swing.JTextField();
        jLblDireccion = new javax.swing.JLabel();
        jLblTelefono = new javax.swing.JLabel();
        jTxtTelefono = new javax.swing.JTextField();
        jLblCiudad = new javax.swing.JLabel();
        jTxtCiudad = new javax.swing.JTextField();
        jLblCorreo = new javax.swing.JLabel();
        jTxtCorreo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_lectores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Lectores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setToolTipText("Datos de Lectores");

        jLblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblNombre.setText("Nombre:");

        jTxtNombre.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNombreActionPerformed(evt);
            }
        });

        jTxtDireccion.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLblDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblDireccion.setText("Dirección:");

        jLblTelefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblTelefono.setText("Telefono:");

        jTxtTelefono.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLblCiudad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblCiudad.setText("Ciudad:");

        jTxtCiudad.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLblCorreo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLblCorreo.setText("Correo:");

        jTxtCorreo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTxtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCorreoActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(0, 51, 153));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(0, 51, 153));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblDireccion)
                    .addComponent(jLblNombre)
                    .addComponent(jLblTelefono)
                    .addComponent(jLblCiudad)
                    .addComponent(jLblCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtCorreo)
                    .addComponent(jTxtCiudad)
                    .addComponent(jTxtNombre)
                    .addComponent(jTxtDireccion)
                    .addComponent(jTxtTelefono))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNombre)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDireccion)
                    .addComponent(jTxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblTelefono)
                    .addComponent(jTxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCiudad)
                    .addComponent(jTxtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCorreo)
                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnActualizar.setBackground(new java.awt.Color(0, 51, 153));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 51, 153));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jTable_lectores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_lectores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizar)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limpiar() {
        jTxtNombre.setText("");
        jTxtDireccion.setText("");
        jTxtTelefono.setText("");
        jTxtCiudad.setText("");
        jTxtCorreo.setText("");
    }


    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = jTxtNombre.getText();
        String direccion = jTxtDireccion.getText();
        String telefono = jTxtTelefono.getText();
        String ciudad = jTxtCiudad.getText();
        String correo = jTxtCorreo.getText();

        if (lector.validateInputs(nombre, direccion, telefono, ciudad, correo)) {
            lector.agregarLector(nombre, direccion, telefono, ciudad, correo);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Agregar Datos",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        }    
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = jTable_lectores.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = jTable_lectores.getValueAt(selectedRow, 1).toString();
            String direccion = jTable_lectores.getValueAt(selectedRow, 2).toString();
            String telefono = jTable_lectores.getValueAt(selectedRow, 3).toString();
            String ciudad = jTable_lectores.getValueAt(selectedRow, 4).toString();
            String correo = jTable_lectores.getValueAt(selectedRow, 5).toString();
            int id = Integer.parseInt(jTable_lectores.getValueAt(selectedRow, 0).toString()); 

            lector.eliminarLector(id, nombre, direccion, telefono, ciudad, correo);
            limpiar();
            lector.cargarLectores(jTable_lectores);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un lector para eliminar.");
        }   
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTxtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCorreoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        new Thread(() -> {    
            int selectedRow = jTable_lectores.getSelectedRow();
            if (selectedRow != -1) {
                String id = jTable_lectores.getValueAt(selectedRow, 0).toString(); 
                String nombre = jTxtNombre.getText();
                String direccion = jTxtDireccion.getText();
                String telefono = jTxtTelefono.getText();
                String ciudad = jTxtCiudad.getText();
                String correo = jTxtCorreo.getText();

                lector.actualizarLector(id, nombre, direccion, telefono, ciudad, correo);
                JOptionPane.showMessageDialog(null, "Datos del lector actualizados", "Actualizar Datos",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                lector.cargarLectores(jTable_lectores); 
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un lector para actualizar.");
            }  
        }).start();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNombreActionPerformed

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
            java.util.logging.Logger.getLogger(Lectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lectores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLblCiudad;
    private javax.swing.JLabel jLblCorreo;
    private javax.swing.JLabel jLblDireccion;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JLabel jLblTelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_lectores;
    private javax.swing.JTextField jTxtCiudad;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtDireccion;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtTelefono;
    // End of variables declaration//GEN-END:variables
}
