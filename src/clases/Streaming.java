package clases;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Streaming {
    private final int MAX_VIEWERS = 10;
    private boolean playing = false;
    private int viewers = 0;
    private final String roomName;

    // Constructor para inicializar el nombre de la sala
    public Streaming(String roomName) {
        this.roomName = roomName;
    }

    // Un jugador entra en la sala
    public synchronized boolean enterPlayer() {
        while (playing) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Streaming.class.getName()).log(Level.SEVERE, null, ex);
                return false; // Salir si el hilo fue interrumpido.
            }
        }
        playing = true; // El jugador empieza el streaming.
        System.out.println(Thread.currentThread().getName() + " entra en la sala: " + roomName);
        notifyAll();
        return true;
    }

    // Un jugador sale de la sala
    public synchronized boolean exitPlayer() {
        System.out.println(Thread.currentThread().getName() + " sale de la sala: " + roomName);
        playing = false; // El streaming se detiene.
        viewers = 0; // Reiniciar el contador de espectadores.
        notifyAll(); // Notificar a todos (jugadores y espectadores).
        return true;
    }

    // Un espectador entra en la sala
    public synchronized boolean enterViewer() {
        while (!playing || viewers >= MAX_VIEWERS) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Streaming.class.getName()).log(Level.SEVERE, null, ex);
                return false; // Salir si el hilo fue interrumpido.
            }
        }
        viewers++;
        System.out.println(Thread.currentThread().getName() + " entra a ver la sala: " + roomName + ". Viewers: " + viewers);
        notifyAll();
        return true;
    }

    // Un espectador sale de la sala
    public synchronized void exitViewer() {
        if (viewers > 0) {
            viewers--;
            System.out.println(Thread.currentThread().getName() + " sale de la sala: " + roomName + ". Viewers restantes: " + viewers);
            notifyAll();
        }
    }

    // Método adicional para manejar la salida forzada de espectadores
    public synchronized void forceExitViewers() {
        while (viewers > 0) {
            exitViewer(); // Los espectadores se salen uno por uno.
        }
        System.out.println("Todos los espectadores han salido de la sala: " + roomName);
    }
}
