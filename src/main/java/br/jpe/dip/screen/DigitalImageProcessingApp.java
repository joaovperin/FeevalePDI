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

import fxml.InicioController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        Controller root = new InicioController();
        root.setStage(primaryStage);

        Scene scene = new Scene((Parent) root);
//        try {
//            // Try to set lena icon for the center pane
//            primaryStage.getIcons().add(Images.getImage("lena.png"));
//        } catch (IOException e) {
//            System.out.println("***".concat(e.getMessage()));
//        }
        // Stage config
        primaryStage.setTitle("Feevale DIP");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
