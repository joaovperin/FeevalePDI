/*
 * Copyright (C) 2018 Perin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.jpe.dip.screen;

import br.jpe.dip.utils.Images;
import fxml.InicioController;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Main application class
 *
 * @author joaovperin
 */
public class DigitalImageProcessingApp extends Application {

    /**
     * The application main entry point
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new InicioController();

        Scene scene = new Scene(root);
        primaryStage.setTitle("Feevale DIP");
        try {
            // Try to set lena icon for the center pane
            primaryStage.getIcons().add(Images.getImage("lena.png"));
        } catch (IOException e) {
            System.out.println("***".concat(e.getMessage()));
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
