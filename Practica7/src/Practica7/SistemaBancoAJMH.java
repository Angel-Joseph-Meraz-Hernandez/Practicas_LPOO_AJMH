package Practica7;
import java.io.*;
import java.util.logging.*;

public class SistemaBancoAJMH {
    private static final Logger logger = Logger.getLogger("LogMeraz");
    private FileHandler fileHandler;

    public SistemaBancoAJMH() throws IOException {
        fileHandler = new FileHandler("log_estudiante.txt", true);
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);
    }

    public void validarMatricula(String matricula) {
        try {
            if (matricula == null || matricula.length() != 8) {
                throw new Matricula03InvalidaException("La matricula debe tener exactamente 8 caracteres");
            }
            System.out.println("Matricula valida: " + matricula);

        } catch (Matricula03InvalidaException e) {
            logger.severe("Error de matricula: " + e.getMensaje());
            System.out.println("Excepcion de matricula: " + e.getMensaje());
        }
    }

    public void verificarSaldo(double saldo, double retiro) {
        try {
            if (retiro > saldo) {
                throw new SaldoNoviembreInsuficienteException("Saldo insuficiente para realizar el retiro");
            }
            System.out.println("Retiro exitoso: " + retiro);

        } catch (SaldoNoviembreInsuficienteException e) {
            logger.warning("Saldo insuficiente. Saldo: " + saldo + ", Retiro: " + retiro);
            System.out.println("Excepcion de saldo: " + e.getMensaje());
        }
    }

    public void buscarUsuario(String id) {
        try {
            if (!id.equals("A123")) { // Simulación
                throw new Usuario7151NoEncontradoException("El usuario " + id + " no existe");
            }
            System.out.println("Usuario encontrado: " + id);

        } catch (Usuario7151NoEncontradoException e) {
            logger.info("Usuario no encontrado: " + id);
            System.out.println("Excepcion de usuario: " + e.getMensaje());
        }
    }
}