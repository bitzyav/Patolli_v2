/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Toolkit;
import javax.swing.JFrame;
import control.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Itzel
 */
public class FrmTablero extends FrmBase {

    private static FrmSalir frmSalir;
    
    /**
     * Instancia de la clase CnvTablero que configura las medidas del tablero.
     */
    CnvTablero tablero;

    /**
     * Inicializa y crea la instancia del frame FrmTablero
     */
    public FrmTablero() {
        initComponents();
        inicializar();
    }

    /**
     * Método que extiende la ventana del frame según la pantalla y dibuja el
     * tablero con cierto número de casillas (Variable)
     */
    private void inicializar() {
        adaptarPantalla();
        extenderPantalla();
        dibujarTablero(FrmConfigurarPartida.numCasillas);
    }

    /**
     * Método que extiende la pantalla a su máximo posible.
     */
    private void extenderPantalla() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Método que dibuja el tablero según el número de casillas introducidas.
     *
     * @param numCasillas El número de casillas que tendrá el tablero.
     */
    private void dibujarTablero(int numCasillas) {
        tablero = new CnvTablero(numCasillas, 40, 40);
        JPanel pnlTablero = new JPanel();
        JPanel pnlBotones = new JPanel();
        this.setLayout(new FlowLayout());
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        pnlTablero.setLayout(new BoxLayout(pnlTablero, BoxLayout.X_AXIS));
        pnlBotones.setLayout(new BoxLayout(pnlBotones, BoxLayout.X_AXIS));
        pnlTablero.add(tablero);
        pnlTablero.setPreferredSize(new Dimension(tablero.getAncho(),tablero.getAlto()));
        pnlBotones.add(btnTirarCanias);
        pnlBotones.add(btnRetirarse);
        pnlBotones.add(btnAvanzarNormal);
        pnlTablero.setMaximumSize(new Dimension(tablero.getAncho(),tablero.getAlto()));
        pnlTablero.setBorder(BorderFactory.createEtchedBorder());
        pnlBotones.setBorder(BorderFactory.createEmptyBorder());
        this.getContentPane().add(pnlTablero);
        this.getContentPane().add(pnlBotones);

    }

    public static FrmSalir getFrmSalir() {
        if(frmSalir==null){
            frmSalir=new FrmSalir();
        }
        return frmSalir;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTirarCanias = new javax.swing.JButton();
        btnRetirarse = new javax.swing.JButton();
        btnAvanzarNormal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnTirarCanias.setText("Tirar cañas");

        btnRetirarse.setText("Retirarse");
        btnRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarseActionPerformed(evt);
            }
        });

        btnAvanzarNormal.setText("Avanzar Ficha del Turno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1057, 1057, 1057)
                .addComponent(btnRetirarse)
                .addGap(0, 0, 0)
                .addComponent(btnAvanzarNormal))
            .addGroup(layout.createSequentialGroup()
                .addGap(833, 833, 833)
                .addComponent(btnTirarCanias))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2615, 2615, 2615)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRetirarse)
                    .addComponent(btnAvanzarNormal))
                .addGap(5, 5, 5)
                .addComponent(btnTirarCanias))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarseActionPerformed
        getFrmSalir().setVisible(true);
    }//GEN-LAST:event_btnRetirarseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzarNormal;
    private javax.swing.JButton btnRetirarse;
    private javax.swing.JButton btnTirarCanias;
    // End of variables declaration//GEN-END:variables
}
