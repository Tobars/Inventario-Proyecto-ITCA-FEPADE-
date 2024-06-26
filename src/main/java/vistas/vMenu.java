/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package vistas;

/**
 *
 * @author user
 */
public class vMenu extends javax.swing.JFrame {

    /** Creates new form vMenu */
    public vMenu() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCrudProds = new javax.swing.JButton();
        btnListaProds = new javax.swing.JButton();
        btnProcesosProds = new javax.swing.JButton();
        btnCrearProv = new javax.swing.JButton();
        btnCrearCateg = new javax.swing.JButton();
        btnListaProv = new javax.swing.JButton();
        btnListaCateg = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menú Principal");

        btnCrudProds.setText("Agregar Productos");
        btnCrudProds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrudProdsMouseClicked(evt);
            }
        });

        btnListaProds.setText("Lista de Productos");
        btnListaProds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListaProdsMouseClicked(evt);
            }
        });

        btnProcesosProds.setText("Entrada/Salida Productos");
        btnProcesosProds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProcesosProdsMouseClicked(evt);
            }
        });

        btnCrearProv.setText("Agregar Proveedores");
        btnCrearProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearProvMouseClicked(evt);
            }
        });

        btnCrearCateg.setText("Agregar Categoría");
        btnCrearCateg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearCategMouseClicked(evt);
            }
        });

        btnListaProv.setText("Lista de Proveedores");
        btnListaProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListaProvMouseClicked(evt);
            }
        });

        btnListaCateg.setText("Lista de Categorías");
        btnListaCateg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListaCategMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar productos");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnReportes.setText("Crear reportes");
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProcesosProds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnListaProds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrudProds, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListaProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearProv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnListaCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btnCrearCateg))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrudProds, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCrearProv, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(btnCrearCateg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnListaProv, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(btnListaCateg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(btnListaProds, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProcesosProds, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcesosProdsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProcesosProdsMouseClicked
        // TODO add your handling code here:
        vProcesosProds vProcesoProd = new vProcesosProds();
        vProcesoProd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnProcesosProdsMouseClicked

    private void btnListaCategMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaCategMouseClicked
        // TODO add your handling code here:
        vListaCategorias vListaCateg = new vListaCategorias();
        vListaCateg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnListaCategMouseClicked

    private void btnListaProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaProvMouseClicked
        // TODO add your handling code here:
        vListaProveedores vListaProv = new vListaProveedores();
        vListaProv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnListaProvMouseClicked

    private void btnCrudProdsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrudProdsMouseClicked
        // TODO add your handling code here:
        vAgregarProductos vProd = new vAgregarProductos();
        vProd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCrudProdsMouseClicked

    private void btnCrearProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearProvMouseClicked
        // TODO add your handling code here:
        vAgregarProveedor vProv = new vAgregarProveedor();
        vProv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCrearProvMouseClicked

    private void btnCrearCategMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearCategMouseClicked
        // TODO add your handling code here:
        vAgregarCategoria vCateg = new vAgregarCategoria();
        vCateg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCrearCategMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
        vModificarProductos vModProd = new vModificarProductos();
        vModProd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnListaProdsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaProdsMouseClicked
        // TODO add your handling code here:
        vListaProductos vListaProd = new vListaProductos();
        vListaProd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnListaProdsMouseClicked

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        // TODO add your handling code here:
        vCrearReportes vReportes = new vCrearReportes();
        vReportes.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReportesMouseClicked

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
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCateg;
    private javax.swing.JButton btnCrearProv;
    private javax.swing.JButton btnCrudProds;
    private javax.swing.JButton btnListaCateg;
    private javax.swing.JButton btnListaProds;
    private javax.swing.JButton btnListaProv;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnProcesosProds;
    private javax.swing.JButton btnReportes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
