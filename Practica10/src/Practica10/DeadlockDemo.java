package Practica10;
import java.util.logging.*;

public class DeadlockDemo {
    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();
    private static final Logger logger = Logger.getLogger("Practica10.Deadlock");
    public static void runDemo() throws InterruptedException {
        logger.info(" Iniciando demo deadlock (y estrategia de evitación) ");
        Thread t1 = new Thread(() -> {
            synchronized (LOCK_A) {
                sleepSilently(100);
                synchronized (LOCK_B) {
                    logger.info("t1 dentro A y B");
                }
            }
        }, "DL-1");


        Thread t2 = new Thread(() -> {
            synchronized (LOCK_B) {
                sleepSilently(100);
                synchronized (LOCK_A) {
                    logger.info("t2 dentro B y A");
                }
            }
        }, "DL-2");
        t1.start();
        t2.start();
        Thread.sleep(300);
        if (t1.isAlive() && t2.isAlive()) {
            logger.warning("Posible deadlock detectado — demostración. Evitando deadlock usando ordenamiento de locks.");
            Thread avoid1 = new Thread(() -> orderedLock(LOCK_A, LOCK_B), "Avoid-1");
            Thread avoid2 = new Thread(() -> orderedLock(LOCK_A, LOCK_B), "Avoid-2");
            avoid1.start(); avoid2.start();
            avoid1.join(); avoid2.join();
        }
        t1.interrupt(); t2.interrupt();
    }
    private static void orderedLock(Object a, Object b) {
        Object first = System.identityHashCode(a) < System.identityHashCode(b) ? a : b;
        Object second = first == a ? b : a;
        synchronized (first) {
            sleepSilently(50);
            synchronized (second) {
                logger.info(Thread.currentThread().getName() + " adquirió locks en orden");
            }
        }
    }
    private static void sleepSilently(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
