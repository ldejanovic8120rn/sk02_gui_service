package com.sk02.sk02_gui_service.view.manager.dialogs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RoomTypesDialog extends Stage {

    private TextField tfCategory;
    private TextField tfPrice;
    private TextField tfLowerB;
    private TextField tfUpperB;

    public RoomTypesDialog(){
        init();
    }

    private void init(){
        setTitle("Room Types");

        //left
        Label lblTitleLeft = new Label("Room Types:");
        lblTitleLeft.getStyleClass().add("title");

        VBox vbLeft = new VBox();
        vbLeft.setAlignment(Pos.TOP_CENTER);
        vbLeft.setPadding(new Insets(15));
        vbLeft.getChildren().addAll(lblTitleLeft);
        //TODO LIST ROOM TYPES

        //right
        Button btnBack = new Button("Back");
        btnBack.setMinWidth(80);
        btnBack.getStyleClass().add("button-orange");

        HBox hbBack = new HBox();
        hbBack.setAlignment(Pos.CENTER_RIGHT);
        hbBack.setPadding(new Insets(15));
        hbBack.getChildren().add(btnBack);

        Label lblTitleRight = new Label("Create New Type:");
        lblTitleRight.setPadding(new Insets(30));
        lblTitleRight.getStyleClass().add("title");

        Label lblCategory = new Label("Category:");
        tfCategory = new TextField();
        tfCategory.setMaxWidth(100);

        Label lblPrice = new Label("Price:");
        tfPrice = new TextField();
        tfPrice.setMaxWidth(100);

        Label lblLowerB = new Label("Lower Bound:");
        tfLowerB = new TextField();
        tfLowerB.setMaxWidth(100);

        Label lblUpperB = new Label("Upper Bound:");
        tfUpperB = new TextField();
        tfUpperB.setMaxWidth(100);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.add(lblCategory, 0, 0);
        gridPane.add(tfCategory, 1, 0);

        gridPane.add(lblPrice, 0, 1);
        gridPane.add(tfPrice, 1, 1);

        gridPane.add(lblLowerB, 0, 2);
        gridPane.add(tfLowerB, 1, 2);

        gridPane.add(lblUpperB, 0, 3);
        gridPane.add(tfUpperB, 1, 3);

        Button btnAddType = new Button("Add Type");
        btnAddType.setMinWidth(80);
        btnAddType.getStyleClass().add("button-blue");

        VBox vbRight = new VBox();
        vbRight.setAlignment(Pos.TOP_CENTER);
        vbRight.setPadding(new Insets(15));
        vbRight.setSpacing(15);
        vbRight.getChildren().addAll(hbBack, lblTitleRight, gridPane, btnAddType);

        //scene settings
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(vbLeft, vbRight);
        splitPane.setDividerPositions(0.6);
        vbLeft.maxWidthProperty().bind(splitPane.widthProperty().multiply(0.6));
        vbRight.maxWidthProperty().bind(splitPane.widthProperty().multiply(0.4));

        Scene scene = new Scene(splitPane, 1000, 600);
        setMinWidth(1010);
        setMinHeight(610);
        scene.getStylesheets().add("styles/style.css");
        setScene(scene);
    }

    public TextField getTfCategory() {
        return tfCategory;
    }

    public TextField getTfPrice() {
        return tfPrice;
    }

    public TextField getTfLowerB() {
        return tfLowerB;
    }

    public TextField getTfUpperB() {
        return tfUpperB;
    }
}
