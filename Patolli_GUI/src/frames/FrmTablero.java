/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dominio.Apuesta;
import dominio.Casilla;
import dominio.EstadoPartida;
import dominio.Ficha;
import dominio.Jugador;
import dominio.Partida;
import dominio.Tablero;
import static frames.FrmClienteAux.partida;
import grafico.CnvTablero;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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

        lblGanador.setVisible(false);
        lblImgGanador.setVisible(false);
        Tablero tablero = partida.getTablero();

        btnComenzarPartida.setVisible(false);

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

        lblNombreJugador.setText(jugador.getNombre());

        System.out.println(jugador.getNombre());
        switch (jugador.getColor()) {
            case ROJO:
                lblImgJugador.setIcon(new ImageIcon(getClass().getResource("/images/btn color rojo.png")));
                break;
            case NARANJA:
                lblImgJugador.setIcon(new ImageIcon(getClass().getResource("/images/btn color naranja.png")));
                break;
            case AMARILLO:
                lblImgJugador.setIcon(new ImageIcon(getClass().getResource("/images/btn color amarillo.png")));
                break;
            case VERDE:
                lblImgJugador.setIcon(new ImageIcon(getClass().getResource("/images/btn color verde.png")));
                break;
            case CYAN:
                lblImgJugador.setIcon(new ImageIcon(getClass().getResource("/images/btn color cyan.png")));
                break;
            case AZUL:
                lblImgJugador.setIcon(new ImageIcon(getClass().getResource("/images/btn color azul.png")));
                break;
            case ROSA:
                lblImgJugador.setIcon(new ImageIcon(getClass().getResource("/images/btn color rosa.png")));
                break;
            case MORADO:
                lblImgJugador.setIcon(new ImageIcon(getClass().getResource("/images/btn color morado.png")));
                break;

        }

        cnvTablero.setSize(this.getWidth(), partida.getNumCasillasAspa() * 50 + (50 * 5));
        //java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 4
        cnvTablero.setLocation(0, 0);
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
    }

    /**
     * Método que extiende la pantalla a su máximo posible.
     */
    private void extenderPantalla() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Método que adapta la pantalla a los bordes.
     */
    @Override
    protected void adaptarPantalla() {
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int taskBarHeight = screenInsets.bottom;
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setBounds(0, 0, ancho, alto - taskBarHeight);

        this.setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
    }

    /**
     * Método singleton para el Frame Salir.
     *
     * @return Instancia del FrmSalir.
     */
    public static FrmSalir getFrmSalir() {
        if (frmSalir == null) {
            frmSalir = new FrmSalir(cliente, jugador, partida);
        }
        return frmSalir;
    }

    /**
     * Método que se encarga de actualizar y pintar el tablero.
     */
    private void pintarTablero() {
        cnvTablero.setCasillas(partida.getTablero().getCasillas());
        this.repaint();
        //cnvTablero.repaint();
        //  this.paintComponents(this.getGraphics());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBotones = new javax.swing.JPanel();
        lblNombreJugador = new javax.swing.JLabel();
        btnTirarCanias = new javax.swing.JButton();
        btnMeterFicha = new javax.swing.JButton();
        btnAvanzarNormal = new javax.swing.JButton();
        btnPagarApuesta = new javax.swing.JButton();
        lblDado = new javax.swing.JLabel();
        lblNumFrijoles = new javax.swing.JLabel();
        lblFichasGanadoras = new javax.swing.JLabel();
        btnComenzarPartida = new javax.swing.JButton();
        btnRetirarse = new javax.swing.JButton();
        lblImgJugador = new javax.swing.JLabel();
        lblCanias = new javax.swing.JLabel();
        pnlTurnos = new javax.swing.JPanel();
        lblTurno = new javax.swing.JLabel();
        lblImgTurno = new javax.swing.JLabel();
        lblNombreTurno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstApuestas = new javax.swing.JList<>();
        lblApuestas = new javax.swing.JLabel();
        lblImgGanador = new javax.swing.JLabel();
        lblGanador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        lblNombreJugador.setFont(new java.awt.Font("Yu Gothic Medium", 1, 16)); // NOI18N
        lblNombreJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreJugador.setText("Jugador");

        btnTirarCanias.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTirarCanias.setText("Tirar cañas");
        btnTirarCanias.setEnabled(false);
        btnTirarCanias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTirarCaniasActionPerformed(evt);
            }
        });

        btnMeterFicha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterFicha.setText("Meter ficha");
        btnMeterFicha.setEnabled(false);
        btnMeterFicha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMeterFichaMouseClicked(evt);
            }
        });
        btnMeterFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterFichaActionPerformed(evt);
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

        btnPagarApuesta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPagarApuesta.setText("Pagar apuesta");
        btnPagarApuesta.setEnabled(false);
        btnPagarApuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPagarApuestaMouseClicked(evt);
            }
        });
        btnPagarApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarApuestaActionPerformed(evt);
            }
        });

        lblDado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDado.setText("Tiro: --");

        lblNumFrijoles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNumFrijoles.setText("Te quedan -- frijolitos");

        lblFichasGanadoras.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFichasGanadoras.setText("Has metido 0 fichas");

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

        btnRetirarse.setText("Retirarse");
        btnRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarseActionPerformed(evt);
            }
        });

        lblImgJugador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblImgJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblCanias.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPagarApuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTirarCanias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMeterFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDado)
                            .addComponent(btnAvanzarNormal, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lblImgJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addComponent(lblNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumFrijoles, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnComenzarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btnRetirarse, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblCanias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFichasGanadoras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addComponent(lblNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTirarCanias, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblImgJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(btnMeterFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagarApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAvanzarNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCanias, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFichasGanadoras, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumFrijoles, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComenzarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRetirarse, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTurno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurno.setText("Turno");

        lblImgTurno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblImgTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblNombreTurno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreTurno.setText("Turno");

        jScrollPane1.setViewportView(lstApuestas);

        lblApuestas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblApuestas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApuestas.setText("Mis apuestas");

        javax.swing.GroupLayout pnlTurnosLayout = new javax.swing.GroupLayout(pnlTurnos);
        pnlTurnos.setLayout(pnlTurnosLayout);
        pnlTurnosLayout.setHorizontalGroup(
            pnlTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTurnosLayout.createSequentialGroup()
                        .addGroup(pnlTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTurno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTurnosLayout.createSequentialGroup()
                        .addComponent(lblImgTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
            .addComponent(jScrollPane1)
            .addComponent(lblApuestas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlTurnosLayout.setVerticalGroup(
            pnlTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnosLayout.createSequentialGroup()
                .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImgTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(lblApuestas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblImgGanador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblImgGanador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGanador.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 48)); // NOI18N
        lblGanador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGanador.setText("La partida ha terminado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGanador, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addComponent(lblImgGanador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(pnlTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lblGanador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImgGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(674, Short.MAX_VALUE))
            .addComponent(pnlTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAvanzarNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarNormalActionPerformed
        try {
            partida.setFichaMovimiento(jugador.getColaFichas().peek());

            if (partida.getFichaMovimiento() == null) {
                partida.setCantidadDado(-1);
            }

            cliente.enviar(partida);

        } catch (IOException ex) {
            Logger.getLogger(FrmTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAvanzarNormalActionPerformed

    private void btnMeterFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterFichaActionPerformed
        try {
            jugador.setMeterFicha(true);
            partida.setJugadorTurno(jugador);
            cliente.enviar(partida);
        } catch (IOException ex) {
            Logger.getLogger(FrmTablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMeterFichaActionPerformed

    private void btnTirarCaniasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTirarCaniasActionPerformed
        try {
            Random r = new Random();
            int tiro = r.nextInt(6);

            partida.setCantidadDado(tiro);
            partida.setFichaMovimiento(null);
            partida.setRepiteTurno(false);

            cliente.enviar(partida);

            btnTirarCanias.setEnabled(false);

        } catch (IOException ex) {
            Logger.getLogger(FrmTablero.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnTirarCaniasActionPerformed

    private void btnRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarseActionPerformed
        if (partida.getEstado() == EstadoPartida.INICIADA) {
            getFrmSalir().setVisible(true);
        }
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

    private void btnMeterFichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMeterFichaMouseClicked

    }//GEN-LAST:event_btnMeterFichaMouseClicked

    private void btnPagarApuestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPagarApuestaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarApuestaMouseClicked

    private void btnPagarApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarApuestaActionPerformed
        partida.setAvanzaPagando(true);
        btnAvanzarNormal.setEnabled(false);
        btnMeterFicha.setEnabled(false);
        btnPagarApuesta.setEnabled(false);
    }//GEN-LAST:event_btnPagarApuestaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzarNormal;
    private javax.swing.JButton btnComenzarPartida;
    private javax.swing.JButton btnMeterFicha;
    private javax.swing.JButton btnPagarApuesta;
    private javax.swing.JButton btnRetirarse;
    private javax.swing.JButton btnTirarCanias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApuestas;
    private javax.swing.JLabel lblCanias;
    private javax.swing.JLabel lblDado;
    private javax.swing.JLabel lblFichasGanadoras;
    private javax.swing.JLabel lblGanador;
    private javax.swing.JLabel lblImgGanador;
    private javax.swing.JLabel lblImgJugador;
    private javax.swing.JLabel lblImgTurno;
    private javax.swing.JLabel lblNombreJugador;
    private javax.swing.JLabel lblNombreTurno;
    private javax.swing.JLabel lblNumFrijoles;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JList<String> lstApuestas;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlTurnos;
    // End of variables declaration//GEN-END:variables

    /**
     * Método de actualización para el tablero, accionado mediante su observado.
     *
     * @param partidaLlegada Partida actual.
     */
    @Override
    public void update(Partida partidaLlegada) {
        super.update(partidaLlegada);
        actualizaJugador();
        pintarTablero();
        actualizarPantalla();
        getFrmSalir().update(partidaLlegada);
    }

    /**
     * Actualiza los elementos de la pantalla como el dado, frijoles, botones,
     * etc.
     */
    private void actualizarPantalla() {
        if (partida.getCantidadDado() != -1) {
            lblDado.setText("Tiro: " + partida.getCantidadDado());
            ImageIcon icon = null;
            Image img = null;
            switch (partida.getCantidadDado()) {
                case 1:
                    icon = new ImageIcon(getClass().getResource("/images/caniaUno.png"));
                    break;
                case 2:
                    icon = new ImageIcon(getClass().getResource("/images/caniaDos.png"));
                    break;
                case 3:
                    icon = new ImageIcon(getClass().getResource("/images/caniaTres.png"));
                    break;
                case 4:
                    icon = new ImageIcon(getClass().getResource("/images/caniaCuatro.png"));
                    break;
                case 5:
                    icon = new ImageIcon(getClass().getResource("/images/caniaPuntos.png"));
                    break;
            }
            if (icon != null) {
                img = icon.getImage();
                img = img.getScaledInstance(lblCanias.getWidth(), lblCanias.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(img);
                lblCanias.setIcon(icon);
            }
        }

        if (partida.getCuantasMueve() == 0) {
            ImageIcon icon = null;
            Image img = null;
            lblDado.setText("Tiro: " + partida.getCuantasMueve());
            icon = new ImageIcon(getClass().getResource("/images/caniaLisa.png"));
            img = icon.getImage();
            img = img.getScaledInstance(lblCanias.getWidth(), lblCanias.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            lblCanias.setIcon(icon);
        }

        System.out.println(partida);
        if (partida.getEstado() == EstadoPartida.ESPERA && jugador.getNumJugador() == 1 && partida.getJugadores().size() > 2) {
            btnComenzarPartida.setVisible(true);
        } else {
            btnComenzarPartida.setVisible(false);
        }

        if (partida.getJugadorTurno().equals(jugador) && partida.getEstado() != EstadoPartida.TERMINADA) {
            if (partida.getCantidadDado() == -1 || partida.repiteTurno()) {
                btnTirarCanias.setEnabled(true);
            }

            if (partida.getCuantasMueve() != 0 && !partida.getJugadorTurno().getColaFichas().isEmpty()) {
                btnAvanzarNormal.setEnabled(true);
                if (partida.getJugadorTurno().getNumFrijoles() >= partida.getValorApuesta()) {
                    btnPagarApuesta.setEnabled(true);
                }
            }

            if (partida.getJugadorTurno().puedeMeter()) {
                btnMeterFicha.setEnabled(true);
            } else if (partida.getJugadorTurno().getColaFichas().isEmpty() && !btnTirarCanias.isEnabled()) {
                try {
                    partida.setFichaMovimiento(null);
                    partida.setCantidadDado(-1);
                    partida.setCuantasMueve(0);
                    cliente.enviar(partida);

                } catch (IOException ex) {
                    Logger.getLogger(FrmTablero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (btnTirarCanias.isEnabled()) {
                btnMeterFicha.setEnabled(false);
                btnPagarApuesta.setEnabled(false);
                btnAvanzarNormal.setEnabled(false);
            }
        } else {
            btnPagarApuesta.setEnabled(false);
            btnTirarCanias.setEnabled(false);
            btnMeterFicha.setEnabled(false);
            btnPagarApuesta.setEnabled(false);
            btnAvanzarNormal.setEnabled(false);
        }

        if (partida.getJugadorTurno() != null) {
            lblNombreTurno.setText(partida.getJugadorTurno().getNombre());
            switch (partida.getJugadorTurno().getColor()) {
                case ROJO:
                    lblImgTurno.setIcon(new ImageIcon(getClass().getResource("/images/btn color rojo.png")));
                    break;
                case NARANJA:
                    lblImgTurno.setIcon(new ImageIcon(getClass().getResource("/images/btn color naranja.png")));
                    break;
                case AMARILLO:
                    lblImgTurno.setIcon(new ImageIcon(getClass().getResource("/images/btn color amarillo.png")));
                    break;
                case VERDE:
                    lblImgTurno.setIcon(new ImageIcon(getClass().getResource("/images/btn color verde.png")));
                    break;
                case CYAN:
                    lblImgTurno.setIcon(new ImageIcon(getClass().getResource("/images/btn color cyan.png")));
                    break;
                case AZUL:
                    lblImgTurno.setIcon(new ImageIcon(getClass().getResource("/images/btn color azul.png")));
                    break;
                case ROSA:
                    lblImgTurno.setIcon(new ImageIcon(getClass().getResource("/images/btn color rosa.png")));
                    break;
                case MORADO:
                    lblImgTurno.setIcon(new ImageIcon(getClass().getResource("/images/btn color morado.png")));
                    break;
            }
        }
        lblCanias.setBackground(new Color(0, 0, 0, 0));
        lblNombreJugador.setText(jugador.getNombre());

        if (partida.getEstado() == EstadoPartida.TERMINADA) {
            this.remove(cnvTablero);
            this.repaint();
            lblGanador.setText("La partida ha terminado");
            lblGanador.setVisible(true);
        }
    }

    /**
     * Evento para obtener la ficha que se clickeó en el tablero.
     *
     * @param e Evento del mouse.
     */
    private void cnvTableroClick(MouseEvent e) {
        if (partida.avanzaPagando() && partida.getJugadorTurno().equals(jugador)) {
            double x = e.getPoint().getX();
            double y = e.getPoint().getY();
            for (Casilla casilla : partida.getTablero().getCasillas()) {
                if (casilla.getFicha() != null && x >= casilla.getCoordenadaX() && x <= (casilla.getCoordenadaX() + 50) && y >= casilla.getCoordenadaY() && y <= (casilla.getCoordenadaY() + 50)) {
                    Ficha ficha = casilla.getFicha();
                    if (ficha.getJugador().equals(jugador)) {
                        try {
                            partida.setFichaMovimiento(ficha);
                            cliente.enviar(partida);
                        } catch (IOException ex) {
                            Logger.getLogger(FrmTablero.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                }
            }
        }
    }

    /**
     * Actualiza los datos del jugador de este cliente.
     */
    private void actualizaJugador() {
        for (Jugador jugadore : partida.getJugadores()) {
            if (jugadore.equals(jugador)) {
                jugador = jugadore;
                lblFichasGanadoras.setText("¡Llevas " + jugador.getFichasGanadoras().size() + " ficha(s)!");
                if (jugador.getNumFrijoles() > 0) {
                    lblNumFrijoles.setText("Te quedan " + jugador.getNumFrijoles() + " frijolito(s)");
                } else {
                    this.remove(cnvTablero);
                    lblGanador.setText("Has perdido :(");
                    lblGanador.setVisible(true);
                    lblNumFrijoles.setText("Te has quedado sin frijolitos :(");
                }

                if (!jugadore.getApuestas().isEmpty()) {
                    DefaultListModel lstModel = new DefaultListModel();
                    for (Apuesta apuesta : jugadore.getApuestas()) {
                        lstModel.addElement(apuesta);
                    }
                    lstApuestas.setModel(lstModel);
                }
            }
        }
    }
}
