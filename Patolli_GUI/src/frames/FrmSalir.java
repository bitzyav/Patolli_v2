/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dominio.Jugador;
import dominio.Partida;
import java.awt.Color;
import javax.swing.ImageIcon;
import socketCliente.SocketCliente;

/**
 *
 * @author Itzel
 */
public class FrmSalir extends FrmClienteAux {

    private boolean salir;

    /**
     * Construye la instancia de la clase, inicializando los siguientes valores:
     *
     * @param clienteN Instancia de SocketCliente.
     * @param jugadorN Instancia del jugador de este cliente.
     * @param partidaN Instancia de la partida que se recibe del servidor.
     */
    public FrmSalir(SocketCliente clienteN, Jugador jugadorN, Partida partidaN) {
        super(clienteN, jugadorN, partidaN);
        initComponents();
        inicializar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn salir.png"))); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/frm salir.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 0, 740, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento que cambia la imagen del boton cuando el cursor esta sobre él.
     *
     * @param evt
     */
    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setIcon(new ImageIcon("images\\btn salir 2.png"));
    }//GEN-LAST:event_btnSalirMouseEntered

    /**
     * Evento que cambia la imagen del boton cuando el cursor no esta sobre él.
     *
     * @param evt
     */
    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setIcon(new ImageIcon("images\\btn salir.png"));
    }//GEN-LAST:event_btnSalirMouseExited

    /**
     * Evento que cambia la imagen del boton cuando el cursor esta sobre él.
     *
     * @param evt
     */
    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setIcon(new ImageIcon("images\\btn cancelar 2.png"));
    }//GEN-LAST:event_btnCancelarMouseEntered

    /**
     * Evento que cambia la imagen del boton cuando el cursor no esta sobre él.
     *
     * @param evt
     */
    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setIcon(new ImageIcon("images\\btn cancelar.png"));
    }//GEN-LAST:event_btnCancelarMouseExited

    /**
     * Cambia de ventana al frame de inicio.
     *
     * @param evt
     */
    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        try {
            partida.setJugadorTurno(jugador);
            partida.setSaliendo(true);
            salir = true;
            cliente.enviar(partida);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnSalirMouseClicked

    /**
     * Hace invisible este frame y se queda en el inicio.
     *
     * @param evt
     */
    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel fondo;
    // End of variables declaration//GEN-END:variables

    /**
     * Inicializa la pantalla.
     */
    private void inicializar() {
        adaptarPantalla();
    }

    /**
     * Método para ser notificado por el observado.
     *
     * @param partidaLlegada Instancia de la partida actual.
     */
    @Override
    public void update(Partida partidaLlegada) {
        if (salir) {
            System.exit(0);
        }
    }
}
