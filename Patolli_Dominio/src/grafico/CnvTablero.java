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

/**
 *
 * @author Equipo2
 */
public class CnvTablero extends Canvas {

    /**
     * Atributo para el número de casillas que va a tener el tablero.
     */
    private final int numCasillas;
    private int ancho;
    private int alto;
    private int anchoCasilla;
    private int altoCasilla;
    private float cx, cy; //Coordenada X y Y del tablero. es float por los tableros con casillas impares.
    private Casilla[] casillas;
    Graphics2D g2d;

    /**
     * Constructor que inicializa el tablero según el número de casillas
     * introducidas.
     *
     * @param numCasillas El número de casillas en diámetro que tendrá el
     * tablero.
     * @param anchoCasilla El ancho de las casillas a utilizar.
     * @param altoCasilla El alto de las casillas a utilizar.
     */
    public CnvTablero(int numCasillas, int anchoCasilla, int altoCasilla, Casilla[] casillas) {
        this.numCasillas = numCasillas;
        this.anchoCasilla = anchoCasilla;
        this.altoCasilla = altoCasilla;
        this.ancho = this.numCasillas * anchoCasilla + anchoCasilla * 3;
        this.alto = this.numCasillas * altoCasilla + altoCasilla * 3;
        this.casillas = casillas;
    }

