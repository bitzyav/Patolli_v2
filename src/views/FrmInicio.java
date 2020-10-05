/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Itzel
 */
public class FrmInicio extends javax.swing.JFrame {

    /**
     * Creates new form FrmInicio
     */
    public FrmInicio() {
        setUndecorated(true);
        initComponents();
        adaptarPantalla();
        this.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear = new javax.swing.JLabel();
        btnUnirse = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn crear.png"))); // NOI18N
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearMouseExited(evt);
            }
        });
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        btnUnirse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn unirse.png"))); // NOI18N
        btnUnirse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUnirse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUnirseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUnirseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUnirseMouseExited(evt);
            }
        });
        getContentPane().add(btnUnirse, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn salir.png"))); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/frm inicio.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la aplicación.
     * @param evt
     */
    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    /**
     * Evento que cambia la imagen del boton cuando el cursor esta sobre él.
     * @param evt
     */
    private void btnCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseEntered
        btnCrear.setIcon(new ImageIcon("images\\btn crear 2.png"));
    }//GEN-LAST:event_btnCrearMouseEntered

    /**
     * Evento que cambia la imagen del boton cuando el cursor no esta sobre él.
     * @param evt
     */
    private void btnCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseExited
        btnCrear.setIcon(new ImageIcon("images\\btn crear.png"));
    }//GEN-LAST:event_btnCrearMouseExited

    /**
     * Cambia de ventana al frame para configurar partida.
     * @param evt
     */
    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
        FrmConfigurarPartida config = new FrmConfigurarPartida();
        this.setVisible(false);
        config.setVisible(true);
    }//GEN-LAST:event_btnCrearMouseClicked

    /**
     * Evento que cambia la imagen del boton cuando el cursor esta sobre él.
     * @param evt
     */
    private void btnUnirseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnirseMouseEntered
        btnUnirse.setIcon(new ImageIcon("images\\btn unirse 2.png"));
    }//GEN-LAST:event_btnUnirseMouseEntered

    /**
     * Evento que cambia la imagen del boton cuando el cursor no esta sobre él.
     * @param evt
     */
    private void btnUnirseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnirseMouseExited
        btnUnirse.setIcon(new ImageIcon("images\\btn unirse.png"));
    }//GEN-LAST:event_btnUnirseMouseExited

    /**
     * Cambia de ventana al frame de direccion partida para unirse a partida.
     * @param evt
     */
    private void btnUnirseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnirseMouseClicked
        FrmDireccPartida direcc = new FrmDireccPartida();
        this.setVisible(false);
        direcc.setVisible(true);
    }//GEN-LAST:event_btnUnirseMouseClicked

    /**
     * Evento que cambia la imagen del boton cuando el cursor esta sobre él.
     * @param evt
     */
    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setIcon(new ImageIcon("images\\btn salir 2.png"));
    }//GEN-LAST:event_btnSalirMouseEntered

    /**
     * Evento que cambia la imagen del boton cuando el cursor no esta sobre él.
     * @param evt
     */
    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setIcon(new ImageIcon("images\\btn salir.png"));
    }//GEN-LAST:event_btnSalirMouseExited

    /**
     * Centra la pantalla y ajusta las dimensiones dependiendo de la pantalla en el que se ejecute.
     */
    private void adaptarPantalla(){
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((ancho / 2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2), this.getWidth(),this.getHeight() );
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
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new FrmInicio().setVisible(true);
                
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCrear;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel btnUnirse;
    private javax.swing.JLabel fondo;
    // End of variables declaration//GEN-END:variables
}
