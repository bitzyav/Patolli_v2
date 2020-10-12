/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dominio.Casilla;
import dominio.CasillaPropia;
import dominio.ColorFicha;
import dominio.Host;
import dominio.Partida;
import dominio.Tablero;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import partida.Fabrica;
import partida.IPartida;

/**
 *
 * @author Itzel
 */
public class FrmTablero extends FrmBase {

    private IPartida partida;
    private static FrmSalir frmSalir;
    private Host host;

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
        btnMeterFicha.setEnabled(false);
        new Thread(new Runnable() {
            public void run() {
                while (!partida.isTableroListo()) {
                    System.out.println("no");
                }
                System.out.println("hola");
                btnMeterFicha.setEnabled(true);
                partida.agregarJugador(host);
                try {
                    this.finalize();
                } catch (Throwable ex) {
                    Logger.getLogger(FrmTablero.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
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
        host = new Host(FrmConfigurarPartida.numFichas);
        Partida p = new Partida();
        host.setPartida(p);
        host.setColor(ColorFicha.ROJO); //Esto es provicional

        p.getJugadores().add(host);
        partida = Fabrica.getFachadaPartida(host);

        partida.obtenerPartida().setTablero(new Tablero(numCasillas));

        JPanel pnlTablero = new JPanel();
        JPanel pnlBotones = new JPanel();
        this.setLayout(new FlowLayout());
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        pnlTablero.setLayout(new BoxLayout(pnlTablero, BoxLayout.X_AXIS));
        pnlBotones.setLayout(new BoxLayout(pnlBotones, BoxLayout.X_AXIS));
        pnlTablero.add(partida.obtenerTablero().getCanvasTablero());
        pnlTablero.setPreferredSize(new Dimension(partida.obtenerTablero().getCanvasTablero().getAncho(), partida.obtenerTablero().getCanvasTablero().getAlto()));
        pnlBotones.add(btnTirarCanias);
        pnlBotones.add(btnRetirarse);
        pnlBotones.add(btnAvanzarNormal);
        pnlBotones.add(btnMeterFicha);
        pnlTablero.setMaximumSize(new Dimension(partida.obtenerTablero().getCanvasTablero().getAncho(), partida.obtenerTablero().getCanvasTablero().getAlto()));
        pnlTablero.setBorder(BorderFactory.createEtchedBorder());
        pnlBotones.setBorder(BorderFactory.createEmptyBorder());
        this.getContentPane().add(pnlTablero);
        this.getContentPane().add(pnlBotones);
    }

    public static FrmSalir getFrmSalir() {
        if (frmSalir == null) {
            frmSalir = new FrmSalir();
        }
        return frmSalir;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTirarCanias = new javax.swing.JButton();
        btnRetirarse = new javax.swing.JButton();
        btnAvanzarNormal = new javax.swing.JButton();
        btnMeterFicha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnTirarCanias.setText("Tirar cañas");
        btnTirarCanias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTirarCaniasActionPerformed(evt);
            }
        });

        btnRetirarse.setText("Retirarse");
        btnRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarseActionPerformed(evt);
            }
        });

        btnAvanzarNormal.setText("Avanzar Ficha del Turno");
        btnAvanzarNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarNormalActionPerformed(evt);
            }
        });

        btnMeterFicha.setText("Meter ficha");
        btnMeterFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterFichaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(btnRetirarse))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(btnTirarCanias))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(486, 486, 486)
                        .addComponent(btnAvanzarNormal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(445, 445, 445)
                        .addComponent(btnMeterFicha)))
                .addContainerGap(353, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRetirarse)
                .addGap(23, 23, 23)
                .addComponent(btnTirarCanias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvanzarNormal)
                .addGap(51, 51, 51)
                .addComponent(btnMeterFicha)
                .addGap(450, 450, 450))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarseActionPerformed
        getFrmSalir().setVisible(true);
    }//GEN-LAST:event_btnRetirarseActionPerformed

    private void btnTirarCaniasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTirarCaniasActionPerformed

    }//GEN-LAST:event_btnTirarCaniasActionPerformed

    private void btnMeterFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterFichaActionPerformed
        partida.meterFicha(host);
        this.repaint();
    }//GEN-LAST:event_btnMeterFichaActionPerformed

    private void btnAvanzarNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarNormalActionPerformed


    }//GEN-LAST:event_btnAvanzarNormalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzarNormal;
    private javax.swing.JButton btnMeterFicha;
    private javax.swing.JButton btnRetirarse;
    private javax.swing.JButton btnTirarCanias;
    // End of variables declaration//GEN-END:variables
}
