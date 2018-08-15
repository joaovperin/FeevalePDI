package fxml;

import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.lang.*;
import java.net.*;
import java.util.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public abstract class InicioBase extends AnchorPane {

    protected final Pane pane;
    protected final Pane pane0;
    protected final TextField textField;
    protected final Button button;
    protected final Button button0;
    protected final Pane pane1;
    protected final Canvas canvas;

    public InicioBase() {

        pane = new Pane();
        pane0 = new Pane();
        textField = new TextField();
        button = new Button();
        button0 = new Button();
        pane1 = new Pane();
        canvas = new Canvas();

        setId("AnchorPane");
        setPrefHeight(583.0);
        setPrefWidth(710.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/fxml//styles/inicio.css");

        pane.setId("bgPane");
        pane.setLayoutX(10.0);
        pane.setLayoutY(9.0);
        pane.setPrefHeight(566.0);
        pane.setPrefWidth(688.0);
        pane.setStyle("-fx-border-color: black;");
        pane.setOpaqueInsets(new Insets(0.0));

        pane0.setId("filePane");
        pane0.setLayoutX(10.0);
        pane0.setLayoutY(486.0);
        pane0.setPrefHeight(69.0);
        pane0.setPrefWidth(668.0);
        pane0.setStyle("-fx-border-color: black;");

        textField.setLayoutX(14.0);
        textField.setLayoutY(19.0);
        textField.setPrefHeight(32.0);
        textField.setPrefWidth(564.0);
        textField.setPromptText("Select a file...");
        textField.setFont(new Font(13.0));

        button.setAlignment(javafx.geometry.Pos.CENTER);
        button.setLayoutX(586.0);
        button.setLayoutY(19.0);
        button.setMnemonicParsing(false);
        button.setOnMouseClicked(this::openFileBrowser);
        button.setPrefHeight(32.0);
        button.setPrefWidth(33.0);
        button.setText("^");
        button.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);

        button0.setAlignment(javafx.geometry.Pos.CENTER);
        button0.setLayoutX(626.0);
        button0.setLayoutY(19.0);
        button0.setMnemonicParsing(false);
        button0.setOnMouseClicked(this::reloadImage);
        button0.setPrefHeight(32.0);
        button0.setPrefWidth(33.0);
        button0.setText("O");
        button0.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);

        pane1.setId("imgPane");
        pane1.setLayoutX(10.0);
        pane1.setLayoutY(10.0);
        pane1.setPrefHeight(477.0);
        pane1.setPrefWidth(668.0);
        pane1.setStyle("-fx-border-color: black;");

        canvas.setHeight(468.0);
        canvas.setId("canvas");
        canvas.setLayoutX(7.0);
        canvas.setLayoutY(8.0);
        canvas.setOnMousePressed(this::canvasOnMousePressed);
        canvas.setOnMouseReleased(this::canvasOnMouseReleased);
        canvas.setWidth(660.0);

        pane0.getChildren().add(textField);
        pane0.getChildren().add(button);
        pane0.getChildren().add(button0);
        pane.getChildren().add(pane0);
        pane1.getChildren().add(canvas);
        pane.getChildren().add(pane1);
        getChildren().add(pane);

    }

    protected abstract void openFileBrowser(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void reloadImage(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void canvasOnMousePressed(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void canvasOnMouseReleased(javafx.scene.input.MouseEvent mouseEvent);

}