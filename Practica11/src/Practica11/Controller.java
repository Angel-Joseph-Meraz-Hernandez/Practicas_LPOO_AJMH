package Practica11;

import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class Controller {
    
    @FXML
    private BorderPane ventana;
    
    @FXML
    private VBox menu;
    
    @FXML
    private HBox barra_inferior;
    
    @FXML
    private VBox ingresar_datos;
    
    @FXML
    private HBox datos_inferior;
    
    @FXML
    private Label label;
    
    @FXML
    private TableView<EstudianteAJMH> tablaEstudiantes;

    @FXML
    private TableColumn<EstudianteAJMH, String> colNombre;
    
    @FXML
    private TableColumn<EstudianteAJMH, String> colApellidoP;
    
    @FXML
    private TableColumn<EstudianteAJMH, String> colApellidoM;
    
    @FXML
    private TableColumn<EstudianteAJMH, String> colMatricula;

    @FXML
    private TableColumn<EstudianteAJMH, String> colCarrera;
    
    @FXML
    private TableColumn<EstudianteAJMH, String> colEstado;

    private ObservableList<EstudianteAJMH> listaEstudiantes;

    public void initialize() {
        // Configurar columnas
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoP"));
        colApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellidoM"));
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        SisteamEstudiantilAJ7151 listaEstudiantes = new SisteamEstudiantilAJ7151();

        tablaEstudiantes.setItems(listaEstudiantes.lista());
        
        Boton03Estilizado boton1 = new Boton03Estilizado("Registrar estudiante");
        Boton03Estilizado boton2 = new Boton03Estilizado("Buscar estudiante");
        Boton03Estilizado boton3 = new Boton03Estilizado("Modificar registro");
        Boton03Estilizado boton4 = new Boton03Estilizado("Eliminar registro");
        
        menu.getChildren().add(boton1);
        menu.getChildren().add(boton2);
        menu.getChildren().add(boton3);
        menu.getChildren().add(boton4);
        
        boton1.setOnAction(evento -> {      // Registrar estudiante
            barra_inferior.getChildren().removeIf(n -> n instanceof Label);
            ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
            datos_inferior.getChildren().clear();
            
            Boton03Estilizado botonAceptar = new Boton03Estilizado("Aceptar");
            Boton03Estilizado botonCancelar = new Boton03Estilizado("Cancelar");
            MenuButton menuOpciones = new MenuButton("Estado");
            
            MenuItem act = new MenuItem("Activo");
            MenuItem inact = new MenuItem("Inactivo");
            final boolean[] estado = {false};
            menuOpciones.getItems().addAll(act, inact);
            ingresar_datos.getChildren().addFirst(menuOpciones);
            
            act.setOnAction(event -> {
                estado[0] = true;
            });
            
            inact.setOnAction(event -> {
                estado[0] = false;
            });
            
            CampoMerazValidado campoCarrera = new CampoMerazValidado("Carrera");
            ingresar_datos.getChildren().addFirst(campoCarrera);
            
            CampoMerazValidado campoMatricula = new CampoMerazValidado("Matricula");
            ingresar_datos.getChildren().addFirst(campoMatricula);
            
            CampoMerazValidado campoApellidoM = new CampoMerazValidado("Apellido materno");
            ingresar_datos.getChildren().addFirst(campoApellidoM);
            
            CampoMerazValidado campoApellidoP = new CampoMerazValidado("Apellido paterno");
            ingresar_datos.getChildren().addFirst(campoApellidoP);
            
            CampoMerazValidado campoNombre = new CampoMerazValidado("Nombre");
            ingresar_datos.getChildren().addFirst(campoNombre);
            
            datos_inferior.getChildren().add(botonAceptar);
            datos_inferior.getChildren().add(botonCancelar);
            
            botonAceptar.setOnAction(event -> {
                String nombre = campoNombre.getText();
                String apellidoP = campoApellidoP.getText();
                String apellidoM = campoApellidoM.getText();
                String matricula = campoMatricula.getText();
                String carrera = campoCarrera.getText();
                
                if(campoNombre.validarCadena() && campoApellidoP.validarCadena() && campoApellidoM.validarCadena() && campoMatricula.validarMatricula() && campoCarrera.validarCadena()){
                    listaEstudiantes.crearRegistro(nombre, apellidoP, apellidoM, matricula, carrera, estado[0]);
                }
                ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
                datos_inferior.getChildren().clear();
            });
            
            botonCancelar.setOnAction(event -> {
                ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
                datos_inferior.getChildren().clear();
            });
        });
        
        boton2.setOnAction(evento -> {      // Buscar estudiante
            barra_inferior.getChildren().removeIf(n -> n instanceof Label);
            ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
            datos_inferior.getChildren().clear();
            
            Boton03Estilizado botonAceptar = new Boton03Estilizado("Aceptar");
            Boton03Estilizado botonCancelar = new Boton03Estilizado("Cancelar");
            
            datos_inferior.getChildren().add(botonAceptar);
            datos_inferior.getChildren().add(botonCancelar);
            
            CampoMerazValidado matricula = new CampoMerazValidado("Matricula");
            ingresar_datos.getChildren().addFirst(matricula);
            
            botonAceptar.setOnAction(event -> {
                EstudianteAJMH estudiante = listaEstudiantes.buscarRegistro(matricula.getText());
                colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoP"));
                colApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellidoM"));
                colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
                colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
                colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
                
                SisteamEstudiantilAJ7151 estudiantes = new SisteamEstudiantilAJ7151();
                if(estudiante != null){
                    barra_inferior.getChildren().removeIf(n -> n instanceof Label);
                    if(estudiante.getEstado().equals("Activo"))
                        estudiantes.crearRegistro(estudiante.getNombre(), estudiante.getApellidoP(),estudiante.getApellidoM(), estudiante.getMatricula(), estudiante.getCarrera(), true);
                    else
                        estudiantes.crearRegistro(estudiante.getNombre(), estudiante.getApellidoP(),estudiante.getApellidoM(), estudiante.getMatricula(), estudiante.getCarrera(), false);
                    if(matricula.validarMatricula())
                        tablaEstudiantes.setItems(estudiantes.lista());
                } else {
                    Label mensaje = new Label();
                    Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                    alerta.setTitle("Registros");
                    alerta.setHeaderText("Registro no ecnontrado");
                    alerta.setContentText("No se enocntró ningun registro con la matricula ingresada.");
                    alerta.showAndWait();
                    barra_inferior.getChildren().add(mensaje);
                }
            });
            
            botonCancelar.setOnAction(event -> {
                tablaEstudiantes.setItems(listaEstudiantes.lista());
                barra_inferior.getChildren().removeIf(n -> n instanceof Label);
                ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
                datos_inferior.getChildren().clear();
            });
        });
        
        boton3.setOnAction(evento -> {      // Modificar registro
            barra_inferior.getChildren().removeIf(n -> n instanceof Label);
            ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
            datos_inferior.getChildren().clear();
            
            Boton03Estilizado botonAceptar = new Boton03Estilizado("Aceptar");
            Boton03Estilizado botonCancelar = new Boton03Estilizado("Cancelar");
            
            datos_inferior.getChildren().add(botonAceptar);
            datos_inferior.getChildren().add(botonCancelar);
            
            CampoMerazValidado matricula = new CampoMerazValidado("Matricula");
            ingresar_datos.getChildren().addFirst(matricula);
            
            botonAceptar.setOnAction(event -> {
                EstudianteAJMH estudiante = listaEstudiantes.buscarRegistro(matricula.getText());
                colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoP"));
                colApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellidoM"));
                colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
                colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
                colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
                
                SisteamEstudiantilAJ7151 estudiantes = new SisteamEstudiantilAJ7151();
                if(estudiante != null){
                    barra_inferior.getChildren().removeIf(n -> n instanceof Label);
                    if(estudiante.getEstado().equals("Activo"))
                        estudiantes.crearRegistro(estudiante.getNombre(), estudiante.getApellidoP(),estudiante.getApellidoM(), estudiante.getMatricula(), estudiante.getCarrera(), true);
                    else
                        estudiantes.crearRegistro(estudiante.getNombre(), estudiante.getApellidoP(),estudiante.getApellidoM(), estudiante.getMatricula(), estudiante.getCarrera(), false);

                    if(matricula.validarMatricula()){
                        tablaEstudiantes.setItems(estudiantes.lista());
                        
                        Boton03Estilizado botonModificar = new Boton03Estilizado("Modificar");
                        MenuButton menuOpciones = new MenuButton("Estado");

                        MenuItem act = new MenuItem("Activo");
                        MenuItem inact = new MenuItem("Inactivo");
                        final boolean[] estado = {false};
                        menuOpciones.getItems().addAll(act, inact);
                        ingresar_datos.getChildren().addFirst(menuOpciones);

                        act.setOnAction(even -> {
                            estado[0] = true;
                        });

                        inact.setOnAction(even -> {
                            estado[0] = false;
                        });

                        CampoMerazValidado campoCarrera = new CampoMerazValidado("Carrera");
                        campoCarrera.setText(estudiante.getCarrera());
                        ingresar_datos.getChildren().addFirst(campoCarrera);
                        
                        CampoMerazValidado campoMat = new CampoMerazValidado("Matricula");
                        campoMat.setText(estudiante.getMatricula());
                        ingresar_datos.getChildren().addFirst(campoMat);

                        CampoMerazValidado campoApellidoM = new CampoMerazValidado("Apellido materno");
                        campoApellidoM.setText(estudiante.getApellidoM());
                        ingresar_datos.getChildren().addFirst(campoApellidoM);

                        CampoMerazValidado campoApellidoP = new CampoMerazValidado("Apellido paterno");
                        campoApellidoP.setText(estudiante.getApellidoP());
                        ingresar_datos.getChildren().addFirst(campoApellidoP);

                        CampoMerazValidado campoNombre = new CampoMerazValidado("Nombre");
                        campoNombre.setText(estudiante.getNombre());
                        ingresar_datos.getChildren().addFirst(campoNombre);

                        datos_inferior.getChildren().add(botonModificar);

                        botonModificar.setOnAction(even -> {
                            String nombre = campoNombre.getText();
                            String apellidoP = campoApellidoP.getText();
                            String apellidoM = campoApellidoM.getText();
                            String mat = campoMat.getText();
                            String carrera = campoCarrera.getText();

                            if(campoNombre.validarCadena() && campoApellidoP.validarCadena() && campoApellidoM.validarCadena() && campoMat.validarMatricula() && campoCarrera.validarCadena()){
                                listaEstudiantes.actualizarRegistro(mat, nombre, apellidoP, apellidoM, carrera, estado[0]);
                            }
                            tablaEstudiantes.setItems(listaEstudiantes.lista());
                            ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
                            datos_inferior.getChildren().clear();
                        });
                    }
                } else {
                    Label mensaje = new Label();
                    Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                    alerta.setTitle("Registros");
                    alerta.setHeaderText("Registro no ecnontrado");
                    alerta.setContentText("No se enocntró ningun registro con la matricula ingresada.");
                    alerta.showAndWait();
                    barra_inferior.getChildren().add(mensaje);
                }
            });
            
            botonCancelar.setOnAction(event -> {
                tablaEstudiantes.setItems(listaEstudiantes.lista());
                barra_inferior.getChildren().removeIf(n -> n instanceof Label);
                ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
                datos_inferior.getChildren().clear();
            });
        });
        
        boton4.setOnAction(evento -> {      // Eliminar registro
            barra_inferior.getChildren().removeIf(n -> n instanceof Label);
            ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
            datos_inferior.getChildren().clear();
            
            Boton03Estilizado botonAceptar = new Boton03Estilizado("Aceptar");
            Boton03Estilizado botonCancelar = new Boton03Estilizado("Cancelar");
            
            datos_inferior.getChildren().add(botonAceptar);
            datos_inferior.getChildren().add(botonCancelar);
            
            CampoMerazValidado matricula = new CampoMerazValidado("Matricula");
            ingresar_datos.getChildren().addFirst(matricula);
            
            botonAceptar.setOnAction(event -> {
                EstudianteAJMH estudiante = listaEstudiantes.buscarRegistro(matricula.getText());
                colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoP"));
                colApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellidoM"));
                colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
                colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
                colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
                
                SisteamEstudiantilAJ7151 estudiantes = new SisteamEstudiantilAJ7151();
                if(estudiante != null){
                    barra_inferior.getChildren().removeIf(n -> n instanceof Label);
                    if(estudiante.getEstado().equals("Activo"))
                        estudiantes.crearRegistro(estudiante.getNombre(), estudiante.getApellidoP(),estudiante.getApellidoM(), estudiante.getMatricula(), estudiante.getCarrera(), true);
                    else
                        estudiantes.crearRegistro(estudiante.getNombre(), estudiante.getApellidoP(),estudiante.getApellidoM(), estudiante.getMatricula(), estudiante.getCarrera(), false);

                    if(matricula.validarMatricula()){
                        tablaEstudiantes.setItems(estudiantes.lista());
                        
                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                        alerta.setTitle("Eliminar registro");
                        alerta.setHeaderText("¿Deseas eliminar este registro?");
                        alerta.setContentText("No podrás recuperarlo después.");
                        
                        ButtonType botonEliminar = new ButtonType("Eliminar");
                        ButtonType botonCancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
                        
                        alerta.getButtonTypes().setAll(botonEliminar, botonCancel);
                        
                        Optional<ButtonType> resultado = alerta.showAndWait();

                        if (resultado.isPresent() && resultado.get() == botonEliminar) {
                            String mat = matricula.getText();
                            listaEstudiantes.eliminarRegistro(mat);
                            
                            tablaEstudiantes.setItems(listaEstudiantes.lista());
                            ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
                            datos_inferior.getChildren().clear();
                        } else {
                            tablaEstudiantes.setItems(listaEstudiantes.lista());
                        }
                    }
                } else {
                    Label mensaje = new Label();
                    Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                    alerta.setTitle("Registros");
                    alerta.setHeaderText("Registro no ecnontrado");
                    alerta.setContentText("No se enocntró ningun registro con la matricula ingresada.");
                    alerta.showAndWait();
                    barra_inferior.getChildren().add(mensaje);
                }
            });
            
            botonCancelar.setOnAction(event -> {
                tablaEstudiantes.setItems(listaEstudiantes.lista());
                barra_inferior.getChildren().removeIf(n -> n instanceof Label);
                ingresar_datos.getChildren().removeIf(n -> n instanceof CampoMerazValidado || n instanceof MenuButton);
                datos_inferior.getChildren().clear();
            });
        });       
    }
}