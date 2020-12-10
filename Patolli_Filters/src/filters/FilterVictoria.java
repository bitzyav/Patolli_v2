package filters;

import dominio.EstadoPartida;
import dominio.Jugador;
import dominio.Partida;
import java.util.Queue;

/**
 * Clase encargada de ajustar el estado de la Partida para definir a un ganador.
 * @author alfonsofelix
 */
public class FilterVictoria extends Filter<Partida, Partida> {

    @Override
    protected void doFilter() {
        Partida partida = input.get();

        if (partida.getEstado() == EstadoPartida.INICIADA) {

            for (Jugador jug : partida.getJugadores()) {
                if (jug.getNumFrijoles() <= 0 && partida.getTurnos().contains(jug)) {
                    Queue<Jugador> turnos = partida.getTurnos();
                    turnos.remove(jug);
                    partida.setTurnos(turnos);
                }

                /*if (jug.getFichas().isEmpty() && jug.getColaFichas().isEmpty() && partida.getTurnos().contains(jug)) {
                Queue<Jugador> turnos = partida.getTurnos();
                turnos.remove(jug);
                partida.setTurnos(turnos);
            }*/
                if (jug.getFichasGanadoras().size() == partida.getNumFichasJugador()) {
                    partida.setGanador(jug);
                    partida.setEstado(EstadoPartida.TERMINADA);
                    break;
                }

            }
            if(partida.getTurnos().size() == 1){
                Jugador ganador=partida.getTurnos().poll();
                partida.setGanador(ganador);
                partida.setEstado(EstadoPartida.TERMINADA);
            }
            if (partida.getTurnos().isEmpty()) {
                Jugador ganador = null;
                for (Jugador jugador : partida.getJugadores()) {
                    if(!jugador.perdio()){
                        ganador=jugador;
                        break;
                    }
                }
                
                for (Jugador jugador : partida.getJugadores()) {
                    if (jugador.getFichasGanadoras().size() > ganador.getFichasGanadoras().size() && !ganador.perdio()) {
                        ganador = jugador;
                    }
                }
                partida.setGanador(ganador);
                partida.setEstado(EstadoPartida.TERMINADA);
            }
        }
        partida.setSaliendo(false);
        
        output.put(partida);
        output.doChain();
    }

}
