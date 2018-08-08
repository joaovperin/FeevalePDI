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

    double x0, y0, x1, y1;
    private Image image;

    @Override
    protected void openFileBrowser(MouseEvent mouseEvent) {
        System.out.println("*** Not implemented yet.");
//        Dialogs.create().message("Hi!").showInformation();
//        JOptionPane.showMessageDialog(null, "Not implemented yet.", "Oops!", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    protected void onInit() {
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        initDraw(graphicsContext);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent event) -> {
            x0 = event.getX();
            y0 = event.getY();
        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, (MouseEvent event) -> {
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent event) -> {
            x1 = event.getX();
            y1 = event.getY();

            double x = (x0 > x1) ? x1 : x0;
            double y = (y0 > y1) ? y1 : y0;
            double w = (x0 > x1) ? x0 - x1 : x1 - x0;
            double h = (y0 > y1) ? y0 - y1 : y1 - y0;

            graphicsContext.drawImage(image, x, y, w, h);
        });
    }

    private void initDraw(GraphicsContext gc) {

        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();

        gc.setFill(Color.LIGHTGRAY);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);

        gc.fill();
        gc.strokeRect(
                0, //x of the upper left corner
                0, //y of the upper left corner
                canvasWidth, //width of the rectangle
                canvasHeight);  //height of the rectangle

        gc.setLineWidth(1);

        image = new Image("file:///Users/Perin/Documents/Repositorios/DigitalImageProcessing/samples/lena.png");
//        image = new Image(getClass().getResourceAsStream(new File("C:\\Users\\Perin\\Documents\\Repositorios\\DigitalImageProcessing\\samples\\lena.png"))));
    }

}
