/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import java.awt.Graphics2D;

/**
 *
 * @author alfonsofelix
 */
abstract class ElementoGrafico {
    protected final int ANCHO=50;
    protected final int ALTO=50;
    public abstract void dibujar(Graphics2D g2d);
}
