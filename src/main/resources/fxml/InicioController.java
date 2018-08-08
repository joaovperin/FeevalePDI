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
package fxml;

import br.jpe.dip.screen.Controller;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Perin
 */
public class InicioController extends InicioBase implements Controller {

    /** The Canvas graphic context */
    private final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

    {
        double canvasWidth = graphicsContext.getCanvas().getWidth();
        double canvasHeight = graphicsContext.getCanvas().getHeight();

        graphicsContext.setFill(Color.LIGHTGRAY);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(5);

        graphicsContext.fill();
        graphicsContext.strokeRect(
                0, //x of the upper left corner
                0, //y of the upper left corner
                canvasWidth, //width of the rectangle
                canvasHeight);  //height of the rectangle

        graphicsContext.setLineWidth(1);
        image = new Image("file:///Users/Perin/Documents/Repositorios/DigitalImageProcessing/samples/lena.png");
    }

    /** Coordinates of the mouse events */
    double x0, y0, x1, y1;
    /** The image */
    private Image image;

    /**
     * Opens the file browser
     *
     * @param mouseEvent
     */
    @Override
    protected void openFileBrowser(MouseEvent mouseEvent) {
        System.out.println("*** Not implemented yet.");
//        Dialogs.create().message("Hi!").showInformation();
//        JOptionPane.showMessageDialog(null, "Not implemented yet.", "Oops!", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    protected void canvasOnMousePressed(MouseEvent evt) {
        x0 = evt.getX();
        y0 = evt.getY();
    }

    @Override
    protected void canvasOnMouseReleased(MouseEvent event) {
        x1 = event.getX();
        y1 = event.getY();

        double x = (x0 > x1) ? x1 : x0;
        double y = (y0 > y1) ? y1 : y0;
        double w = (x0 > x1) ? x0 - x1 : x1 - x0;
        double h = (y0 > y1) ? y0 - y1 : y1 - y0;

        graphicsContext.drawImage(image, x, y, w, h);
    }

}
