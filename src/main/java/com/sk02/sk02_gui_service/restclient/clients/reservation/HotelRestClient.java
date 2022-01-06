package com.sk02.sk02_gui_service.restclient.clients.reservation;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk02.sk02_gui_service.model.UserData;
import com.sk02.sk02_gui_service.restclient.dto.hotel.HotelFilterList;
import com.sk02.sk02_gui_service.restclient.dto.hotel.HotelFilterDto;
import okhttp3.*;

import java.io.IOException;
import java.util.Date;

public class HotelRestClient {

    public static final String URL = "http://localhost:8084/reservation-service/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public HotelFilterList filterHotels(String name, String city, Date starDate, Date endDate, String priceSort) throws IOException {
        HotelFilterDto hotelFilterDto = new HotelFilterDto();

        if (name != null && !name.isEmpty()){
            hotelFilterDto.setName(name);
        }
        if(city != null && !city.isEmpty()){
            hotelFilterDto.setCity(city);
        }
        if(starDate != null){
            hotelFilterDto.setStartDate(starDate);
        }
        if(endDate != null){
            hotelFilterDto.setEndDate(endDate);
        }

        if(priceSort.equals("Low To High")){
            hotelFilterDto.setPriceSort("ASC");
        }
        else if(priceSort.equals("High To Low")){
            hotelFilterDto.setPriceSort("DESC");
        }
        else {
            hotelFilterDto.setPriceSort(null);
        }

        RequestBody body = RequestBody.create(objectMapper.writeValueAsString(hotelFilterDto), JSON);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Request request = new Request.Builder()
                .url(URL + "/filter")
                .header("Authorization", "Bearer " + UserData.getInstance().getToken())
                .post(body)
                .get()
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.code() == 200) {
            String json = response.body().string();

            return objectMapper.readValue(json, HotelFilterList.class);
        }

        throw new RuntimeException();
    }
}
