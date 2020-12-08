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
import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;
import grafico.CnvTablero;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import socketCliente.SocketCliente;

/**
 *
 * @author Itzel
 */
public class FrmTablero extends FrmClienteAux {

    private static FrmSalir frmSalir;
    // private JPanel pnlTablero;
    private CnvTablero cnvTablero;

    public FrmTablero(SocketCliente clienteN, Jugador jugadorN, Partida partidaN) {
        super(clienteN, jugadorN, partidaN);
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
        setResizable(false);
        
        Tablero tablero = partida.getTablero();

        if (partida.getTablero() == null) {
            try {
                tablero = new Tablero();
                cnvTablero = new CnvTablero(tablero.getCasillas(), partida.getNumCasillasAspa(), this.getSize().width);
                tablero.setCasillas(cnvTablero.generarCasillas());
                partida.setTablero(tablero);
                cliente.enviar(partida);
            } catch (IOException ex) {
                Logger.getLogger(FrmTablero.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            cnvTablero = new CnvTablero(tablero.getCasillas(), partida.getNumCasillasAspa(), this.getSize().width);
        }
        cnvTablero.setSize(this.getWidth(),500);
        cnvTablero.add(btnMeterFicha);
        this.add(cnvTablero);
        pintarTablero();
        //pnlTablero = new JPanel();

        /*this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        pnlTablero.setLayout(new BoxLayout(pnlTablero, BoxLayout.X_AXIS));
        pnlTablero.setPreferredSize(new Dimension(cnvTablero.getAncho(), cnvTablero.getAlto()));
        pnlTablero.setMaximumSize(new Dimension(cnvTablero.getAncho(), cnvTablero.getAlto()));
        pnlTablero.setBorder(BorderFactory.createEtchedBorder());*/
 /*
        partida = new Partida(FrmConfigurarPartida.numCasillas, FrmConfigurarPartida.numFichas, FrmConfigurarPartida.numFondoApuesta);
        Tablero tablero = new Tablero();
        cnvTablero = new CnvTablero(tablero.getCasillas(), FrmConfigurarPartida.numCasillas, this.getSize().width);
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
        pnlTablero = new javax.swing.JPanel();
        lblDado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnTirarCanias.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        btnAvanzarNormal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAvanzarNormal.setText("Avanzar Ficha del Turno");
        btnAvanzarNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarNormalActionPerformed(evt);
            }
        });

        btnMeterFicha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterFicha.setText("Meter ficha");
        btnMeterFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterFichaActionPerformed(evt);
            }
        });

        pnlTablero.setMinimumSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        lblDado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDado.setText("Tiro: --");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRetirarse, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAvanzarNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMeterFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTirarCanias, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDado, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1275, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTirarCanias, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAvanzarNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDado, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMeterFicha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btnRetirarse, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarseActionPerformed
        getFrmSalir().setVisible(true);
    }//GEN-LAST:event_btnRetirarseActionPerformed

    private void btnTirarCaniasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTirarCaniasActionPerformed
        Random r=new Random();
        int tiro=r.nextInt(6);
        lblDado.setText("Tiro: "+tiro);
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
                    pintarTablero();
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
    private javax.swing.JLabel lblDado;
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables

    private void pintarTablero() {
        cnvTablero.setCasillas(partida.getTablero().getCasillas());
        for (int i = 0; i < 3; i++) {
            //cnvTablero.paintComponent(cnvTablero.getGraphics());
           // this.add(cnvTablero);
        }
    }

    @Override
    public void update(Partida partidaLlegada) {
        super.update(partidaLlegada);
        pintarTablero();
    }
}
