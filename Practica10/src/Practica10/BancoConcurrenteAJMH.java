package Practica10;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class BancoConcurrenteAJMH {
    private final Map<String, AccountAJMH> cuentas = new ConcurrentHashMap<>();
    private static final Logger logger = Logger.getLogger("Practica10.Banco");
    public BancoConcurrenteAJMH() {
        logger.setUseParentHandlers(false);
        logger.addHandler(new ConsoleHandler());
    }
    public void crearCuenta(String id, double inicial) {
        cuentas.put(id, new AccountAJMH(id, inicial));
        logger.info("Cuenta creada: " + id + " saldo=" + inicial);
    }
    public boolean transfer(String fromId, String toId, double amt) {
        AccountAJMH a1 = cuentas.get(fromId);
        AccountAJMH a2 = cuentas.get(toId);
        if (a1 == null || a2 == null) return false;
        AccountAJMH first = a1.getId().compareTo(a2.getId()) < 0 ? a1 : a2;
        AccountAJMH second = first == a1 ? a2 : a1;
        synchronized (first) {
            synchronized (second) {
                if (a1.withdraw(amt)) {
                a2.deposit(amt);
                logger.info("Transferencia: " + amt + " de " + fromId + " a " + toId);
                return true;
                } else {
                logger.info("Fondos insuficientes para transferir " + amt + " desde " + fromId);
                return false;
                }
            }
        }
    }
    public AccountAJMH getAccount(String id){
        return cuentas.get(id);
    }
}
