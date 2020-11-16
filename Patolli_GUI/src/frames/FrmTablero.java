/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dominio.Casilla;
import dominio.CasillaPropia;
import dominio.ColorFicha;
import dominio.Ficha;
import dominio.Host;
import dominio.Partida;
import dominio.Tablero;
import grafico.CnvTablero;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import socketCliente.SocketCliente;

/**
 *
 * @author Itzel
 */
public class FrmTablero extends FrmBase {

    private static FrmSalir frmSalir;
    private JPanel pnlTablero;
    private CnvTablero cnvTablero;
    private SocketCliente cliente;
    private Host jugador;
    private Partida partida;

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

        partida = new Partida();
        Tablero tablero = new Tablero();
        tablero.generarCasillas(FrmConfigurarPartida.numCasillas, this.getBounds().width, 50);

        jugador = new Host(FrmConfigurarPartida.numFichas);
        jugador.setColor(ColorFicha.ROJO);

        for (Casilla casilla : tablero.getCasillas()) {
            if (casilla.getClass().getName().contains("CasillaPropia")) {
                CasillaPropia cas = (CasillaPropia) casilla;
                if (cas.getJugador() == null) {
                    cas.setJugador(jugador);
                    jugador.setCasillaPropia(cas);
                    cas.setFicha(jugador.getFichas().get(0));
                    break;
                }
            }
        }
        pnlTablero = new JPanel();
        cnvTablero = new CnvTablero(tablero.getCasillas(), 50, FrmConfigurarPartida.numCasillas);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        pnlTablero.setLayout(new BoxLayout(pnlTablero, BoxLayout.X_AXIS));
        pnlTablero.setPreferredSize(new Dimension(cnvTablero.getAncho(), cnvTablero.getAlto()));
        pnlTablero.setMaximumSize(new Dimension(cnvTablero.getAncho(), cnvTablero.getAlto()));
        pnlTablero.setBorder(BorderFactory.createEtchedBorder());
        pintarTablero(tablero);

        /*dibujarTablero(FrmConfigurarPartida.numCasillas);
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
        }).start();*/
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
        /*host = new Host(FrmConfigurarPartida.numFichas);
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
        this.getContentPane().add(pnlBotones);*/
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

    }//GEN-LAST:event_btnMeterFichaActionPerformed

    private void btnAvanzarNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarNormalActionPerformed
        Ficha ficha = jugador.getFichas().get(0);

        Iterator<Casilla> cIterator = partida.getTablero().getCasillas().listIterator();

        while (cIterator.hasNext()) {
            Casilla c = cIterator.next();
            if (c.getFicha() != null) {
                if (c.getFicha().equals(ficha)) {
                    c.setFicha(null);
                    if (cIterator.hasNext()) {
                        cIterator.next().setFicha(ficha);

                    } else {
                        partida.getTablero().getCasillas().getFirst().setFicha(ficha);
                    }
                    pintarTablero(partida.getTablero());
                    break;
                }
            }
        }


    }//GEN-LAST:event_btnAvanzarNormalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzarNormal;
    private javax.swing.JButton btnMeterFicha;
    private javax.swing.JButton btnRetirarse;
    private javax.swing.JButton btnTirarCanias;
    // End of variables declaration//GEN-END:variables

    private void pintarTablero(Tablero tablero) {
        cnvTablero.paint(this.getGraphics());

        pnlTablero.add(cnvTablero);

        partida.setTablero(tablero);
        this.getContentPane().add(pnlTablero);
    }
}
