package com.sk02.sk02_gui_service.view.shared;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotificationsDialog extends Stage {

    private TextField tfType;
    private DatePicker dpStart;
    private DatePicker dpEnd;

    private VBox vbNotifications;

    public NotificationsDialog(){
        init();
    }

    private void init(){
        setTitle("Notifications");

        //title
        Label lblTitle = new Label("My Notifications");
        lblTitle.getStyleClass().add("title");

        //filter
        Label lblType = new Label("Type:");
        tfType = new TextField();
        tfType.setMaxWidth(100);

        Label lblDate = new Label("       Date:");
        dpStart = new DatePicker();
        dpStart.setMaxWidth(130);
        Label lblDash = new Label(" - ");
        dpEnd = new DatePicker();
        dpEnd.setMaxWidth(130);

        HBox hbFilter = new HBox();
        hbFilter.setPadding(new Insets(10));
        hbFilter.setAlignment(Pos.CENTER);
        hbFilter.setSpacing(10);
        hbFilter.getChildren().addAll(lblType, tfType, lblDate, dpStart, lblDash, dpEnd);

        //filter button
        Button btnFilter = new Button("Filter Notifications");
        btnFilter.setMinWidth(100);
        btnFilter.getStyleClass().add("button-blue");

        HBox hbFilterButton = new HBox();
        hbFilterButton.setPadding(new Insets(10));
        hbFilterButton.setAlignment(Pos.CENTER);
        hbFilterButton.getChildren().add(btnFilter);

        //vb top
        VBox vbTop = new VBox();
        vbTop.setAlignment(Pos.CENTER);
        vbTop.setPadding(new Insets(15));
        vbTop.getChildren().addAll(lblTitle, hbFilter, hbFilterButton);

        //list notifications
        vbNotifications = new VBox();
        vbNotifications.setAlignment(Pos.CENTER);
        vbNotifications.setPadding(new Insets(20));
        vbNotifications.setSpacing(20);

        ScrollPane spNotifications = new ScrollPane();
        spNotifications.setContent(vbNotifications);
        spNotifications.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spNotifications.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        vbNotifications.minWidthProperty().bind(spNotifications.widthProperty().multiply(0.95));


        //button
        Button btnBack = new Button("Back");
        btnBack.setMinWidth(80);
        btnBack.getStyleClass().add("button-orange");

        HBox hbButtons = new HBox();
        hbButtons.setPadding(new Insets(10));
        hbButtons.setAlignment(Pos.CENTER);
        hbButtons.getChildren().add(btnBack);

        //scene settings
        BorderPane bp = new BorderPane();
        bp.setTop(vbTop);
        bp.setCenter(spNotifications);
        bp.setBottom(hbButtons);

        Scene scene = new Scene(bp, 600, 620);
        setMinWidth(630);
        setMinHeight(410);
        scene.getStylesheets().add("styles/style.css");
        setScene(scene);
    }

    public TextField getTfType() {
        return tfType;
    }

    public DatePicker getDpStart() {
        return dpStart;
    }

    public DatePicker getDpEnd() {
        return dpEnd;
    }

    public VBox getVbNotifications() {
        return vbNotifications;
    }
}
