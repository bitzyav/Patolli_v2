/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dominio.Huesped;
import dominio.Partida;
import static frames.FrmClienteAux.cliente;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import socketCliente.SocketCliente;

/**
 *
 * @author Invitado
 */
public class FrmDireccPartida extends FrmClienteAux {

    private static FrmConfigurarPartida frmConfig;
    private static FrmSeleccion frmSeleccion;

    /**
     * Creates new form FrmDireccPartida
     */
    public FrmDireccPartida() {
        initComponents();
        inicializar();
    }

    private void inicializar() {
        adaptarPantalla();
        this.setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUnirse = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblCampoCodigo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnUnirse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn unirse.png"))); // NOI18N
        btnUnirse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn cancelar.png"))); // NOI18N
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });

        txtDireccion.setBackground(new java.awt.Color(243, 242, 237));
        txtDireccion.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(139, 89, 10));
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccion.setText("127.0.0.1");
        txtDireccion.setBorder(null);
        txtDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtDireccion.setOpaque(false);

        lblCampoCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/campo texto gr.png"))); // NOI18N

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/frm direcc ip.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(btnUnirse)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(450, 450, 450)
                            .addComponent(btnCancelar))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(270, 270, 270)
                            .addComponent(lblCampoCodigo))
                        .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnUnirse)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(240, 240, 240)
                            .addComponent(btnCancelar))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(lblCampoCodigo))
                        .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUnirseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnirseMouseClicked
        try {

            if (jugador == null) {
                cliente = new SocketCliente(txtDireccion.getText());
                cliente.setObserver(this);
                new Thread(cliente).start();
            }
            //JOptionPane.showMessageDialog(this, );
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnUnirseMouseClicked

    private void btnUnirseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnirseMouseEntered
        btnUnirse.setIcon(new ImageIcon("images\\btn unirse 2.png"));
    }//GEN-LAST:event_btnUnirseMouseEntered

    private void btnUnirseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnirseMouseExited
        btnUnirse.setIcon(new ImageIcon("images\\btn unirse.png"));
    }//GEN-LAST:event_btnUnirseMouseExited

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.setVisible(false);
        this.getInstanciaFrmInicio().setVisible(true);
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setIcon(new ImageIcon("images\\btn cancelar 2.png"));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setIcon(new ImageIcon("images\\btn cancelar.png"));
    }//GEN-LAST:event_btnCancelarMouseExited

    @Override
    public void update(Partida partidaLlegada) {
        try {
            partida = partidaLlegada;
            if (partida != null) {
                if (!getFrmConfig().isVisible() && !getFrmSeleccion().isVisible()) {
                    switch (partida.getEstado()) {
                        case CONFIGURACION:
                            if (!partida.getJugadores().get(0).isAsignado()) {
                                jugador = partida.getJugadores().get(0);
                                jugador.setAsignado(true);
                                partida.getJugadores().set(0, jugador);
                                cliente.setObserver(getFrmConfig());
                                getFrmConfig().setVisible(true);
                                cliente.enviar(partida);
                                this.setVisible(false);
                                this.dispose();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "La partida está siendo configurada.");
                            }
                            break;
                        case ESPERA:
                            jugador = new Huesped();
                            jugador.setNumJugador((byte) (partida.getJugadores().size() + 1));
                            this.setVisible(false);
                            this.dispose();
                            getFrmSeleccion().setVisible(true);
                            break;
                        case INICIADA:
                            JOptionPane.showMessageDialog(rootPane, "La partida está llena o ya ha comenzado.");
                            break;
                        default:
                            break;
                    }
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ocurrió un error desconocido.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static FrmConfigurarPartida getFrmConfig() {
        if (frmConfig == null) {
            frmConfig = new FrmConfigurarPartida(cliente, jugador, partida);
        }
        return frmConfig;
    }

    public static FrmSeleccion getFrmSeleccion() {
        if (frmSeleccion == null) {
            frmSeleccion = new FrmSeleccion(cliente, jugador, partida);
        }
        return frmSeleccion;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnUnirse;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblCampoCodigo;
    private javax.swing.JTextField txtDireccion;
    // End of variables declaration//GEN-END:variables
}
