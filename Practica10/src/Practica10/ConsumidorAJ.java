package Practica10;
import java.util.logging.*;

public class ConsumidorAJ implements Runnable {
    private final BoundedBuffer03<Integer> buffer;
    private final int items;
    private final String name;
    private static final Logger logger = Logger.getLogger("Practica10.Consumer");
    public ConsumidorAJ(BoundedBuffer03<Integer> buffer, int items, String name) {
        this.buffer = buffer; this.items = items; this.name = name;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < items; i++) {
                Integer v = buffer.take();
                logger.info(name + " consumió: " + v);
                Thread.sleep(80);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
