package com.sk02.sk02_gui_service.view.client;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ClientView extends Stage {

    private static ClientView instance;

    private TextField tfHotel;
    private TextField tfCity;
    private DatePicker dpStart;
    private DatePicker dpEnd;
    private ComboBox cbPrice;

    private TextField tfHotelReview;
    private TextField tfCityReview;

    private ClientView(){
        init();
    }

    public static ClientView getInstance(){
        if(instance == null){
            instance = new ClientView();
        }
        return instance;
    }

    private void init(){
        setTitle("GMTA Booking");

        //logout
        Button btnLogout = new Button("Logout");
        btnLogout.setMinWidth(80);
        btnLogout.getStyleClass().add("button-orange");

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

        Button btnNProfile = new Button("Edit Profile");
        btnNProfile.setMinWidth(80);
        btnNProfile.getStyleClass().add("button-orange");

        HBox hbTopRight = new HBox();
        hbTopRight.setAlignment(Pos.CENTER_RIGHT);
        hbTopRight.setPadding(new Insets(15));
        hbTopRight.setSpacing(10);
        hbTopRight.getChildren().addAll(btnNotifications, btnReservations, btnNProfile);

        //top pane
        BorderPane bpTop = new BorderPane();
        bpTop.setLeft(hbTopLeft);
        bpTop.setRight(hbTopRight);

        //center pane, left
        Label lblHotel = new Label("Hotel:");
        tfHotel = new TextField();
        tfHotel.setMaxWidth(130);

        Label lblCity = new Label("City:");
        tfCity = new TextField();
        tfCity.setMaxWidth(130);

        Label lblDate = new Label("Date:");
        dpStart = new DatePicker();
        dpStart.setMaxWidth(130);
        Label lblDash = new Label("-");
        dpEnd = new DatePicker();
        dpEnd.setMaxWidth(130);

        Label lblSort = new Label("Sort:");
        cbPrice = new ComboBox();
        cbPrice.setPromptText("Sort By");

        HBox hbButtonsLeft = new HBox();
        hbButtonsLeft.setAlignment(Pos.CENTER);
        hbButtonsLeft.setPadding(new Insets(10));
        hbButtonsLeft.setSpacing(10);
        hbButtonsLeft.getChildren().addAll(lblHotel, tfHotel, lblCity, tfCity, lblDate, dpStart, lblDash, dpEnd, lblSort, cbPrice);

        Button btnFilterHotels = new Button("Filter Hotels");
        btnFilterHotels.setMinWidth(100);
        btnFilterHotels.getStyleClass().add("button-blue");

        VBox vbLeft = new VBox();
        vbLeft.setAlignment(Pos.CENTER);
        vbLeft.setPadding(new Insets(10));
        vbLeft.setSpacing(5);
        vbLeft.getChildren().addAll(hbButtonsLeft, btnFilterHotels);

        BorderPane bpLeft = new BorderPane();
        //bpLeft.setMinWidth(1000);
        bpLeft.setTop(vbLeft);
        //TODO LIST HOTELS - BPLEFT.CENTER

        //center pane, right
        Label lblHotelReview = new Label("Hotel:");
        tfHotelReview = new TextField();
        tfHotelReview.setMaxWidth(130);

        Label lblCityReview = new Label("City:");
        tfCityReview = new TextField();
        tfCityReview.setMaxWidth(130);

        HBox hbFilterRight = new HBox();
        hbFilterRight.setAlignment(Pos.CENTER);
        hbFilterRight.setPadding(new Insets(10));
        hbFilterRight.setSpacing(10);
        hbFilterRight.getChildren().addAll(lblHotelReview, tfHotelReview, lblCityReview, tfCityReview);

        Button btnFilterReviews = new Button("Filter Reviews");
        btnFilterReviews.setMinWidth(100);
        btnFilterReviews.getStyleClass().add("button-blue");

        VBox vbRight = new VBox();
        vbRight.setAlignment(Pos.CENTER);
        vbRight.setPadding(new Insets(10));
        vbRight.setSpacing(5);
        vbRight.getChildren().addAll(hbFilterRight, btnFilterReviews);

        //bottom right
        HBox hbButtonsBottomRight = new HBox();
        hbButtonsBottomRight.setAlignment(Pos.CENTER);
        hbButtonsBottomRight.setPadding(new Insets(10));
        hbButtonsBottomRight.setSpacing(10);

        Button btnAddReview = new Button("Add Review");
        btnAddReview.setMinWidth(100);
        btnAddReview.getStyleClass().add("button-blue");

        Button btnMyReviews = new Button("My Reviews");
        btnMyReviews.setMinWidth(100);
        btnMyReviews.getStyleClass().add("button-orange");

        hbButtonsBottomRight.getChildren().addAll(btnAddReview, btnMyReviews);

        BorderPane bpRight = new BorderPane();
        bpRight.setTop(vbRight);
        //TODO LIST REVIEWS - BPRIGHT.CENTER
        bpRight.setBottom(hbButtonsBottomRight);

        //center
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(bpLeft, bpRight);
        splitPane.setDividerPositions(0.7);
        bpLeft.maxWidthProperty().bind(splitPane.widthProperty().multiply(0.7));
        bpRight.maxWidthProperty().bind(splitPane.widthProperty().multiply(0.3));

        //scene settings
        BorderPane bp = new BorderPane();
        bp.setTop(bpTop);
        bp.setCenter(splitPane);

        Scene scene = new Scene(bp, 1400, 700);
        setMinWidth(1430);
        setMinHeight(730);
        scene.getStylesheets().add("styles/style.css");
        setScene(scene);
    }

    public TextField getTfHotel() {
        return tfHotel;
    }

    public TextField getTfCity() {
        return tfCity;
    }

    public DatePicker getDpStart() {
        return dpStart;
    }

    public DatePicker getDpEnd() {
        return dpEnd;
    }

    public ComboBox getCbPrice() {
        return cbPrice;
    }

    public TextField getTfHotelReview() {
        return tfHotelReview;
    }

    public TextField getTfCityReview() {
        return tfCityReview;
    }
}
