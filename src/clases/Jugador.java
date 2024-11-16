package clases;

import java.util.Random;

/**
 * @author FELIPON2T
 */
public class Jugador extends Thread{
    private final Sala sala;

    public Jugador(Sala sala, String name) {
        super(name);
        this.sala = sala;
    }

    @Override
    public void run() {
        while (sala.isJugando()) { 
            try {
                Random random = new Random();
                int tiempoJuego = random.nextInt(4001) + 1000;
                sala.entrarEnSala(this);
                sleep(tiempoJuego);
                System.out.println(getName() + " ha entrado a jugar en la sala");
            } catch (InterruptedException e) {
                System.err.println("ERROR: " + e.getMessage());
            }
            
        }
    }
 
}
