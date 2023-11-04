package com.example.tiktaktoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {

    static int turnoJuagador = turnoJugarAleatorio();


    @Override
    public void start(Stage stage) throws IOException {
        GridPane tablero = new GridPane();

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                Button newButton = new Button();
                newButton.setPrefSize(100, 100);
                newButton.setFont(new Font(20));
                newButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if(turnoJuagador == 0){
                            newButton.setText("O");
                        }else{
                            newButton.setText("X");
                        }
                        siguienteJugador();
                        newButton.setDisable(true);
                    }
                });
                tablero.add(newButton, i, j);
            }
        }
        VBox vBox = new VBox();
        vBox.getChildren().addAll(tablero);
        Scene scene = new Scene(vBox,200,200);
        stage.setScene(scene);
        stage.show();
    }

    private static int turnoJugarAleatorio(){
        Random rnd = new Random();
        return rnd.nextInt(2);
    }
    private static void siguienteJugador(){
        if(turnoJuagador == 0){
            turnoJuagador = 1;
        }else{
            turnoJuagador = 0;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}