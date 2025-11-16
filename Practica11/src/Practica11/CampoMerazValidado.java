package Practica11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;

public class CampoMerazValidado extends TextField {

    public CampoMerazValidado(String string) {
        this.setPromptText(string);
        this.getStyleClass().add("text");
        this.textProperty().addListener((observable, oldValue, newValue) -> {
            boolean valido;
            if (this.getPromptText().equalsIgnoreCase("Matricula")) {
                valido = validarMatricula();
            } else {
                valido = validarCadena();
            }
            this.getStyleClass().removeAll("text-valid", "text-invalid");
            if (valido) {
                this.getStyleClass().add("text-valid");
            } else {
                this.getStyleClass().add("text-invalid");
            }
        });
    }

    public boolean validarCadena() {
        if (this.getText().isBlank()) {
            return false;
        } else {
            return !caracteresEspeciales(this.getText(), 1);
        }
    }

    public boolean validarMatricula() {
        if (this.getText().isBlank()) {
            return false;
        } else {
            return !caracteresEspeciales(this.getText(), 2);
        }
    }

    public boolean caracteresEspeciales(String cadena, int op) {
        Pattern letras = Pattern.compile("[a-zA-z]");
        Pattern numeros = Pattern.compile("[0-9]");
        Pattern especiales = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        Matcher letra = letras.matcher(cadena);
        Matcher numero = numeros.matcher(cadena);
        Matcher especial = especiales.matcher(cadena);

        if (op == 1) {
            if (numero.find() || especial.find()) {
                return true;
            }
        } else {
            if (letra.find() || especial.find()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getText();
    }
}