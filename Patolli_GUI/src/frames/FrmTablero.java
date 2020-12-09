/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dominio.Casilla;
import dominio.EstadoPartida;
import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;
import static frames.FrmClienteAux.partida;
import grafico.CnvTablero;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import socketCliente.SocketCliente;

/**
 *
 * @author Invitado
 */
public class FrmTablero extends FrmClienteAux {

    private static FrmSalir frmSalir;
    // private JPanel pnlTablero;
    private CnvTablero cnvTablero;

    /**
     * Creates new form FrmTablero
     */
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
        if (!jugador.equals(partida.getJugadores().get(0))) {
            btnComenzarPartida.setVisible(false);
        }

        cnvTablero.setSize(this.getWidth(), partida.getNumCasillasAspa() * 50 + (50 * 5));
        cnvTablero.setLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 4, 0);
        cnvTablero.addMouseListener(new java.awt.event.MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                cnvTableroClick(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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

    @Override
    protected void adaptarPantalla() {
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int taskBarHeight = screenInsets.bottom;
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setBounds(0, 0, ancho, alto - taskBarHeight);

        this.setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
    }

    public static FrmSalir getFrmSalir() {
        if (frmSalir == null) {
            frmSalir = new FrmSalir();
        }
        return frmSalir;
    }

    private void pintarTablero() {
        cnvTablero.setCasillas(partida.getTablero().getCasillas());
        this.repaint();
        //cnvTablero.repaint();
        //  this.paintComponents(this.getGraphics());
    }

    @Override
    public void update(Partida partidaLlegada) {
        super.update(partidaLlegada);
        actualizaJugador();
        pintarTablero();
        actualizarPantalla();
    }

    private void actualizarPantalla() {
        if (partida.getCantidadDado() != -1) {
            lblDado.setText("Tiro: " + partida.getCantidadDado());
        }

        if (partida.getCuantasMueve() == 0) {
            lblDado.setText("Tiro: " + partida.getCuantasMueve());
        }

        if (partida.getEstado() == EstadoPartida.ESPERA && jugador.getNumJugador() == 1) {
            btnComenzarPartida.setVisible(true);
        } else {
            btnComenzarPartida.setVisible(false);
        }

        if (partida.getJugadorTurno().equals(jugador)) {
            if (partida.getCantidadDado() == -1) {
                btnTirarCanias.setEnabled(true);
            }

            if (partida.getCuantasMueve() != 0) {
                btnMeterFicha.setEnabled(true);
                btnAvanzarNormal.setEnabled(true);
            }
            if (btnTirarCanias.isEnabled()) {
                btnMeterFicha.setEnabled(false);
                btnAvanzarNormal.setEnabled(false);
            }
        } else {
            btnTirarCanias.setEnabled(false);
            btnMeterFicha.setEnabled(false);
            btnAvanzarNormal.setEnabled(false);
        }

    }

    private void cnvTableroClick(MouseEvent e) {
        double x = e.getPoint().getX();
        double y = e.getPoint().getY();
        for (Casilla casilla : partida.getTablero().getCasillas()) {
            if (x >= casilla.getCoordenadaX() && x <= (casilla.getCoordenadaX() + 50) && y >= casilla.getCoordenadaY() && y <= (casilla.getCoordenadaY() + 50)) {
                System.out.println(casilla);
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAvanzarNormal = new javax.swing.JButton();
        btnMeterFicha = new javax.swing.JButton();
        btnTirarCanias = new javax.swing.JButton();
        lblDado = new javax.swing.JLabel();
        btnRetirarse = new javax.swing.JButton();
        btnComenzarPartida = new javax.swing.JButton();
        lblFichasGanadoras = new javax.swing.JLabel();
        lblNumFrijoles = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        btnAvanzarNormal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAvanzarNormal.setText("Avanzar Ficha del Turno");
        btnAvanzarNormal.setEnabled(false);
        btnAvanzarNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarNormalActionPerformed(evt);
            }
        });

        btnMeterFicha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterFicha.setText("Meter ficha");
        btnMeterFicha.setEnabled(false);
        btnMeterFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterFichaActionPerformed(evt);
            }
        });

        btnTirarCanias.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTirarCanias.setText("Tirar cañas");
        btnTirarCanias.setEnabled(false);
        btnTirarCanias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTirarCaniasActionPerformed(evt);
            }
        });

        lblDado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDado.setText("Tiro: --");

        btnRetirarse.setText("Retirarse");
        btnRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarseActionPerformed(evt);
            }
        });

        btnComenzarPartida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnComenzarPartida.setText("Comenzar partida");
        btnComenzarPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComenzarPartidaMouseClicked(evt);
            }
        });
        btnComenzarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarPartidaActionPerformed(evt);
            }
        });

        lblFichasGanadoras.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFichasGanadoras.setText("Has metido 0 fichas");

        lblNumFrijoles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNumFrijoles.setText("Te quedan -- frijolitos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRetirarse, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAvanzarNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTirarCanias, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMeterFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDado, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFichasGanadoras, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumFrijoles, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnComenzarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 623, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTirarCanias, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnMeterFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnAvanzarNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblDado, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblFichasGanadoras, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumFrijoles, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComenzarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnRetirarse, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvanzarNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarNormalActionPerformed
        try {
            partida.setFichaMovimiento(jugador.getColaFichas().peek());

            if (partida.getFichaMovimiento() == null) {
                partida.setCantidadDado(0);
            }

            cliente.enviar(partida);

        } catch (IOException ex) {
            Logger.getLogger(FrmTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAvanzarNormalActionPerformed

    private void btnMeterFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterFichaActionPerformed

    }//GEN-LAST:event_btnMeterFichaActionPerformed

    private void btnTirarCaniasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTirarCaniasActionPerformed
        try {
            Random r = new Random();
            int tiro = r.nextInt(6);

            partida.setCantidadDado(tiro);
            partida.setFichaMovimiento(null);

            cliente.enviar(partida);

            btnTirarCanias.setEnabled(false);

        } catch (IOException ex) {
            Logger.getLogger(FrmTablero.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnTirarCaniasActionPerformed

    private void btnRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarseActionPerformed
        getFrmSalir().setVisible(true);
    }//GEN-LAST:event_btnRetirarseActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        cnvTablero.setLocation(this.getWidth() / 4, 0);
    }//GEN-LAST:event_formComponentResized

    private void btnComenzarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComenzarPartidaActionPerformed

    private void btnComenzarPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComenzarPartidaMouseClicked
        try {
            partida.setEstado(EstadoPartida.INICIADA);
            partida.setJugadorTurno(jugador);
            cliente.enviar(partida);

        } catch (IOException ex) {
            Logger.getLogger(FrmTablero.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnComenzarPartidaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzarNormal;
    private javax.swing.JButton btnComenzarPartida;
    private javax.swing.JButton btnMeterFicha;
    private javax.swing.JButton btnRetirarse;
    private javax.swing.JButton btnTirarCanias;
    private javax.swing.JLabel lblDado;
    private javax.swing.JLabel lblFichasGanadoras;
    private javax.swing.JLabel lblNumFrijoles;
    // End of variables declaration//GEN-END:variables

    private void actualizaJugador() {
        for (Jugador jugadore : partida.getJugadores()) {
            if (jugadore.equals(jugador)) {
                jugador = jugadore;
                lblFichasGanadoras.setText("Has metido " + jugador.getFichasGanadoras().size() + " fichas");
                if (jugador.getNumFrijoles() > 0) {
                    lblNumFrijoles.setText("Te quedan " + jugador.getNumFrijoles() + " frijolitos");
                } else {
                    lblNumFrijoles.setText("Te has quedado sin frijolitos :(");
                }
            }
        }
    }
}
