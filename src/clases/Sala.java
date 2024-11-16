package clases;

import java.util.ArrayList;


/**
 *
 * @author FELIPON2T
 */
public class Sala {
    private final ArrayList<Jugador> streamer = new ArrayList<>();
    private final ArrayList<Integer> espectadores = new ArrayList<>();
    private boolean jugando = false;
    
    public void entrarEnSala (Jugador streamer) {

        
    }

    public boolean isJugando() {
        return jugando;
    }
    
}
