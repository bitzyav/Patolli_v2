package filters;

import dominio.Jugador;
import dominio.Partida;
import java.util.Queue;

/**
 * Clase encargada de ajustar el estado de la partida cuando un jugador sale de la misma.
 * @author alfonsofelix
 */
public class FilterRetiro extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida = input.get();

        if(partida.saliendo()){
            Jugador jugadorSale=partida.getJugadorTurno();
            Queue<Jugador> turnos=partida.getTurnos();
            
            turnos.remove(jugadorSale);
            partida.setTurnos(turnos);
            partida.setCantidadDado(-1);
            
        }
        
        //AQUI VAN ACCIONES
        output.put(partida);
        output.doChain();
    }

}
