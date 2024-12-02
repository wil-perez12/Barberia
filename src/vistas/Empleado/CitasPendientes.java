/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas.Empleado;

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
public class CitasPendientes extends javax.swing.JPanel {

    Conexion con = new Conexion();
    public CitasPendientes() {
        initComponents();
        Object[][] data = {
        {"Juan Pérez", "Corte Masculino", "10:00", "$100"},
        {"Ana García", "Corte Femenino", "11:30", "$120"},
   
};
        jTable1.setModel(new DefaultTableModel(data, new String[]{"Cliente", "Corte", "Hora", "Precio"}));
    }
    
    public void cargarCitasPendientes() {
    // Limpiar la tabla antes de cargar los nuevos datos
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Elimina las filas existentes

    try {
        // Establecer la conexión a la base de datos (ajusta los parámetros de conexión)
        Connection conn = con.conectar();

        // Consulta SQL para obtener las citas pendientes (cliente, corte, hora y precio)
        String query = "SELECT cl.nombre AS cliente, c.corte, c.hora, c.precio "
                     + "FROM cita c "
                     + "JOIN cliente cl ON c.cliente_id = cl.id "
                     + "WHERE c.realizada = 0"; // Solo citas no realizadas

        // Crear un PreparedStatement y pasarle la consulta
        PreparedStatement stmt = conn.prepareStatement(query);

        // Ejecutar la consulta
        ResultSet rs = stmt.executeQuery();

        // Recorrer los resultados y agregarlos a la tabla
        while (rs.next()) {
            String cliente = rs.getString("cliente"); // Nombre del cliente
            String corte = rs.getString("corte");     // Tipo de corte
            String hora = rs.getString("hora");       // Hora de la cita
            String precio = rs.getString("precio");   // Precio de la cita

            // Agregar una nueva fila a la tabla
            model.addRow(new Object[]{cliente, corte, hora, precio});
        }

        // Cerrar la conexión
        conn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar las citas: " + ex.getMessage());
    }
}
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRealizada = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(564, 330));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(173, 216, 230));
        jLabel1.setText("Citas Pendientes");

        jTable1.setFont(new java.awt.Font("Ebrima", 2, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(173, 216, 230));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "corte", "hora", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnRealizada.setBackground(new java.awt.Color(0, 0, 0));
        btnRealizada.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizada.setText("Realizada");
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

    }//GEN-LAST:event_btnRealizadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRealizada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
