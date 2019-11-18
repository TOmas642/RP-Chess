/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Tomáš
 */
public class Chess extends Application {

    public static String StylTlacitka = "-fx-min-width: 200px;-fx-min-width: 200px;";
    public int size;

    @Override
    public void start(Stage primaryStage) {
        ChessBoard chessboard = new ChessBoard(size);
        Button gameButton1 = new Button();
        gameButton1.setStyle(StylTlacitka);

        Button gameButton2 = new Button();
        gameButton2.setStyle(StylTlacitka);

        Button statisticsButton = new Button();
        statisticsButton.setStyle(StylTlacitka);

        Button backButton = new Button();
        backButton.setStyle(StylTlacitka);

        VBox menuRoot = new VBox(20);
        menuRoot.getChildren().add(gameButton1);
        menuRoot.getChildren().add(gameButton2);
        menuRoot.getChildren().add(statisticsButton);
        //menuRoot.getChildren().add(backButton);
        menuRoot.setAlignment(Pos.CENTER);

        VBox statisticsRoot = new VBox(20);
        statisticsRoot.setAlignment(Pos.CENTER);

        VBox gameRoot1 = new VBox(20);
        VBox gameRoot2 = new VBox(20);
        VBox gameRoot3 = new VBox(20);

        Scene scene = new Scene(menuRoot, 1000, 750);

        gameButton1.setText("Hra");
        gameButton1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hra");

                gameRoot1.getChildren().add(chessboard.rootFinal);
                scene.setRoot(gameRoot1);
            }
        });
        gameButton2.setText("Hra přes internet");
        gameButton2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hra přes internet");
                gameRoot2.getChildren().add(backButton);
                scene.setRoot(gameRoot2);
            }
        });

        statisticsButton.setText("Statistika");
        statisticsButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                statisticsRoot.getChildren().add(backButton);
                scene.setRoot(statisticsRoot);
                System.out.println("Statistika");
            }
        });
        backButton.setText("Zpět");
        backButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Zpět");
                statisticsRoot.getChildren().remove(backButton);
                gameRoot1.getChildren().remove(backButton);
                gameRoot2.getChildren().remove(backButton);
                gameRoot3.getChildren().remove(backButton);

                scene.setRoot(menuRoot);
            }
        });

        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
