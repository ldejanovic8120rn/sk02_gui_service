package com.sk02.sk02_gui_service.view.manager.dialogs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ReservationsManagerDialog extends Stage {

    public ReservationsManagerDialog(){
        init();
    }

    private void init(){
        setTitle("Reservations");

        //title
        Label lblTitle = new Label("All Reservations");
        lblTitle.getStyleClass().add("title");
        HBox hbTitle = new HBox();
        hbTitle.setAlignment(Pos.CENTER);
        hbTitle.setPadding(new Insets(15));
        hbTitle.getChildren().add(lblTitle);

        //reseervations list
        //TODO

        //button
        Button btnBack = new Button("Back");
        btnBack.setMinWidth(80);
        btnBack.getStyleClass().add("button-blue");

        HBox hbButtons = new HBox();
        hbButtons.setPadding(new Insets(10));
        hbButtons.setAlignment(Pos.CENTER);
        hbButtons.getChildren().add(btnBack);

        //scene settings
        BorderPane bp = new BorderPane();
        bp.setTop(hbTitle);
        //bp.setCenter(vbMain);
        bp.setBottom(hbButtons);

        Scene scene = new Scene(bp, 500, 450);
        setMinWidth(510);
        setMinHeight(410);
        scene.getStylesheets().add("styles/style.css");
        setScene(scene);
    }
}
