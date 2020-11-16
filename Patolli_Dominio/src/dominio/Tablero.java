/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.LinkedList;

/**
 *
 * @author alfonsofelix
 */
public class Tablero {

    private LinkedList<Casilla> casillas;

    public Tablero() {
        casillas = new LinkedList<>();
    }

    public LinkedList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(LinkedList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public void generarCasillas(int numCasillasAspa, int anchoPantalla, int tamanioCasilla) {
        int casilla=0;
        int x=anchoPantalla/2;
        int y=0;
        
        if (numCasillasAspa % 2 == 0) {
            //Verticales arriba izquierda
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa/2)-3; i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                y+=tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            //Horizontal izquierda arriba
            casillas.add(new CasillaPropia(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa/2)-4; i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                x-=tamanioCasilla;
            }
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            //Horizontal izquierda abajo
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa/2)-3; i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                x+=tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            
            //Vertical abajo izquierda
            casillas.add(new CasillaPropia(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            
            for (int i = 0; i < (numCasillasAspa/2)-4; i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                y+=tamanioCasilla;
            }
            
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            
            //Vertical abajo derecha
            
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            
            for (int i = 0; i < (numCasillasAspa/2)-3; i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                y-=tamanioCasilla;
            }
            
            casillas.add(new CasillaCentro(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            
            //Horizontal derecha abajo
            casillas.add(new CasillaPropia(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa/2)-4; i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                x+=tamanioCasilla;
            }
            
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            
            //Horizontal derecha arriba
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa/2)-3; i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                x-=tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            //Vertical arriba derecha
            casillas.add(new CasillaPropia(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            for (int i = 0; i < (numCasillasAspa/2)-4; i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                y-=tamanioCasilla;
            }
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            casillas.add(new CasillaSemicirculo(x,y,casilla));
        } else {
            //PARA NUM CASILLAS IMPARES
            
            //Verticales arriba izquierda
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2)-2); i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                y+=tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            //Horizontal izquierda arriba
            casillas.add(new CasillaPropia(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2)-3); i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                x-=tamanioCasilla;
            }
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            x+=tamanioCasilla;
            //Horizontal izquierda abajo
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2)-2); i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                x+=tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            
            //Vertical abajo izquierda
            casillas.add(new CasillaPropia(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2)-3); i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                y+=tamanioCasilla;
            }
            
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y+=tamanioCasilla;
            
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            y-=tamanioCasilla;
            //Vertical abajo derecha
            
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2)-2); i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                y-=tamanioCasilla;
            }
            
            casillas.add(new CasillaCentro(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            
            //Horizontal derecha abajo
            casillas.add(new CasillaPropia(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2)-3); i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                x+=tamanioCasilla;
            }
            
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x+=tamanioCasilla;
           
            casillas.add(new CasillaSemicirculo(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            y-=tamanioCasilla;
            
            //Horizontal derecha arriba
            
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            x-=tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2)-2); i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                x-=tamanioCasilla;
            }
            casillas.add(new CasillaCentro(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            //Vertical arriba derecha
            casillas.add(new CasillaPropia(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            for (int i = 0; i < (Math.floorDiv(numCasillasAspa, 2)-3); i++) {
                casillas.add(new Casilla(x,y,casilla));
                casilla++;
                y-=tamanioCasilla;
            }
            casillas.add(new CasillaTriangulo(x,y,casilla));
            casilla++;
            y-=tamanioCasilla;
            casillas.add(new CasillaTriangulo(x,y,casilla));
        }

    }
}
