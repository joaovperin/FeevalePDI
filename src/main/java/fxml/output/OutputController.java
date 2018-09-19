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
package fxml.output;

import br.jpe.dip.funeraria.FailedChallenge;
import br.jpe.dip.funeraria.FunerariaChallenge;
import br.jpe.dip.screen.Controller;
import br.jpe.dip.ui.utils.MessageBoxes;
import javafx.collections.FXCollections;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Perin
 */
public class OutputController extends OutputBase implements Controller {

    /** The Canvas graphic context */
    private final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

    /** Coordinates of the mouse events */
    double x0, y0, x1, y1;
    /** The image */
    private Image image;

    private FunerariaChallenge challenge = new FailedChallenge();
    /** Stage where to display things */
    private Stage st;

    double canvasWidth;
    double canvasHeight;

    {
        canvasWidth = graphicsContext.getCanvas().getWidth();
        canvasHeight = graphicsContext.getCanvas().getHeight();

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

        choiceBox.setItems(FXCollections.observableArrayList(
                "Original Image", new Separator(),
                "Challenge 1", "Challenge 2", "Challenge 3", "Challenge 4", "Challenge 5", "Challenge 6")
        );
        choiceBox.setValue(choiceBox.getItems().get(0));

        image = new Image(getClass().getClassLoader().getResourceAsStream("caixao.png"));
        graphicsContext.drawImage(image, 0, 0, canvasWidth, canvasHeight);
    }

    private Image getImage(String cbVal) {
        // Get the image as a resource
        if (cbVal.equals(choiceBox.getItems().get(0))) {
            return new Image(getClass().getClassLoader().getResourceAsStream("caixao.png"));
        }

        System.out.println("Rendering exercise: " + cbVal);
        try {
            challenge = (FunerariaChallenge) Class.forName("br.jpe.dip.funeraria." + cbVal.replaceAll(" ", "")).newInstance();
        } catch (Exception ex) {
            challenge = new FailedChallenge();
        }
        return challenge.getProcessedImage("caixao.png");
    }

    // Sets the stage of this controller
    @Override
    public void setStage(Stage st) {
        this.st = st;
    }

    @Override
    protected void runChallenge(MouseEvent mouseEvent) {
        String cbVal = choiceBox.getValue().toString();
        image = getImage(cbVal);
        graphicsContext.drawImage(image, 0, 0, canvasWidth, canvasHeight);
    }

    @Override
    protected void showTitleInfo(MouseEvent mouseEvent) {
        System.out.println("**** CLICOU NO TITULO");
        MessageBoxes.showInfoDialog("VOCE NAO DEERIA TER CLICADO AQUI");
    }

    @Override
    protected void showChallengeInfo(MouseEvent mouseEvent) {
        System.out.println("**** CLICOU NO BOTÃO INFO");
        MessageBoxes.showInfoDialog(challenge.getInformationText());
    }
    
    
    // TRAZER NOTEBOOK COM TUDO OK
    

}
