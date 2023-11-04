package com.example.tiktaktoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class TicTacToe extends Application {

    static int turnoJuagador = turnoJugarAleatorio();
    static GridPane tableroVisual = new GridPane();
    static String[][] tablero = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
    static Label textoGanar = new Label("");
    static boolean ganar = false ;
    @Override
    public void start(Stage stage) throws IOException {

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                Button newButton = new Button();
                newButton.setPrefSize(100, 100);
                newButton.setFont(new Font(20));
                int finalI = i;
                int finalJ = j;
                newButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if(turnoJuagador == 0){
                            tablero[finalI][finalJ] = "O";
                            newButton.setText("O");
                            Ganar("O");
                            Empate();
                        }else{
                            tablero[finalI][finalJ] = "X";
                            newButton.setText("X");
                            Ganar("X");
                            Empate();
                        }
                        siguienteJugador();
                        newButton.setDisable(true);
                    }
                });
                tableroVisual.add(newButton, i, j);
            }
        }
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(textoGanar, tableroVisual);
        Scene scene = new Scene(vBox,300,300);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Tic Tac Toe");
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
    private void Ganar(String jugador){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){

                if(tablero[i][0].equals(jugador) && tablero[i][1].equals(jugador) && tablero[i][2].equals(jugador)){
                    if(jugador.equals("X")){
                        System.out.println("Ganador Player 2");
                        textoGanar.setText("Ganador Player 2");
                    }else{
                        System.out.println("Ganador Player 1");
                        textoGanar.setText("Ganador Player 1");
                    }
                    ganar = true;
                    DesactivarBotones();
                }
                if(tablero[0][j].equals(jugador) && tablero[1][j].equals(jugador) && tablero[2][j].equals(jugador)){
                    if(jugador.equals("X")){
                        System.out.println("Ganador Player 2");
                        textoGanar.setText("Ganador Player 2");
                    }else{
                        System.out.println("Ganador Player 1");
                        textoGanar.setText("Ganador Player 1");
                    }
                    ganar = true;
                    DesactivarBotones();
                }
            }
        }

        if(tablero[0][0].equals(jugador) && tablero[1][1].equals(jugador) && tablero[2][2].equals(jugador)){
            if(jugador.equals("X")){
                System.out.println("Ganador Player 2");
                textoGanar.setText("Ganador Player 2");
            }else{
                System.out.println("Ganador Player 1");
                textoGanar.setText("Ganador Player 1");
            }
            ganar = true;
            DesactivarBotones();
        }
        if(tablero[2][0].equals(jugador) && tablero[1][1].equals(jugador) && tablero[0][2].equals(jugador)){
            if(jugador.equals("X")){
                System.out.println("Ganador Player 2");
                textoGanar.setText("Ganador Player 2");
            }else{
                System.out.println("Ganador Player 1");
                textoGanar.setText("Ganador Player 1");
            }
            ganar = true;
            DesactivarBotones();
        }
    }

    private void Empate(){
        Button botonObtenido = null;
        int botonesClickados = 0;

        for (Node nodo : tableroVisual.getChildren()) {
            botonObtenido = (Button) nodo;
            if (!botonObtenido.getText().isEmpty()){
                botonesClickados++;
            }
            if(botonesClickados == 9 && !ganar){
                textoGanar.setText("Empate");
            }
        }
    }

    private void DesactivarBotones(){

        Button botonObtenido = null;

        for (Node nodo : tableroVisual.getChildren()) {
            botonObtenido = (Button) nodo;
            botonObtenido.setDisable(true);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}