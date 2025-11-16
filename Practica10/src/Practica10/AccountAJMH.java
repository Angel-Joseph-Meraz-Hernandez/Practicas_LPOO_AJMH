package Practica10;

public class AccountAJMH {
    private final String id;
    private double balance;
    public AccountAJMH(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }
    public String getId() { return id; }
    public synchronized double getBalance() { return balance; }
    public synchronized void deposit(double amt) {
    balance += amt; 
    }
    public synchronized boolean withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            return true;
        }
        return false;
    }
    public static boolean transferOrdered(AccountAJMH a1, AccountAJMH a2, double amt) {
        AccountAJMH first = a1.getId().compareTo(a2.getId()) < 0 ? a1 : a2;
        AccountAJMH second = first == a1 ? a2 : a1;
        synchronized (first) {
            synchronized (second) {
                if (a1.withdraw(amt)) {
                    a2.deposit(amt);
                    return true;
                }
                return false;
            }
        }
    }
}
