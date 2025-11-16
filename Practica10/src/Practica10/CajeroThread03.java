package Practica10;
import java.util.logging.*;

import java.util.Random;

public class CajeroThread03 extends Thread{
    private static final Logger logger = Logger.getLogger("Practica10.Cajero");
    private final AccountAJMH a1, a2;
    private final Random rnd = new Random();
    public CajeroThread03(String name, AccountAJMH a1, AccountAJMH a2) {
        super(name);
        this.a1 = a1; this.a2 = a2;
    }
    @Override
    public void run() {
        while (!isInterrupted()) {
            // Simula una transferencia entre cuentas usando método ordenado para evitar deadlock
            double amount = 10 + rnd.nextInt(50);
            boolean ok = AccountAJMH.transferOrdered(a1, a2, amount);
            if (!ok) {
                // si falla, intenta depositar en la cuenta origen
                a1.deposit(amount);
            }
            try { Thread.sleep(120); } catch (InterruptedException e) { interrupt(); }
        }
        logger.info(getName() + " terminado.");
    }
}
