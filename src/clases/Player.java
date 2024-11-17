package clases;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author FELIPON2T
 */
public class Player extends Thread{
    private final Streaming[] streamings;
    private final Random random = new Random();

    public Player(Streaming[] streamings, String name) {
        super(name);
        this.streamings = streamings;
    }

    @Override
    public void run() {
        while (true) { 
            for (Streaming streaming : streamings) {
                if (streaming.enterPlayer()) {
                    try {
                        // simula jugar entre 5 y 9 segundos
                        Thread.sleep(5000 + random.nextInt(4000));
                        // sale de la sala
                        streaming.exitPlayer();
                        // decansa 3 segundos
                        Thread.sleep(3000);
                        //rompe para que no pueda entrar en mas de una sala
                        break;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
 
}
