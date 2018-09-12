package fxml.output;

import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.lang.*;
import java.net.*;
import java.util.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public abstract class OutputBase extends AnchorPane {

    protected final Pane pane;
    protected final Pane pane0;
    protected final Pane pane1;
    protected final Button button;
    protected final Canvas canvas;
    protected final Pane pane2;
    protected final ChoiceBox choiceBox;
    protected final Button button0;
    protected final Button button1;

    public OutputBase() {

        pane = new Pane();
        pane0 = new Pane();
        pane1 = new Pane();
        button = new Button();
        canvas = new Canvas();
        pane2 = new Pane();
        choiceBox = new ChoiceBox();
        button0 = new Button();
        button1 = new Button();

        setId("AnchorPane");
        setPrefHeight(640.0);
        setPrefWidth(710.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/fxml/output//styles/inicio.css");

        pane.setId("bgPane");
        pane.setLayoutX(10.0);
        pane.setLayoutY(9.0);
        pane.setPrefHeight(621.0);
        pane.setPrefWidth(688.0);
        pane.setStyle("-fx-border-color: black;");
        pane.setOpaqueInsets(new Insets(0.0));

        pane0.setId("imgPane");
        pane0.setLayoutX(10.0);
        pane0.setLayoutY(10.0);
        pane0.setPrefHeight(556.0);
        pane0.setPrefWidth(668.0);
        pane0.setStyle("-fx-border-color: black;");

        pane1.setId("filePane");
        pane1.setPrefHeight(46.0);
        pane1.setPrefWidth(668.0);
        pane1.setStyle("-fx-border-color: black;");

        button.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button.setLayoutX(215.0);
        button.setLayoutY(8.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(239.0);
        button.setText("Funerárea Pesadelo Eterno");
        button.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);

        canvas.setHeight(510.0);
        canvas.setId("canvas");
        canvas.setLayoutY(46.0);
        canvas.setWidth(668.0);

        pane2.setLayoutX(10.0);
        pane2.setLayoutY(565.0);
        pane2.setPrefHeight(46.0);
        pane2.setPrefWidth(668.0);
        pane2.setStyle("-fx-border-color: black;");

        choiceBox.setId("cb_challenges");
        choiceBox.setLayoutX(7.0);
        choiceBox.setLayoutY(8.0);
        choiceBox.setPrefHeight(31.0);
        choiceBox.setPrefWidth(560.0);

        button0.setId("pb_challenges");
        button0.setLayoutX(574.0);
        button0.setLayoutY(8.0);
        button0.setMnemonicParsing(false);
        button0.setOnMouseReleased(this::runChallenge);
        button0.setPrefHeight(31.0);
        button0.setPrefWidth(47.0);
        button0.setText("Run");
        button0.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);

        button1.setId("pb_challenges");
        button1.setLayoutX(627.0);
        button1.setLayoutY(8.0);
        button1.setMnemonicParsing(false);
        button1.setOnMouseReleased(this::runChallenge);
        button1.setPrefHeight(31.0);
        button1.setPrefWidth(33.0);
        button1.setText("?");
        button1.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);

        pane1.getChildren().add(button);
        pane0.getChildren().add(pane1);
        pane0.getChildren().add(canvas);
        pane.getChildren().add(pane0);
        pane2.getChildren().add(choiceBox);
        pane2.getChildren().add(button0);
        pane2.getChildren().add(button1);
        pane.getChildren().add(pane2);
        getChildren().add(pane);

    }

    protected abstract void runChallenge(javafx.scene.input.MouseEvent mouseEvent);


}
