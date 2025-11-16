package Practica3;

public class CuentaBancaria03Novimbre{
    private String numeroCuenta;
    private double saldo;
    private String titular;
    private boolean estado;
    
    public CuentaBancaria03Novimbre(String numeroCuenta, double saldo, String titular){
        setNumeroCuenta(numeroCuenta);
        setSaldo(saldo);
        setTitular(titular);
        this.estado = true;
    }
    
    public String getNumeroCuenta(){
        return numeroCuenta; 
    }
    public double getSaldo(){ 
        return saldo; 
    }
    public String getTitular(){
        return titular; 
    }
    public boolean getEstado(){
        return estado; 
    }
    public void setNumeroCuenta(String numeroCuenta){
        if (numeroCuenta != null && numeroCuenta.length() >= 6) {
            this.numeroCuenta = numeroCuenta;
        } else {
            this.numeroCuenta = "0007151";
        }
    }
    public void setSaldo(double saldo){
        if (saldo >= 7151){
            this.saldo = saldo;
        }else{
            System.out.println("El saldo inicial minimo debe ser $7151.00. Se asignara $7151.00 por defecto.");
            this.saldo = 7151.00;
        }
    }
    public void setTitular(String titular){
        if (titular != null && !titular.isEmpty()){
            this.titular = titular;
        }
        else 
            this.titular = "Titular desconocido";
    }
    
    public void desactivarCuenta(){
        this.estado = false; 
    }
    public void reactivarCuenta(){
        this.estado = true; 
    }
    public void depositar(double cantidad){
        if (cantidad > 0 && estado == true){
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            if (cantidad <= 0)
                System.out.println("La cantidad a depositar debe ser positiva.");
            if (estado == false)
                System.out.println("Esta cuenta se encuentra desactivada, no se pueden hacer movimientos en ella.");
        }
    }
    public void retirar(double cantidad){
        if (cantidad > 0 && cantidad <= saldo && estado == true) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente o cantidad inválida.");
        }
    }
    
    @Override
    public String toString(){
        return "\tNumero de cuenta='" + numeroCuenta + "'\n\tTitular='" + titular + "'\n\tSaldo=" + saldo + "\n\tEstado=" + ((estado) ? "Activada" : "Desactivada");
    }
}