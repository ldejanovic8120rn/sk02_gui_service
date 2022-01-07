package com.sk02.sk02_gui_service.view.client;

import com.sk02.sk02_gui_service.controller.HotelFilterController;
import com.sk02.sk02_gui_service.controller.ReviewFilterController;
import com.sk02.sk02_gui_service.view.client.dialogs.EditProfileClientDialog;
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

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


public class ClientView extends Stage {

    private static ClientView instance;

    private TextField tfHotel;
    private TextField tfCity;
    private DatePicker dpStart;
    private DatePicker dpEnd;
    private ComboBox cbPrice;

    private TextField tfHotelReview;
    private TextField tfCityReview;

    private Button btnFilterHotels;
    private Button btnFilterReviews;
    private VBox vbReviews;
    private VBox vbHotels;

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

        Button btnProfile = new Button("Edit Profile");
        btnProfile.setMinWidth(80);
        btnProfile.getStyleClass().add("button-orange");

        btnProfile.setOnAction(actionEvent -> {
            new EditProfileClientDialog().show();
        });

        HBox hbTopRight = new HBox();
        hbTopRight.setAlignment(Pos.CENTER_RIGHT);
        hbTopRight.setPadding(new Insets(15));
        hbTopRight.setSpacing(10);
        hbTopRight.getChildren().addAll(btnNotifications, btnReservations, btnProfile);

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
        dpStart.setMaxWidth(135);
        dpStart.setValue(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        Label lblDash = new Label("-");
        dpEnd = new DatePicker();
        dpEnd.setMaxWidth(135);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, 7);
        dpEnd.setValue(c.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        Label lblSort = new Label("Sort:");
        cbPrice = new ComboBox();
        cbPrice.setPromptText("Price:");
        cbPrice.getItems().addAll("Low To High", "High To Low");

        HBox hbButtonsLeft = new HBox();
        hbButtonsLeft.setAlignment(Pos.CENTER);
        hbButtonsLeft.setPadding(new Insets(10));
        hbButtonsLeft.setSpacing(10);
        hbButtonsLeft.getChildren().addAll(lblHotel, tfHotel, lblCity, tfCity, lblDate, dpStart, lblDash, dpEnd, lblSort, cbPrice);

        btnFilterHotels = new Button("Filter Hotels");
        btnFilterHotels.setMinWidth(100);
        btnFilterHotels.getStyleClass().add("button-blue");

        btnFilterHotels.setOnAction(new HotelFilterController());

        VBox vbLeft = new VBox();
        vbLeft.setAlignment(Pos.CENTER);
        vbLeft.setPadding(new Insets(10));
        vbLeft.setSpacing(5);
        vbLeft.getChildren().addAll(hbButtonsLeft, btnFilterHotels);

        //hotels scroll
        vbHotels = new VBox();
        vbHotels.setAlignment(Pos.CENTER);
        vbHotels.setPadding(new Insets(60));
        vbHotels.setSpacing(20);

        ScrollPane spHotels = new ScrollPane();
        spHotels.setContent(vbHotels);
        spHotels.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spHotels.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        vbHotels.minWidthProperty().bind(spHotels.widthProperty().multiply(0.95));

        BorderPane bpLeft = new BorderPane();
        bpLeft.setTop(vbLeft);
        bpLeft.setCenter(spHotels);

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

        btnFilterReviews = new Button("Filter Reviews");
        btnFilterReviews.setMinWidth(100);
        btnFilterReviews.getStyleClass().add("button-blue");

        btnFilterReviews.setOnAction(new ReviewFilterController());

        VBox vbRight = new VBox();
        vbRight.setAlignment(Pos.CENTER);
        vbRight.setPadding(new Insets(10));
        vbRight.setSpacing(5);
        vbRight.getChildren().addAll(hbFilterRight, btnFilterReviews);

        //reviews scroll
        vbReviews = new VBox();
        vbReviews.setAlignment(Pos.CENTER);
        vbReviews.setPadding(new Insets(20));
        vbReviews.setSpacing(20);

        ScrollPane spReviews = new ScrollPane();
        spReviews.setContent(vbReviews);
        spReviews.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spReviews.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        vbReviews.minWidthProperty().bind(spReviews.widthProperty().multiply(0.95));

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
        bpRight.setCenter(spReviews);
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

    public void refresh(){
        btnFilterHotels.fire();
        btnFilterReviews.fire();
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

    public VBox getVbReviews() {
        return vbReviews;
    }

    public VBox getVbHotels() {
        return vbHotels;
    }
}
