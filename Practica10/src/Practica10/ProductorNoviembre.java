package Practica10;
import java.util.logging.*;

public class ProductorNoviembre implements Runnable{
    private final BoundedBuffer03<Integer> buffer;
    private final int items;
    private final String name;
    private static final Logger logger = Logger.getLogger("Practica10.Producer");
    public ProductorNoviembre(BoundedBuffer03<Integer> buffer, int items, String name) {
        this.buffer = buffer; this.items = items; this.name = name;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < items; i++) {
                buffer.put(i);
                logger.info(name + " produjo: " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
