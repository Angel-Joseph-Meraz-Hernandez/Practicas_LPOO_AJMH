package Practica10;
import java.util.logging.*;

public class ClienteRunnableNoviembre implements Runnable {
    private final BancoConcurrenteAJMH banco;
    private final String cuentaId;
    private final double monto;
    private static final Logger logger = Logger.getLogger("Practica10.Cliente");


    public ClienteRunnableNoviembre(BancoConcurrenteAJMH banco, String cuentaId, double monto) {
        this.banco = banco;
        this.cuentaId = cuentaId;
        this.monto = monto;
    }


    @Override
    public void run() {
        AccountAJMH acc = banco.getAccount(cuentaId);
        if (acc == null) return;
        synchronized (acc) {
            logger.info(Thread.currentThread().getName() + " intenta retirar " + monto + " de " + cuentaId);
            boolean ok = acc.withdraw(monto);
            logger.info("Retiro " + (ok ? "exitoso" : "fallido") + " — nuevo saldo: " + acc.getBalance());
        }
    }  
}
