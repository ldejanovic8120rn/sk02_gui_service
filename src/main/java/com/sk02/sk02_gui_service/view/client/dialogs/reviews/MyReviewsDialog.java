package com.sk02.sk02_gui_service.view.client.dialogs.reviews;

import com.sk02.sk02_gui_service.restclient.dto.ReviewDto;
import com.sk02.sk02_gui_service.view.panes.MyReviewPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyReviewsDialog extends Stage {

    private VBox vbReviews;

    public MyReviewsDialog(){
        init();
    }

    private void init(){
        setTitle("My Reviews");

        //title
        Label lblTitle = new Label("My Reviews");
        lblTitle.getStyleClass().add("title");
        HBox hbTitle = new HBox();
        hbTitle.setAlignment(Pos.CENTER);
        hbTitle.setPadding(new Insets(15));
        hbTitle.getChildren().add(lblTitle);

        //review list
        vbReviews = new VBox();
        vbReviews.setAlignment(Pos.CENTER);
        vbReviews.setPadding(new Insets(20));
        vbReviews.setSpacing(20);

        ScrollPane spReviews = new ScrollPane();
        spReviews.setContent(vbReviews);
        spReviews.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spReviews.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        vbReviews.minWidthProperty().bind(spReviews.widthProperty().multiply(0.95));

        /*ReviewDto reviewDto = new ReviewDto();
        reviewDto.setComment("Neki komentar ashdbas asdasd etrfs dfsd qweas as afasdasd asdasd QWQWE ASASDAS");
        reviewDto.setHotelName("Hotel hotel");
        reviewDto.setRate(4);
        reviewDto.setUsername("laki");
        for (int i = 0; i < 10; i++)
            vbReviews.getChildren().add(new MyReviewPane(reviewDto));*/

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
        bp.setTop(hbTitle);
        bp.setCenter(spReviews);
        bp.setBottom(hbButtons);

        Scene scene = new Scene(bp, 500, 600);
        setMinWidth(510);
        setMinHeight(410);
        scene.getStylesheets().add("styles/style.css");
        setScene(scene);
    }

    public VBox getVbReviews() {
        return vbReviews;
    }
}
