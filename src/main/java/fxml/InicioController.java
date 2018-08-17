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
import java.io.File;
import java.io.InputStream;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Perin
 */
public class InicioController extends InicioBase implements Controller {

    /** The Canvas graphic context */
    private final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

    /** Coordinates of the mouse events */
    double x0, y0, x1, y1;
    /** The image */
    private Image image;
    /** Stage where to display things */
    private Stage st;

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

        textField.setText("lena.png");
        image = getImage(textField.getText());

        graphicsContext.drawImage(image, 0, 0, canvasWidth, canvasHeight);
    }

    /**
     * Opens the file browser
     *
     * @param mouseEvent
     */
    @Override
    protected void openFileBrowser(MouseEvent mouseEvent) {
        File f = showFileChooserAndGetResult();
        // TODO: Validate directory (can only accept images from resources folder)
        if (f != null && f.exists()) {
            textField.setText(f.getName());
        }
        System.out.println(f);
    }

    private File showFileChooserAndGetResult() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter
                = new FileChooser.ExtensionFilter("IMG files (*.(png || jpg))", "*.png", "*.jpg");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.
                setInitialDirectory(new File("C:\\Users\\Perin\\Desktop\\BKP\\_Docs\\Repositorios\\DigitalImageProcessing\\src\\main\\resources"));
        return fileChooser.showOpenDialog(st);
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

    @Override
    protected void reloadImage(MouseEvent event) {
        image = getImage(textField.getText());
        graphicsContext.drawImage(image, 0, 0, graphicsContext.getCanvas().getWidth(), graphicsContext.getCanvas().
                getHeight());
    }

    private Image getImage(String filename) {
        // Checks file name
        if (filename == null || filename.trim().isEmpty()) {
            System.out.println("*** Invalid filename");
            return null;
        }
        // Checks file exists
        if (new File(filename).exists()) {
            final String file = "file://";
            // Returns with the "file://" protocol prefix
            if (filename.startsWith(file)) {
                return new Image(filename);
            }
            return new Image(file.concat(filename));
        }
        // Get the image as a resource
        InputStream resourceImg = getClass().getClassLoader().getResourceAsStream(filename);
        if (resourceImg != null) {
            return new Image(resourceImg);
        }
        System.out.println("*** Image doesn't seems to exist in the resources folder :/");
        return null;
    }

    // Sets the stage of this controller
    @Override
    public void setStage(Stage st) {
        this.st = st;
    }

}