    /**
     * Método estético para el tablero
     *
     * @param g Componente Graphics2D
     */
    @Override
    public void paint(Graphics g) {
        this.g2d = (Graphics2D) g;
        Integer index = 0;
        g2d.setColor(Color.BLACK);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(4));
        int y = 0, ancho = anchoCasilla, alto = altoCasilla;
        int x = this.getBounds().width / 2 - ancho;
        dibujaVertical(x, y, ancho, alto, this.numCasillas, g2d, index);
        if (this.numCasillas % 2 != 0) {
            y = ((Math.floorDiv(this.numCasillas, 2) + 1) * alto);
            x = (this.getBounds().width / 2) - ((Math.floorDiv(this.numCasillas, 2) * ancho)) - 2 * ancho;
        } else {
            y = (Math.floorDiv(this.numCasillas, 2) * alto);
            x = (this.getBounds().width / 2) - ((Math.floorDiv(this.numCasillas, 2) * ancho)) - ancho;
        }
        dibujaHorizontal(x, y, ancho, alto, this.numCasillas, g2d, index);
    }

    /**
     * Para crear una línea de casillas horizontal
     *
     * @param x Horizontal
     * @param y Vertical
     * @param ancho La anchura de las casillas
     * @param alto La altura de las casillas
     * @param cuantos Las repeticiones
     * @param g Componente Graphics2D
     */
    void dibujaHorizontal(int x, int y, int ancho, int alto, int cuantos, Graphics2D g, Integer index) {
        Rectangle rect = new Rectangle();
        cuantos += 2;
        if (this.numCasillas % 2 == 0) {
            Shape punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 90, 180, Arc2D.OPEN);
            g.draw(punta);
            g.drawLine(x, y + alto, x + ancho, y + alto);
            casillas[index] = new CasillaSemicirculo(x, y);
            index++;
            x += ancho;
            for (int i = 0; i < cuantos - 2; i++) {
                rect.setBounds(x, y, ancho, alto);
                g.draw(rect);
                if(i==((cuantos/2)-3)){
                    g.setColor(Color.YELLOW);
                    g.fill(rect);
                    casillas[index]=new CasillaPropia(x,y);
                    index++;
                    g.setColor(Color.BLACK);
                }else if (i == (cuantos - 3) || i == 1) {
                    Polygon triangulo = new Polygon(new int[]{x - (ancho / 2), x, x + (ancho / 2)}, new int[]{y, y + alto, y}, 3);
                    g.fill(triangulo);
                    g.drawPolygon(triangulo);
                    casillas[index] = new CasillaTriangulo(x, y);
                    index++;
                    triangulo = new Polygon(new int[]{x - (ancho / 2), x, x + (ancho / 2)}, new int[]{y + (alto * 2), y + alto, y + (alto * 2)}, 3);
                    g.fill(triangulo);
                    g.drawPolygon(triangulo);
                    casillas[index] = new CasillaTriangulo(x + ancho, y);
                    index++;
                } else {
                    casillas[index] = new Casilla(x, y);
                    index++;
                }

                rect.setBounds(x, y + alto, ancho, alto);
                if(i==(cuantos/2)){
                    g.setColor(Color.YELLOW);
                    g.fill(rect);
                    casillas[index]=new CasillaPropia(x,y);
                    index++;
                    g.setColor(Color.BLACK);
                }
                g.draw(rect);
                x += ancho;

            }
            x -= ancho;
            punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 270, 180, Arc2D.OPEN);
            g.draw(punta);
            casillas[index] = new CasillaSemicirculo(x, y);
            index++;
            x += ancho;
            g.drawLine(x, y + alto, x + ancho, y + alto);
        } else {
            Shape punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 90, 180, Arc2D.OPEN);
            g.draw(punta);
            x += ancho;
            for (int i = 0; i < cuantos - 1; i++) {
                rect.setBounds(x, y, ancho, alto);
                g.draw(rect);
                if(i==(cuantos/2-2)){
                    g.setColor(Color.YELLOW);
                    g.fill(rect);
                    casillas[index]=new CasillaPropia(x,y);
                    index++;
                    g.setColor(Color.BLACK);
                }else if (i == (cuantos - 2) || i == 1) {
                    Polygon triangulo = new Polygon(new int[]{x - (ancho / 2), x, x + (ancho / 2)}, new int[]{y, y + alto, y}, 3);
                    g.fill(triangulo);
                    g.drawPolygon(triangulo);
                    casillas[index] = new CasillaTriangulo(x, y);
                    index++;
                    triangulo = new Polygon(new int[]{x - (ancho / 2), x, x + (ancho / 2)}, new int[]{y + (alto * 2), y + alto, y + (alto * 2)}, 3);
                    g.fill(triangulo);
                    g.drawPolygon(triangulo);
                    casillas[index] = new CasillaTriangulo(x + ancho, y);
                    index++;
                } else {
                    casillas[index] = new Casilla(x, y);
                    index++;
                }
                rect.setBounds(x, y + alto, ancho, alto);
                if(i==(cuantos/2+1)){
                    g.setColor(Color.YELLOW);
                    g.fill(rect);
                    casillas[index]=new CasillaPropia(x,y);
                    index++;
                    g.setColor(Color.BLACK);
                }
                g.draw(rect);

                x += ancho;
            }
            x -= ancho;
            punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 270, 180, Arc2D.OPEN);
            g.draw(punta);
            casillas[index] = new CasillaSemicirculo(x, y);
            index++;
        }
    }

    /**
     * Para crear una línea de casillas vertical
     *
     * @param x Horizontal
     * @param y Vertical
     * @param ancho La anchura de las casillas
     * @param alto La altura de las casillas
     * @param cuantos Las repeticiones
     * @param g Componente Graphics2D
     */
    void dibujaVertical(int x, int y, int ancho, int alto, int cuantos, Graphics2D g, Integer index) {
        Rectangle rect = new Rectangle();
        cuantos += 2;

        if (this.numCasillas % 2 == 0) {
            Shape punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 0, 180, Arc2D.OPEN);
            g.draw(punta);
            g.drawLine(x + ancho, y, x + ancho, y + alto);
            casillas[index] = new CasillaSemicirculo(x, y);
            index++;
            y += alto;
            for (int i = 0; i < cuantos - 2; i++) {
                rect.setBounds(x, y, ancho, alto);
                g.draw(rect);
                if(i==(cuantos/2)){
                    g.setColor(Color.YELLOW);
                    g.fill(rect);
                    casillas[index]=new CasillaPropia(x,y);
                    index++;
                    g.setColor(Color.BLACK);
                }else if (i == (cuantos - 3) || i == 1) {
                    Polygon triangulo = new Polygon(new int[]{x + (ancho * 2), x + ancho, x + (ancho * 2)}, new int[]{y - (alto / 2), y, y + (alto / 2)}, 3);
                    g.fill(triangulo);
                    g.drawPolygon(triangulo);
                    casillas[index] = new CasillaTriangulo(x, y);
                    index++;
                    triangulo = new Polygon(new int[]{x, x + ancho, x}, new int[]{y - (alto / 2), y, y + (alto / 2)}, 3);

                    g.fill(triangulo);
                    g.drawPolygon(triangulo);
                    casillas[index] = new CasillaTriangulo(x, y + alto);
                    index++;
                } else {
                    casillas[index] = new Casilla(x, y);
                    index++;
                }
                
                rect.setBounds(x + ancho, y, ancho, alto);
                if(i==((cuantos/2)-3)){
                    g.setColor(Color.YELLOW);
                    g.fill(rect);
                    casillas[index]=new CasillaPropia(x,y);
                    index++;
                    g.setColor(Color.BLACK);
                }
                g.draw(rect);
                y += alto;
            }
            y -= alto;
            punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 180, 180, Arc2D.OPEN);
            casillas[index] = new CasillaSemicirculo(x, y);
            index++;
            g.draw(punta);
            y += alto;
            g.drawLine(x + ancho, y, x + ancho, y + alto);
        } else {
            Shape punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 0, 180, Arc2D.OPEN);
            g.draw(punta);
            casillas[index] = new CasillaSemicirculo(x, y);
            index++;
            y += alto;
            
            for (int i = 0; i < cuantos - 1; i++) {
                rect.setBounds(x, y, ancho, alto);
                g.draw(rect);
                if(i==(cuantos/2+1)){
                    g.setColor(Color.YELLOW);
                    g.fill(rect);
                    casillas[index]=new CasillaPropia(x,y);
                    index++;
                    g.setColor(Color.BLACK);
                }else if (i == (cuantos - 2) || i == 1) {
                    Polygon triangulo = new Polygon(new int[]{x + (ancho * 2), x + ancho, x + (ancho * 2)}, new int[]{y - (alto / 2), y, y + (alto / 2)}, 3);
                    g.fill(triangulo);
                    g.drawPolygon(triangulo);
                    casillas[index] = new CasillaTriangulo(x, y);
                    index++;
                    triangulo = new Polygon(new int[]{x, x + ancho, x}, new int[]{y - (alto / 2), y, y + (alto / 2)}, 3);

                    g.fill(triangulo);
                    g.drawPolygon(triangulo);
                    casillas[index] = new CasillaTriangulo(x, y + alto);
                    index++;
                } else {
                    casillas[index] = new Casilla(x, y);
                    index++;
                }
                rect.setBounds(x + ancho, y, ancho, alto);
                if(i==((cuantos/2)-2)){
                    g.setColor(Color.YELLOW);
                    g.fill(rect);
                    casillas[index]=new CasillaPropia(x,y);
                    index++;
                    g.setColor(Color.BLACK);
                }
                g.draw(rect);
                y += alto;
            }
            y -= alto;
            punta = new Arc2D.Double(x, y, ancho * 2, alto * 2, 180, 180, Arc2D.OPEN);
            casillas[index] = new CasillaSemicirculo(x, y);
            index++;
            g.draw(punta);
        }
    }

    public int getAncho() {

        return ancho;
    }

    public int getAlto() {

        return alto;
    }

    public void dibujarFicha(Ficha ficha, Casilla casilla) {
        /*this.cy = 0;

        /*if (numCasillas == 8 || numCasillas == 9) {
            cx = numCasillas - 3;
        } else if (numCasillas == 10 || numCasillas == 11) {
            cx = numCasillas - 4;
        } else if (numCasillas == 12 || numCasillas == 13) {
            cx = numCasillas - 5;
        } else if (numCasillas == 14) {
            cx = numCasillas - 6;
        }*/

        g2d.setStroke(new BasicStroke(1));
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
        Ellipse2D.Double ellipseFicha = new Ellipse2D.Double(Double.parseDouble(String.valueOf(casilla.getCoordenadaX())),
                Double.parseDouble(String.valueOf(casilla.getCoordenadaY())),
                Double.parseDouble(String.valueOf(casilla.getCoordenadaX() + ancho)),
                Double.parseDouble(String.valueOf(casilla.getCoordenadaY() + alto)));
        g2d.fill(ellipseFicha);
        g2d.setColor(Color.blue);
        g2d.draw(ellipseFicha);
    }
}
