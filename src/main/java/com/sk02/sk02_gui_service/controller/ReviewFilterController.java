package com.sk02.sk02_gui_service.controller;

import com.sk02.sk02_gui_service.restclient.clients.reservation.ReviewRestClient;
import com.sk02.sk02_gui_service.restclient.dto.review.ReviewDto;
import com.sk02.sk02_gui_service.restclient.dto.review.ReviewList;
import com.sk02.sk02_gui_service.view.client.ClientView;
import com.sk02.sk02_gui_service.view.panes.ReviewPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;

public class ReviewFilterController implements EventHandler<ActionEvent> {

    private ReviewRestClient reviewRestClient;

    public ReviewFilterController(){
        reviewRestClient = new ReviewRestClient();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ClientView.getInstance().getVbReviews().getChildren().removeAll();

        String hotelName = ClientView.getInstance().getTfHotelReview().getText();
        String city = ClientView.getInstance().getTfCityReview().getText();

        try {
            ReviewList reviewList = reviewRestClient.filterReviews(city, hotelName);

            for(ReviewDto reviewDto: reviewList.getReviewDtos()){
                ClientView.getInstance().getVbReviews().getChildren().add(new ReviewPane(reviewDto));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
