package com.sk02.sk02_gui_service.restclient.dto.review;

import java.util.ArrayList;
import java.util.List;

public class ReviewList {

    private List<ReviewDto> reviewDtos = new ArrayList<>();

    public ReviewList(){

    }

    public List<ReviewDto> getReviewDtos() {
        return reviewDtos;
    }

    public void setReviewDtos(List<ReviewDto> reviewDtos) {
        this.reviewDtos = reviewDtos;
    }
}
