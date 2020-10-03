/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import patolli_gui.CnvTablero;

/**
 *
 * @author Itzel
 */
public class FrmTablero extends javax.swing.JFrame {

    /**
     * Instancia de la clase CnvTablero que configura las medidas del tablero.
     */
    CnvTablero tablero;
    
    /**
     * Inicializa y crea la instancia del frame FrmTablero
     */
    public FrmTablero() {
//        setUndecorated(true);
        initComponents();
//        this.setBackground(new Color(0,0,0,0));
        inicializar();
    }

    /**
     * Método que extiende la ventana del frame según la pantalla y dibuja el tablero con cierto número de casillas (Variable)
     */
    private void inicializar(){
        extenderPantalla();
        dibujarTablero(14);
    }
    
    /**
     * Método que extiende la pantalla a su máximo posible.
     */
    private void extenderPantalla(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    /**
     * Método que dibuja el tablero según el número de casillas introducidas.
     * @param numCasillas El número de casillas que tendrá el tablero.
     */
    private void dibujarTablero(int numCasillas){
        tablero=new CnvTablero(numCasillas);
        tablero.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/4, 100, 1000, 850);
        this.add(tablero);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 216, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1141, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
