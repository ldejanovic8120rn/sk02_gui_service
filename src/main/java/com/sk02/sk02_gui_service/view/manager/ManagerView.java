package com.sk02.sk02_gui_service.view.manager;

import com.sk02.sk02_gui_service.model.UserData;
import com.sk02.sk02_gui_service.view.LoginView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagerView extends Stage {

    private static ManagerView instance;

    private Label lblName;
    private Label lblDescription;
    private Label lblCity;

    private ManagerView(){
        init();
    }

    public static ManagerView getInstance(){
        if(instance == null){
            instance = new ManagerView();
        }
        return instance;
    }

    private void init(){
        setTitle("GMTA Manager");

        //logout
        Button btnLogout = new Button("Logout");
        btnLogout.setMinWidth(80);
        btnLogout.getStyleClass().add("button-orange");

        btnLogout.setOnAction(actionEvent -> {
            this.close();
            UserData.getInstance().logOut();
            LoginView.getInstance().clean();
            LoginView.getInstance().show();
        });

        HBox hbTopLeft = new HBox();
        hbTopLeft.setAlignment(Pos.CENTER_LEFT);
        hbTopLeft.setPadding(new Insets(15));
        hbTopLeft.getChildren().add(btnLogout);

        //right panel
        Button btnNotifications = new Button();
        btnNotifications.setMinWidth(30);
        btnNotifications.getStyleClass().add("notification-button");
        Image image = new Image("icons/notif_icon.png");
        ImageView icon = new ImageView(image);
        btnNotifications.setGraphic(icon);

        Button btnReservations = new Button("My Reservations");
        btnReservations.setMinWidth(80);
        btnReservations.getStyleClass().add("button-blue");

        Button btnProfile = new Button("Edit Profile");
        btnProfile.setMinWidth(80);
        btnProfile.getStyleClass().add("button-orange");

        HBox hbTopRight = new HBox();
        hbTopRight.setAlignment(Pos.CENTER_RIGHT);
        hbTopRight.setPadding(new Insets(15));
        hbTopRight.setSpacing(10);
        hbTopRight.getChildren().addAll(btnNotifications, btnReservations, btnProfile);

        //top pane
        BorderPane bpTop = new BorderPane();
        bpTop.setLeft(hbTopLeft);
        bpTop.setRight(hbTopRight);

        //center
        Label lblTitle = new Label("My Hotel:");
        lblTitle.getStyleClass().add("title");

        lblName = new Label("Test");
        lblCity = new Label("Proba");
        lblDescription = new Label("ASdas asdasd asdasd asd asdasd asdf");

        VBox vbCenter = new VBox();
        vbCenter.setAlignment(Pos.TOP_CENTER);
        vbCenter.setPadding(new Insets(15));
        vbCenter.getChildren().addAll(lblTitle, lblName, lblCity, lblDescription);

        //bottom
        Button btnRoomTypes = new Button("Room Types");
        btnRoomTypes.setMinWidth(100);
        btnRoomTypes.getStyleClass().add("button-orange");

        Button btnEditHotel = new Button("Edit Hotel");
        btnEditHotel.setMinWidth(100);
        btnEditHotel.getStyleClass().add("button-blue");

        VBox vbButtons = new VBox();
        vbButtons.setAlignment(Pos.CENTER);
        vbButtons.setPadding(new Insets(15));
        vbButtons.setSpacing(10);
        vbButtons.getChildren().addAll(btnRoomTypes, btnEditHotel);

        //scene settings
        BorderPane bp = new BorderPane();
        bp.setTop(bpTop);
        bp.setCenter(vbCenter);
        bp.setBottom(vbButtons);

        Scene scene = new Scene(bp, 800, 350);
        setMinWidth(820);
        setMinHeight(370);
        scene.getStylesheets().add("styles/style.css");
        setScene(scene);
    }

    public Label getLblName() {
        return lblName;
    }

    public Label getLblDescription() {
        return lblDescription;
    }

    public Label getLblCity() {
        return lblCity;
    }
}
