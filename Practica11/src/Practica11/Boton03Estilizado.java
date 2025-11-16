package Practica11;

import javafx.scene.control.Button;

public class Boton03Estilizado extends Button{
    
    public Boton03Estilizado(String texto){
        this.setText(texto);
        this.getStyleClass().add("boton");
        this.setOnMouseEntered(evento -> {
            this.getStyleClass().add("buttonEntered");
        });
        this.setOnMousePressed(event -> {
            this.getStyleClass().add("buttonClicked");
        });
    }
}