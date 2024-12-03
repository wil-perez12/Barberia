/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas.admin;

import vistas.Empleado.*;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Admin
 */
public class resumenCitas extends javax.swing.JPanel {
    DefaultTableModel dtm = new DefaultTableModel();
    Conexion con = new Conexion();
    public resumenCitas() {
        initComponents();
        cargarCitasPendientes();
    }
    
    private void cargarCitasPendientes() {
    // Crear una conexión con la base de datos
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Limpiar la tabla antes de cargar nuevos datos
//    dtm.setRowCount(0); 

    try {
        // Conectar a la base de datos
        conexion = con.conectar();

        // Consulta SQL para obtener los datos de la tabla "cita"
        String sql = "SELECT u.nombre, c.corte, c.hora, c.precio "
           + "FROM cita c "
           + "JOIN usuario u ON c.usuario_id = u.id";
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();

        // Recorrer los resultados y agregar filas al modelo de la tabla
        while (rs.next()) {
            String nombre= rs.getString("nombre");
            String corte = rs.getString("corte");
            String hora = rs.getString("hora");
            double precio = rs.getDouble("precio");
            
            // Agregar fila al modelo
            String indices []={"Cliente","Corte","Hora","Precio"};
            dtm.setColumnIdentifiers(indices);
            dtm.addRow(new Object[]{nombre, corte, hora, precio});
            tableCP.setModel(dtm);
        }
        //para actualizar los vlores en la tabla
        tableCP.revalidate();
        tableCP.repaint();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar las citas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            // Cerrar recursos
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCP = new javax.swing.JTable();
        btnRealizada = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(564, 330));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(173, 216, 230));
        jLabel1.setText("Citas Pendientes");

        tableCP.setBackground(new java.awt.Color(0, 0, 0));
        tableCP.setFont(new java.awt.Font("Ebrima", 2, 14)); // NOI18N
        tableCP.setForeground(new java.awt.Color(173, 216, 230));
        tableCP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "corte", "hora", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tableCP);

        btnRealizada.setBackground(new java.awt.Color(0, 0, 0));
        btnRealizada.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizada.setText("Eliminar");
        btnRealizada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnRealizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(351, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRealizada, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRealizada, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRealizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizadaActionPerformed
         // Obtener la fila seleccionada
    int filaSeleccionada = tableCP.getSelectedRow();
    
    // Verificar que se haya seleccionado una fila
    if (filaSeleccionada != -1) {
        // Eliminar la fila del modelo
        DefaultTableModel modelo = (DefaultTableModel) tableCP.getModel();
        modelo.removeRow(filaSeleccionada);
        
        // Actualizar la tabla
        tableCP.revalidate();
        tableCP.repaint();
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.");
    }
    }//GEN-LAST:event_btnRealizadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRealizada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCP;
    // End of variables declaration//GEN-END:variables
}
