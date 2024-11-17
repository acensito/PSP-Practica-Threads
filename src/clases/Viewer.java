package clases;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FELIPON2T
 */
public class Viewer extends Thread {
    private final Streaming[] streamings;
    private Random random = new Random();

    public Viewer(Streaming[] streamings, String name) {
        super(name);
        this.streamings = streamings;
    }

    @Override
    public void run() {
        while (true) {
            for (Streaming streaming : streamings) {
                if (streaming.enterViewer()) {
                    try {
                        // se pone a ver el streaming entre 3 y 5 segundos
                        Thread.sleep(3000 + random.nextInt(2000));
                        // se sale de la sala
                        streaming.exitViewer();
                        // descansa dos segundos
                        Thread.sleep(2000);
                        //no puede entrar en mas de una sala
                        break;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }    
}
