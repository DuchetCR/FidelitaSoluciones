/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import javax.swing.JOptionPane;
/**
 *
 * @author DuchetCR
 */
public class Prestamos extends javax.swing.JFrame {
    private ClasePrestamos prestamo;

    public Prestamos() {
        initComponents();
        setupTableListener();
        prestamo = new ClasePrestamos();
        prestamo.leerPrestamos(jTable_prestamos);
    }

    private void setupTableListener() {
        jTable_prestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_prestamosMouseClicked(evt);
            }
        });
    }

    private void jTable_prestamosMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable_prestamos.getSelectedRow();
        jTxtIdLibro.setText(jTable_prestamos.getValueAt(selectedRow, 0).toString());
        jTxtEditorial.setText(jTable_prestamos.getValueAt(selectedRow, 1).toString());
        jTxtAnio.setText(jTable_prestamos.getValueAt(selectedRow, 2).toString());
    }

    private void limpiar() {
        jTxtIdLibro.setText("");
        jTxtEditorial.setText("");
        jTxtAnio.setText("");
    }

    private boolean validateInputs() {
        if (jTxtIdLibro.getText().isEmpty() || jTxtEditorial.getText().isEmpty() || jTxtAnio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados.");
            return false;
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLbl_titulo = new java.awt.Label();
        jLbl_editorial = new java.awt.Label();
        jLbl_anio = new java.awt.Label();
        jTxtIdLibro = new javax.swing.JTextField();
        jTxtEditorial = new javax.swing.JTextField();
        jTxtAnio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_prestamos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Libros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setToolTipText("Datos de Libros");

        jLbl_titulo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLbl_titulo.setText("ID libro:");

        jLbl_editorial.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLbl_editorial.setText("ID Usuario:");

        jLbl_anio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLbl_anio.setText("Fecha devolucion:");

        jTxtIdLibro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTxtIdLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIdLibroActionPerformed(evt);
            }
        });

        jTxtEditorial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jTxtAnio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLbl_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtAnio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbl_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtEditorial)
                            .addComponent(jTxtIdLibro))))
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtIdLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbl_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbl_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable_prestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_prestamos);

        btnEliminar.setBackground(new java.awt.Color(0, 51, 153));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(0, 51, 153));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizar)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtIdLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIdLibroActionPerformed

    }//GEN-LAST:event_jTxtIdLibroActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (validateInputs()) {
            prestamo.agregarPrestamo(jTxtIdLibro.getText(), jTxtEditorial.getText(), jTxtAnio.getText(), jTable_prestamos);
            limpiar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (validateInputs()) {
            int selectedRow = jTable_prestamos.getSelectedRow();
            String id_prestamo = jTable_prestamos.getValueAt(selectedRow, 0).toString();
            prestamo.eliminarPrestamo(id_prestamo, jTxtIdLibro.getText(), jTxtEditorial.getText(), jTxtAnio.getText(), jTable_prestamos);
            limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        prestamo.leerPrestamos(jTable_prestamos);
    }//GEN-LAST:event_btnActualizarActionPerformed

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        java.awt.EventQueue.invokeLater(() -> new Prestamos().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private java.awt.Label jLbl_anio;
    private java.awt.Label jLbl_editorial;
    private java.awt.Label jLbl_titulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_prestamos;
    private javax.swing.JTextField jTxtAnio;
    private javax.swing.JTextField jTxtEditorial;
    private javax.swing.JTextField jTxtIdLibro;
    // End of variables declaration//GEN-END:variables
}
