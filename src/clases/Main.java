package clases;

import java.util.ArrayList;

/**
 *
 * @author FELIPON2T
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int NUM_SALAS = 3;
        final int NUM_PLAYERS = 5;
        final int NUM_VIEWERS = 80;

        // Crear array de salas
        Streaming[] streamings = new Streaming[NUM_SALAS];
        for (int i = 0; i < NUM_SALAS; i++) {
            streamings[i] = new Streaming("Sala "+i);
        }

        ArrayList<Thread> threads = new ArrayList<>();

        // Crear jugadores
        for (int i = 1; i <= NUM_PLAYERS; i++) {
            threads.add(new Player(streamings, "Jugador-" + i));
        }

        // Crear espectadores
        for (int i = 1; i <= NUM_VIEWERS; i++) {
            threads.add(new Viewer(streamings, "Espectador-" + i));
        }

        // Iniciar todos los hilos
        threads.forEach(Thread::start);
    }
    
}
