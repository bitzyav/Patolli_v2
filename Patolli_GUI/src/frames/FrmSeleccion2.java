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
public class FrmSeleccion2 extends FrmClienteAux{

    private static FrmTablero frmTablero;
    /**
     * Creates new form FrmSeleccion
     */
    public FrmSeleccion2(SocketCliente cliente, Jugador jugador, Partida partida) { 
        super(cliente,jugador,partida);
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

        txtNombre = new javax.swing.JTextField();
        lblCampoNombre = new javax.swing.JLabel();
        btnColorVerde = new javax.swing.JLabel();
        btnColorCyan = new javax.swing.JLabel();
        btnColorNaranja = new javax.swing.JLabel();
        btnColorAzul = new javax.swing.JLabel();
        btnColorAmarillo = new javax.swing.JLabel();
        btnColorRosa = new javax.swing.JLabel();
        btnColorMorado = new javax.swing.JLabel();
        btnColorRojo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(243, 242, 237));
        txtNombre.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(139, 89, 10));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setText("...");
        txtNombre.setBorder(null);
        txtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNombre.setOpaque(false);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 220, 30));

        lblCampoNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/campo texto gr.png"))); // NOI18N
        getContentPane().add(lblCampoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        btnColorVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn color verde.png"))); // NOI18N
        btnColorVerde.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(btnColorVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, -1, -1));

        btnColorCyan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn color cyan.png"))); // NOI18N
        btnColorCyan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(btnColorCyan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        btnColorNaranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn color naranja.png"))); // NOI18N
        btnColorNaranja.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(btnColorNaranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        btnColorAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn color azul.png"))); // NOI18N
        btnColorAzul.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(btnColorAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 70, -1));

        btnColorAmarillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn color amarillo.png"))); // NOI18N
        btnColorAmarillo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(btnColorAmarillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, -1));

        btnColorRosa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn color rosa.png"))); // NOI18N
        btnColorRosa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(btnColorRosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        btnColorMorado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn color morado.png"))); // NOI18N
        btnColorMorado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(btnColorMorado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, -1, -1));

        btnColorRojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn color rojo.png"))); // NOI18N
        btnColorRojo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(btnColorRojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

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
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, -1, -1));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn aceptar.png"))); // NOI18N
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/frm seleccion.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento que cambia la imagen del boton cuando el cursor esta sobre él.
     * @param evt 
     */
    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        btnAceptar.setIcon(new ImageIcon("images\\btn aceptar 2.png"));
    }//GEN-LAST:event_btnAceptarMouseEntered

    /**
     * Evento que cambia la imagen del boton cuando el cursor no esta sobre él.
     * @param evt 
     */
    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setIcon(new ImageIcon("images\\btn aceptar.png"));
    }//GEN-LAST:event_btnAceptarMouseExited

    /**
     * Evento que cambia la imagen del boton cuando el cursor esta sobre él.
     * @param evt 
     */
    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setIcon(new ImageIcon("images\\btn cancelar 2.png"));
    }//GEN-LAST:event_btnCancelarMouseEntered

    /**
     * Evento que cambia la imagen del boton cuando el cursor no esta sobre él.
     * @param evt 
     */
    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setIcon(new ImageIcon("images\\btn cancelar.png"));
    }//GEN-LAST:event_btnCancelarMouseExited

    /**
     * Cambia de ventana al frame de inicio.
     * @param evt 
     */
    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.setVisible(false);
        this.getInstanciaFrmInicio().setVisible(true);
    }//GEN-LAST:event_btnCancelarMouseClicked

    /**
     * Cambia de ventana al tablero.
     * @param evt 
     */
    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        this.setVisible(false);
        getFrmTablero().setVisible(true);
    }//GEN-LAST:event_btnAceptarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAceptar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnColorAmarillo;
    private javax.swing.JLabel btnColorAzul;
    private javax.swing.JLabel btnColorCyan;
    private javax.swing.JLabel btnColorMorado;
    private javax.swing.JLabel btnColorNaranja;
    private javax.swing.JLabel btnColorRojo;
    private javax.swing.JLabel btnColorRosa;
    private javax.swing.JLabel btnColorVerde;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblCampoNombre;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {
        adaptarPantalla();
        this.setBackground(new Color(0,0,0,0));
    }

    public static FrmTablero getFrmTablero() {
        if(frmTablero==null){
            frmTablero=new FrmTablero();
        }
        return frmTablero;
    }

    @Override
    public void update(Partida partidaLlegada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
