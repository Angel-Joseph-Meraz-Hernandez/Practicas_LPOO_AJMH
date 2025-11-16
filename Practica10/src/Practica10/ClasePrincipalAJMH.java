package Practica10;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class ClasePrincipalAJMH {
    private static final Logger logger = Logger.getLogger("Practica10");
    public static void main(String[] args) throws Exception {
        BancoConcurrenteAJMH banco = new BancoConcurrenteAJMH();
        banco.crearCuenta("A001", 1000.0);
        banco.crearCuenta("A002", 500.0);
        AccountAJMH cta1 = banco.getAccount("A001");
        AccountAJMH cta2 = banco.getAccount("A002");
        CajeroThread03 cajero1 = new CajeroThread03("Cajero-1", cta1, cta2);
        CajeroThread03 cajero2 = new CajeroThread03("Cajero-2", cta1, cta2);
        cajero1.start();
        cajero2.start();
        Thread clienteT1 = new Thread(new ClienteRunnableNoviembre(banco, "A001", 200.0), "Cliente-1");
        Thread clienteT2 = new Thread(new ClienteRunnableNoviembre(banco, "A002", 300.0), "Cliente-2");
        clienteT1.start();
        clienteT2.start();
        int matriculaUltimos = 7; // Cambia este valor por tus últimos dígitos de matrícula
        int bufferSize = Math.max(2, Math.abs(matriculaUltimos) % 10);
        BoundedBuffer03<Integer> buffer = new BoundedBuffer03<>(bufferSize);
        logger.info("Buffer size (basado en últimos dígitos de matrícula): " + bufferSize);

        ExecutorService pcService = Executors.newFixedThreadPool(4);
        pcService.execute(new ProductorNoviembre(buffer, 20, "Prod-1"));
        pcService.execute(new ProductorNoviembre(buffer, 20, "Prod-2"));
        pcService.execute(new ConsumidorAJ(buffer, 20, "Cons-1"));
        pcService.execute(new ConsumidorAJ(buffer, 20, "Cons-2"));
        pcService.shutdown();
        pcService.awaitTermination(30, TimeUnit.SECONDS);
        ThreadPoolMeraz pool = new ThreadPoolMeraz(3);
        for (int i = 0; i < 6; i++) {
        final int id = i;
        pool.execute(() -> {
        logger.info("Tarea de pool ejecutando: " + id + " en " + Thread.currentThread().getName());
        try { Thread.sleep(300); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        }
        pool.shutdown();
        DeadlockDemo.runDemo();
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(() -> logger.info("Tarea simple en ExecutorService"));
        es.shutdown();
        es.awaitTermination(5, TimeUnit.SECONDS);
        clienteT1.join();
        clienteT2.join();
        cajero1.interrupt();
        cajero2.interrupt();
        cajero1.join();
        cajero2.join();
        logger.info(" Fin demostracion ");
    }

    
}
