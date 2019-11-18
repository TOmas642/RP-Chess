/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.io.InputStream;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Tomáš
 */
public class ChessBoard {

    VBox rootFinal = new VBox();
     ArrayList<ImageView> tiles = new ArrayList();
    // protected int[] tiles = new int[64];

    ChessBoard(int size) {
        //ArrayList<ChessTile> tilesOccupants = new ArrayList(); // co na danem policku je
       
        VBox chessboard = new VBox();
        Class<?> clazz = this.getClass();

        InputStream inputTileWhite = clazz.getResourceAsStream("images/TileWhite.png");

        Image imageTileWhite = new Image(inputTileWhite);

        InputStream inputTileBlack = clazz.getResourceAsStream("images/TileBlack.png");
        Image image2 = new Image(inputTileBlack);
        
        for (int j = 0; j < 8; j++) {
            HBox boardLines = new HBox();
            for (int k = 0; k < 8; k++) {
                ImageView tile;
                if ((k + j) % 2 == 0) {
                    tile = new ImageView(imageTileWhite);
                    boardLines.getChildren().add(tile);
                    tiles.add(tile);
                } else {
                    tile = new ImageView(image2);
                    boardLines.getChildren().add(tile);
                    tiles.add(tile);
                    tile.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        System.out.println("Tile pressed ");
                        ImageView b = (ImageView) event.getSource();
                        b.setImage(imageTileWhite);
                        event.consume();
                    });
                }

            }
            chessboard.getChildren().add(boardLines);
        }
        HBox root = new HBox();
        HBox columns = new HBox(42);
        HBox columns2 = new HBox(42);
        VBox lines = new VBox(33);
        VBox lines2 = new VBox(33);

        for (int k = 0; k < 8; k++) {
            lines.getChildren().add(new Label(Integer.toString(1 + k)));
            lines2.getChildren().add(new Label(Integer.toString(1 + k)));
            columns.getChildren().add(new Label(String.valueOf((char) (k + 65))));
            columns2.getChildren().add(new Label(String.valueOf((char) (k + 65))));
        }

        lines.setAlignment(Pos.CENTER);
        lines2.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(lines);
        root.getChildren().add(chessboard);
        root.getChildren().add(lines2);

        columns.setAlignment(Pos.CENTER);
        columns2.setAlignment(Pos.CENTER);
        rootFinal.setAlignment(Pos.CENTER);
        rootFinal.getChildren().add(columns);
        rootFinal.getChildren().add(root);
        rootFinal.getChildren().add(columns2);

    }
}
