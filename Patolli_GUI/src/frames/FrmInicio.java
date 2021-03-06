/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.ImageIcon;

/**
 *
 * @author Itzel
 */
public class FrmInicio extends FrmBase {
    private static FrmDireccPartida frmDirecc;
    
    /**
     * Creates new form FrmInicio
     */
    public FrmInicio() {
        initComponents();
        inicializar();
    }

    /**
     * Inicializa la pantalla.
     */
    private void inicializar(){
        adaptarPantalla();
//        this.setBackground(new Color(0,0,0,0));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear = new javax.swing.JLabel();
        btnUnirse = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn crear.png"))); // NOI18N
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearMouseExited(evt);
            }
        });
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

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
        getContentPane().add(btnUnirse, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

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
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/frm inicio.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -20, 820, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la aplicación.
     * @param evt
     */
    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    /**
     * Evento que cambia la imagen del boton cuando el cursor esta sobre él.
     * @param evt
     */
    private void btnCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseEntered
        btnCrear.setIcon(new ImageIcon("images\\btn crear 2.png"));
    }//GEN-LAST:event_btnCrearMouseEntered

    /**
     * Evento que cambia la imagen del boton cuando el cursor no esta sobre él.
     * @param evt
     */
    private void btnCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseExited
        btnCrear.setIcon(new ImageIcon("images\\btn crear.png"));
    }//GEN-LAST:event_btnCrearMouseExited

    /**
     * Cambia de ventana al frame para configurar partida.
     * @param evt
     */
    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
        this.setVisible(false);
        getFrmDirecc().setVisible(true);
    }//GEN-LAST:event_btnCrearMouseClicked

    /**
     * Evento que cambia la imagen del boton cuando el cursor esta sobre él.
     * @param evt
     */
    private void btnUnirseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnirseMouseEntered
        btnUnirse.setIcon(new ImageIcon("images\\btn unirse 2.png"));
    }//GEN-LAST:event_btnUnirseMouseEntered

    /**
     * Evento que cambia la imagen del boton cuando el cursor no esta sobre él.
     * @param evt
     */
    private void btnUnirseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnirseMouseExited
        btnUnirse.setIcon(new ImageIcon("images\\btn unirse.png"));
    }//GEN-LAST:event_btnUnirseMouseExited

    /**
     * Cambia de ventana al frame de direccion partida para unirse a partida.
     * @param evt
     */
    private void btnUnirseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnirseMouseClicked
        this.setVisible(false);
        getFrmDirecc().setVisible(true);
    }//GEN-LAST:event_btnUnirseMouseClicked

    /**
     * Evento que cambia la imagen del boton cuando el cursor esta sobre él.
     * @param evt
     */
    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setIcon(new ImageIcon("images\\btn salir 2.png"));
    }//GEN-LAST:event_btnSalirMouseEntered

    /**
     * Evento que cambia la imagen del boton cuando el cursor no esta sobre él.
     * @param evt
     */
    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setIcon(new ImageIcon("images\\btn salir.png"));
    }//GEN-LAST:event_btnSalirMouseExited

    /**
     * Método de singleton para obtener la instancia de FrmDirecc
     * @return Instancia de FrmDirecc
     */
    public static FrmDireccPartida getFrmDirecc() {
        if(frmDirecc==null){
            frmDirecc=new FrmDireccPartida();
        }
        return frmDirecc;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCrear;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel btnUnirse;
    private javax.swing.JLabel fondo;
    // End of variables declaration//GEN-END:variables
}
