/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dominio.Partida;

/**
 *
 * @author alfonsofelix
 */
public class FilterDado extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida = input.get();

        switch (partida.getCantidadDado()) {
            case 0:
                partida.setCuantasMueve(0);
                partida.setCantidadDado(-1);
                break;
            case 1:
                partida.setCuantasMueve(1);
                break;
            case 2:
                partida.setCuantasMueve(2);
                break;
            case 3:
                partida.setCuantasMueve(3);
                break;
            case 4:
                partida.setCuantasMueve(4);
                break;
            case 5:
                partida.setCuantasMueve(10);
                break;
        }

        output.put(partida);
        output.doChain();
    }

}
