package com.sk02.sk02_gui_service.restclient.clients.reservation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk02.sk02_gui_service.model.UserData;
import com.sk02.sk02_gui_service.restclient.dto.hotel.HotelFilterList;
import com.sk02.sk02_gui_service.restclient.dto.review.ReviewFilterDto;
import com.sk02.sk02_gui_service.restclient.dto.review.ReviewList;
import okhttp3.*;

import java.io.IOException;

public class ReviewRestClient {

    public static final String URL = "http://localhost:8084/reservation-service/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();


    public ReviewList filterReviews(String city, String hotelName) throws IOException {
        ReviewFilterDto reviewFilterDto = new ReviewFilterDto();

        if(city != null && !city.isEmpty()){
            reviewFilterDto.setCity(city);
        }
        if(hotelName != null && !hotelName.isEmpty()){
            reviewFilterDto.setHotelName(hotelName);
        }

        RequestBody body = RequestBody.create(objectMapper.writeValueAsString(reviewFilterDto), JSON);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Request request = new Request.Builder()
                .url(URL + "/reviews")
                .header("Authorization", "Bearer " + UserData.getInstance().getToken())
                .post(body)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200) {
            String json = response.body().string();

            return objectMapper.readValue(json, ReviewList.class);
        }

        throw new RuntimeException();
    }
}
