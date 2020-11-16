/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import dominio.Casilla;
import dominio.CasillaPropia;
import dominio.CasillaSemicirculo;
import dominio.CasillaTriangulo;
import dominio.Ficha;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

/**
 *
 * @author Equipo2
 */
public class CnvTablero extends Canvas {

    private LinkedList<Casilla> casillas;
    private int numCasillasAspa;
    private int tamanioCasilla;
    private int ancho;
    private int alto;
    Graphics2D g2d;

    public CnvTablero(LinkedList<Casilla> casillas, int tamanioCasilla, int numCasillasAspa) {
        this.casillas = casillas;
        this.tamanioCasilla = tamanioCasilla;
        this.ancho = casillas.size() * tamanioCasilla + tamanioCasilla * 3;
        this.alto = ancho;
        this.numCasillasAspa = numCasillasAspa;
    }

    /**
     * Método estético para el tablero
     *
     * @param g Componente Graphics2D
     */
    @Override
    public void paint(Graphics g) {
        this.g2d = (Graphics2D) g;
        byte numTriangulo = 1;
        byte numSemicirculo = 1;

        g2d.setStroke(new BasicStroke(2));
        Rectangle rect = new Rectangle();
        g2d.setColor(Color.BLACK);
        for (Casilla casilla : casillas) {
            int x = casilla.getCoordenadaX(), y = casilla.getCoordenadaY();
            int ancho = tamanioCasilla, alto = tamanioCasilla;
            rect.setBounds(casilla.getCoordenadaX(), casilla.getCoordenadaY(), tamanioCasilla, tamanioCasilla);

            if (casilla.getClass().getName().contains("Triangulo")) {
                Polygon triangulo = null;
                g2d.setColor(Color.RED);

                switch (numTriangulo) {
                    case 2:
                        triangulo = new Polygon(new int[]{x, x + ancho, x}, new int[]{y - (alto / 2), y, y + (alto / 2)}, 3);
                        break;
                    case 3:
                        triangulo = new Polygon(new int[]{x - (ancho / 2), x, x + (ancho / 2)}, new int[]{y, y + alto, y}, 3);
                        break;
                    case 6:
                        triangulo = new Polygon(new int[]{x - (ancho / 2), x, x + (ancho / 2)}, new int[]{y + alto, y, y + (alto)}, 3);
                        break;
                    case 8:
                        triangulo = new Polygon(new int[]{x, x + ancho, x}, new int[]{y - (alto / 2), y, y + (alto / 2)}, 3);
                        break;
                    case 9:
                        triangulo = new Polygon(new int[]{x + ancho, x, x + ancho}, new int[]{y - (alto / 2), y, y + (alto / 2)}, 3);
                        break;
                    case 12:
                        triangulo = new Polygon(new int[]{x - (ancho / 2), x, x + (ancho / 2)}, new int[]{y + (alto), y, y + (alto)}, 3);
                        break;
                    case 13:
                        triangulo = new Polygon(new int[]{x - (ancho / 2), x, x + (ancho / 2)}, new int[]{y, y + alto, y}, 3);
                        break;
                    case 15:
                        triangulo = new Polygon(new int[]{x + (ancho), x, x + (ancho)}, new int[]{y - (alto / 2), y, y + (alto / 2)}, 3);
                        break;
                }

                if (triangulo != null) {
                    g2d.fill(triangulo);
                    g2d.drawPolygon(triangulo);
                }
                numTriangulo++;
            } else if (casilla.getClass().getName().contains("Propia")) {
                g2d.setColor(Color.ORANGE);
                g2d.fill(rect);
            } else if (casilla.getClass().getName().contains("Centro")) {
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.fill(rect);
            }
            if (casilla.getClass().getName().contains("Semicirculo")) {
                Shape punta = null;
                if (this.numCasillasAspa % 2 == 0) {
                    switch (numSemicirculo) {
                        case 1:
                            punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 0, 180, Arc2D.OPEN);
                            g.drawLine(x + ancho, y, x + ancho, y + alto);

                            break;
                        case 2:
                            punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 90, 180, Arc2D.OPEN);
                            g.drawLine(x, y + alto, x + ancho, y + alto);

                            break;
                        case 4:
                            punta = new Arc2D.Double(x, y - alto, ancho * 2, alto * 2, 180, 180, Arc2D.OPEN);
                            g.drawLine(x + ancho, y, x + ancho, y + alto);
                            break;
                        case 7:
                            punta = new Arc2D.Double(x - ancho, y, ancho * 2, alto * 2, 270, 180, Arc2D.OPEN);
                            g.drawLine(x, y + alto, x + ancho, y + alto);
                            break;
                    }
                } else {
                    switch (numSemicirculo) {
                        case 1:
                            punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 0, 180, Arc2D.OPEN);
                            break;
                        case 2:
                            punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 90, 180, Arc2D.OPEN);
                            break;
                        case 3:
                            punta = new Arc2D.Double(x, y - alto, ancho * 2, alto * 2, 180, 180, Arc2D.OPEN);
                            break;
                        case 4:
                            punta = new Arc2D.Double(x - ancho, y - alto, ancho * 2, alto * 2, 270, 180, Arc2D.OPEN);
                            break;
                    }
                }
                if (punta != null) {
                    g2d.setColor(Color.BLACK);
                    g2d.draw(punta);
                }
                numSemicirculo++;
            } else {
                g2d.setColor(Color.BLACK);
                g2d.draw(rect);
            }
            if (casilla.getFicha() != null) {
                dibujarFicha(casilla.getFicha(), casilla);
            }
        }
    }

    public int getAncho() {

        return ancho;
    }

    public int getAlto() {

        return alto;
    }

    public void dibujarFicha(Ficha ficha, Casilla casilla) {
        switch (ficha.getJugador().getColor()) {
            case ROJO:
                g2d.setColor(Color.RED);
                break;
            case NARANJA:
                g2d.setColor(Color.ORANGE);
                break;
            case AMARILLO:
                g2d.setColor(Color.YELLOW);
                break;
            case VERDE:
                g2d.setColor(Color.GREEN);
                break;
            case CYAN:
                g2d.setColor(Color.CYAN);
                break;
            case AZUL:
                g2d.setColor(Color.BLUE);
                break;
            case MORADO:
                g2d.setColor(Color.MAGENTA);
                break;
            case ROSA:
                g2d.setColor(Color.PINK);
                break;
        }
        double x = Double.parseDouble(String.valueOf(casilla.getCoordenadaX()));
        double y = Double.parseDouble(String.valueOf(casilla.getCoordenadaY()));
        double w = Double.parseDouble(String.valueOf(tamanioCasilla));
        double h = Double.parseDouble(String.valueOf(tamanioCasilla));
        //Ellipse2D.Double ellipseFicha = new Ellipse2D.Double(x,y,w,h);
        Ellipse2D.Double ellipseFicha = new Ellipse2D.Double(x, y, w, h);
        g2d.fill(ellipseFicha);
        g2d.setColor(Color.blue);
        g2d.draw(ellipseFicha);
    }
}
