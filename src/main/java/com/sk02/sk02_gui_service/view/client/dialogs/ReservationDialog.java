package com.sk02.sk02_gui_service.view.client.dialogs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReservationDialog extends Stage {

    private Label lblHotel;
    private Label lblDescription;
    private Label lblCity;
    private Label lblCategory;
    private Label lblPrice;

    public ReservationDialog(){
        init();
    }

    private void init(){
        setTitle("Reserve Accommodation");

        //title
        lblHotel = new Label();
        lblHotel.getStyleClass().add("title");
        HBox hbTitle = new HBox();
        hbTitle.setAlignment(Pos.CENTER);
        hbTitle.setPadding(new Insets(15));
        hbTitle.getChildren().add(lblHotel);

        //hotel info
        //TODO
        lblDescription = new Label();
        lblCity = new Label();
        lblCategory = new Label();
        lblPrice = new Label();

        //center vb
        VBox vbMain = new VBox();
        vbMain.setAlignment(Pos.CENTER);
        vbMain.setPadding(new Insets(15));
        vbMain.getChildren().addAll(lblDescription, lblCity, lblCategory, lblPrice);

        //buttons
        Button btnReserve = new Button("Reserve");
        btnReserve.setMinWidth(100);
        btnReserve.getStyleClass().add("button-blue");

        Button btnCancel = new Button("Cancel");
        btnCancel.setMinWidth(100);
        btnCancel.getStyleClass().add("button-orange");

        HBox hbButtons = new HBox();
        hbButtons.setPadding(new Insets(10));
        hbButtons.setAlignment(Pos.CENTER);
        hbButtons.setSpacing(10);
        hbButtons.getChildren().addAll(btnReserve, btnCancel);

        //scene settings
        BorderPane bp = new BorderPane();
        bp.setTop(hbTitle);
        bp.setCenter(vbMain);
        bp.setBottom(hbButtons);

        Scene scene = new Scene(bp, 500, 400);
        setMinWidth(510);
        setMinHeight(410);
        scene.getStylesheets().add("styles/style.css");
        setScene(scene);
    }

    public Label getLblHotel() {
        return lblHotel;
    }

    public Label getLblDescription() {
        return lblDescription;
    }

    public Label getLblCity() {
        return lblCity;
    }

    public Label getLblCategory() {
        return lblCategory;
    }

    public Label getLblPrice() {
        return lblPrice;
    }
}
