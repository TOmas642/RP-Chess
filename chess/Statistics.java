/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import chess.MyLabel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author 2016-e-prusek
 */
class Statistics {

    HBox statistics = new HBox(30);

    Statistics(String path) throws IOException {
        VBox column1 = new VBox(20);
        VBox column2 = new VBox(20);
        File f = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            String data = "";
            f.createNewFile();
            
            FileOutputStream fos = new FileOutputStream(f);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for (int i = 0; i < 4; i++) {
		bw.write("0");
		bw.newLine();
	}
 
	bw.close();
        }
        BufferedReader br = new BufferedReader(new FileReader(f));

        column1.getChildren().add(new MyLabel("Poměr výher a proher:").label);
        column1.getChildren().add(new MyLabel("Počet výher:").label);
        column1.getChildren().add(new MyLabel("Počet proher:").label);
        column1.getChildren().add(new MyLabel("Průměrný čas jedné hry:").label);
        column1.setAlignment(Pos.CENTER_LEFT);

        column2.getChildren().add(new MyLabel(br.readLine()+"%").label);
        column2.getChildren().add(new MyLabel(br.readLine()).label);
        column2.getChildren().add(new MyLabel(br.readLine()).label);
        column2.getChildren().add(new MyLabel(br.readLine()+"s").label);
        column2.setAlignment(Pos.CENTER_LEFT);

        statistics.getChildren().add(column1);
        statistics.getChildren().add(column2);
        statistics.setAlignment(Pos.CENTER);
    }

}
