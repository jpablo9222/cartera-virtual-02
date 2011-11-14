/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUI.java
 *
 * Created on Nov 7, 2011, 4:52:48 PM
 */
package proyecto2;
import javax.swing.*;
/**
 *
 * @author Tono
 */
public class GUI extends javax.swing.JFrame {
    private String [] categorias={"Aplicaciones Internet","Dispositivos Electronicos","Membresias","Productos Electronicos"};
    int rowIndex,colIndex;
    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cerrarSesion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datosTabla = new javax.swing.JTable();
        usuario = new javax.swing.JLabel();
        cambiarContrasena = new javax.swing.JButton();
        eliminarCuenta = new javax.swing.JButton();
        categoriasMenu = new javax.swing.JComboBox();
        nuevaCuenta = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        cerrarSesion.setText("Cerrar Sesión");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        datosTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de Usuario", "Contraseña"
            }
        ));
        datosTabla.setCellSelectionEnabled(true);
        datosTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rowIndex = datosTabla.getSelectedRow();
        colIndex = datosTabla.getSelectedColumn();
        datosTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(datosTabla);
        datosTabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        usuario.setText("Usuario");

        cambiarContrasena.setText("Cambiar Contraseña");

        eliminarCuenta.setText("Eliminar Cuenta");
        eliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCuentaActionPerformed(evt);
            }
        });

        categoriasMenu.setModel(new javax.swing.DefaultComboBoxModel(categorias));
        categoriasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriasMenuActionPerformed(evt);
            }
        });

        nuevaCuenta.setText("Nueva Cuenta");
        nuevaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaCuentaActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(nuevaCuenta)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(eliminarCuenta)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cambiarContrasena))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(153, 153, 153)
                        .add(categoriasMenu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 166, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(207, 207, 207)
                        .add(usuario)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(usuario)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(categoriasMenu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(21, 21, 21)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 257, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cambiarContrasena)
                    .add(nuevaCuenta)
                    .add(eliminarCuenta))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Cambiar Categoria");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Buscar");
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Propiedades");
        jMenu1.add(jMenuItem4);

        jMenuItem3.setText("Cerrar Sesion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void eliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCuentaActionPerformed
    datosTabla.removeColumn(new javax.swing.JTable().getColumn(rowIndex));
    
}//GEN-LAST:event_eliminarCuentaActionPerformed

private void categoriasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriasMenuActionPerformed

}//GEN-LAST:event_categoriasMenuActionPerformed

private void nuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaCuentaActionPerformed
    
}//GEN-LAST:event_nuevaCuentaActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    System.exit(0);
    new VentanaPrincipal(NuevoUsuario.getCuentas()).setVisible(true);
}//GEN-LAST:event_jMenuItem3ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiarContrasena;
    private javax.swing.JComboBox categoriasMenu;
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JTable datosTabla;
    private javax.swing.JButton eliminarCuenta;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton nuevaCuenta;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
