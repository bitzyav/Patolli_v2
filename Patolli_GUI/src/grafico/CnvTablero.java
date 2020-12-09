/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import dominio.Casilla;
import dominio.CasillaCentro;
import dominio.CasillaPropia;
import dominio.CasillaSemicirculo;
import dominio.CasillaTriangulo;
import dominio.LugarSemicirculo;
import dominio.LugarTriangulo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Equipo2
 */
public final class CnvTablero extends JPanel {

    private LinkedList<Casilla> casillas;
    private int numCasillasAspa;
    private int ancho;
    private int alto;
    private int anchoPantalla;
    private Graphics2D g2d;

    public CnvTablero(LinkedList<Casilla> casillas, int numCasillasAspa, int anchoPantalla) {
        this.casillas = casillas;
        this.numCasillasAspa = numCasillasAspa;
        this.anchoPantalla=anchoPantalla/4;
        this.ancho = casillas.size() * 50 + 50 * 3;
        this.alto=ancho;
        inicializar();
        
        
    }
    
    private void inicializar() {
        this.setBackground(new Color(0,0,0,0));
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.g2d = (Graphics2D) g;
        for (Casilla casilla : casillas) {
            if(casilla.getClass().getName().contains("Centro")){
               (new GCasillaCentro(casilla, numCasillasAspa)).dibujar(g2d);
            }else if(casilla.getClass().getName().contains("Semicirculo")){
                (new GCasillaSemicirculo(casilla, numCasillasAspa)).dibujar(g2d);
            }else if(casilla.getClass().getName().contains("Triangulo")){
                (new GCasillaTriangulo(casilla, numCasillasAspa)).dibujar(g2d);
            }else if(casilla.getClass().getName().contains("Propia")){
                (new GCasillaPropia(casilla, numCasillasAspa)).dibujar(g2d);
            }else{
                (new GCasillaNormal(casilla, numCasillasAspa)).dibujar(g2d);
            }
        }
    }
    public void setCasillas(LinkedList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public LinkedList<Casilla> generarCasillas() {
        int tamanioCasilla=50;
        int casilla = 0;
        int x = anchoPantalla;
        int y = 0;

        if (numCasillasAspa % 2 == 0) {
            //Verticales arriba izquierda
            casillas.add(new CasillaSemicirculo(x, y, casilla, LugarSemicirculo.TOP));
            casilla++;
            y += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.TOP_LEFT_A));
            casilla++;
            y += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.TOP_LEFT_B));
            casilla++;
            y += tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa / 2) - 3; i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                y += tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x, y, casilla));
            casilla++;
            x -= tamanioCasilla;
            //Horizontal izquierda arriba
            casillas.add(new CasillaPropia(x, y, casilla));
            casilla++;
            x -= tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa / 2) - 4; i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                x -= tamanioCasilla;
            }
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.LEFT_TOP_A));
            casilla++;
            x -= tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.LEFT_TOP_B));
            casilla++;
            x -= tamanioCasilla;
            casillas.add(new CasillaSemicirculo(x, y, casilla, LugarSemicirculo.LEFT));
            casilla++;
            y += tamanioCasilla;
            //Horizontal izquierda abajo
            casillas.add(new CasillaSemicirculo(x, y, casilla, null));
            casilla++;
            x += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.LEFT_BOTTOM_A));
            casilla++;
            x += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.LEFT_BOTTOM_B));
            casilla++;
            x += tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa / 2) - 3; i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                x += tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x, y, casilla));
            casilla++;
            y += tamanioCasilla;

            //Vertical abajo izquierda
            casillas.add(new CasillaPropia(x, y, casilla));
            casilla++;
            y += tamanioCasilla;

            for (int i = 0; i < (numCasillasAspa / 2) - 4; i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                y += tamanioCasilla;
            }

            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.BOTTOM_LEFT_A));
            casilla++;
            y += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.BOTTOM_LEFT_B));
            casilla++;
            y += tamanioCasilla;

            casillas.add(new CasillaSemicirculo(x, y, casilla, LugarSemicirculo.BOTTOM));
            casilla++;
            x += tamanioCasilla;

            //Vertical abajo derecha
            casillas.add(new CasillaSemicirculo(x, y, casilla, null));
            casilla++;
            y -= tamanioCasilla;

            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.BOTTOM_RIGHT_A));
            casilla++;
            y -= tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.BOTTOM_RIGHT_B));
            casilla++;
            y -= tamanioCasilla;

            for (int i = 0; i < (numCasillasAspa / 2) - 3; i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                y -= tamanioCasilla;
            }

            casillas.add(new CasillaCentro(x, y, casilla));
            casilla++;
            x += tamanioCasilla;

            //Horizontal derecha abajo
            casillas.add(new CasillaPropia(x, y, casilla));
            casilla++;
            x += tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa / 2) - 4; i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                x += tamanioCasilla;
            }

            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.RIGHT_BOTTOM_A));
            casilla++;
            x += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.RIGHT_BOTTOM_B));
            casilla++;
            x += tamanioCasilla;

            casillas.add(new CasillaSemicirculo(x, y, casilla, null));
            casilla++;
            y -= tamanioCasilla;

            //Horizontal derecha arriba
            casillas.add(new CasillaSemicirculo(x, y, casilla, LugarSemicirculo.RIGHT));
            casilla++;
            x -= tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.RIGHT_TOP_A));
            casilla++;
            x -= tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.RIGHT_TOP_B));
            casilla++;
            x -= tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa / 2) - 3; i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                x -= tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x, y, casilla));
            casilla++;
            y -= tamanioCasilla;
            //Vertical arriba derecha
            casillas.add(new CasillaPropia(x, y, casilla));
            casilla++;
            y -= tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa / 2) - 4; i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                y -= tamanioCasilla;
            }
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.TOP_RIGHT_A));
            casilla++;
            y -= tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.TOP_RIGHT_B));
            casilla++;
            y -= tamanioCasilla;
            casillas.add(new CasillaSemicirculo(x, y, casilla, null));
        } else {
            //PARA NUM CASILLAS IMPARES

            //Verticales arriba izquierda
            casillas.add(new CasillaSemicirculo(x, y, casilla, LugarSemicirculo.TOP));
            casilla++;
            y += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.TOP_LEFT_A));
            casilla++;
            y += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.TOP_LEFT_B));
            casilla++;
            y += tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2) - 2); i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                y += tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x, y, casilla));
            casilla++;
            x -= tamanioCasilla;
            //Horizontal izquierda arriba
            casillas.add(new CasillaPropia(x, y, casilla));
            casilla++;
            x -= tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2) - 3); i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                x -= tamanioCasilla;
            }
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.LEFT_TOP_A));
            casilla++;
            x -= tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.LEFT_TOP_B));
            casilla++;
            x -= tamanioCasilla;
            casillas.add(new CasillaSemicirculo(x, y, casilla, LugarSemicirculo.LEFT));
            casilla++;
            y += tamanioCasilla;
            x += tamanioCasilla;
            //Horizontal izquierda abajo
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.LEFT_BOTTOM_A));
            casilla++;
            x += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.LEFT_BOTTOM_B));
            casilla++;
            x += tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2) - 2); i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                x += tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x, y, casilla));
            casilla++;
            y += tamanioCasilla;

            //Vertical abajo izquierda
            casillas.add(new CasillaPropia(x, y, casilla));
            casilla++;
            y += tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2) - 3); i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                y += tamanioCasilla;
            }

            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.BOTTOM_LEFT_A));
            casilla++;
            y += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.BOTTOM_LEFT_B));
            casilla++;
            y += tamanioCasilla;

            casillas.add(new CasillaSemicirculo(x, y, casilla, LugarSemicirculo.BOTTOM));
            casilla++;
            x += tamanioCasilla;
            y -= tamanioCasilla;
            //Vertical abajo derecha

            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.BOTTOM_RIGHT_A));
            casilla++;
            y -= tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.BOTTOM_RIGHT_B));
            casilla++;
            y -= tamanioCasilla;

            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2) - 2); i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                y -= tamanioCasilla;
            }

            casillas.add(new CasillaCentro(x, y, casilla));
            casilla++;
            x += tamanioCasilla;

            //Horizontal derecha abajo
            casillas.add(new CasillaPropia(x, y, casilla));
            casilla++;
            x += tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2) - 3); i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                x += tamanioCasilla;
            }

            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.RIGHT_BOTTOM_A));
            casilla++;
            x += tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.RIGHT_BOTTOM_B));
            casilla++;
            x += tamanioCasilla;

            casillas.add(new CasillaSemicirculo(x, y, casilla, LugarSemicirculo.RIGHT));
            casilla++;
            x -= tamanioCasilla;
            y -= tamanioCasilla;

            //Horizontal derecha arriba
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.RIGHT_TOP_A));
            casilla++;
            x -= tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.RIGHT_TOP_B));
            casilla++;
            x -= tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2) - 2); i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                x -= tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x, y, casilla));
            casilla++;
            y -= tamanioCasilla;
            //Vertical arriba derecha
            casillas.add(new CasillaPropia(x, y, casilla));
            casilla++;
            y -= tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2) - 3); i++) {
                casillas.add(new Casilla(x, y, casilla));
                casilla++;
                y -= tamanioCasilla;
            }
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.TOP_RIGHT_A));
            casilla++;
            y -= tamanioCasilla;
            casillas.add(new CasillaTriangulo(x, y, casilla, LugarTriangulo.TOP_RIGHT_B));
        }
        return casillas;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}
