package com.sk02.sk02_gui_service.restclient.clients.reservation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk02.sk02_gui_service.model.UserData;
import com.sk02.sk02_gui_service.restclient.dto.reservation.ReservationCreateDto;
import okhttp3.*;

import java.io.IOException;
import java.util.Date;

public class ReservationRestClient {

    public static final String URL = "http://localhost:8084/reservation-service/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public void makeReservation(Date startDate, Date endDate, Long hotelId, Long roomTypeId) throws IOException {
        ReservationCreateDto reservationCreateDto = new ReservationCreateDto();
        reservationCreateDto.setStartDate(startDate);
        reservationCreateDto.setEndDate(endDate);
        reservationCreateDto.setHotelId(hotelId);
        reservationCreateDto.setRoomTypeId(roomTypeId);

        RequestBody body = RequestBody.create(objectMapper.writeValueAsString(reservationCreateDto), JSON);

        Request request = new Request.Builder()
                .url(URL + "/reservations")
                .header("Authorization", "Bearer " + UserData.getInstance().getToken())
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if(response.code() == 201){
            return;
        }

        throw new RuntimeException("Reservation Failed");
    }
}
