package com.sk02.sk02_gui_service.restclient.dto.hotel;

import com.sk02.sk02_gui_service.restclient.dto.hotel.HotelFilterViewDto;

import java.util.ArrayList;
import java.util.List;

public class HotelFilterList {

    private List<HotelFilterViewDto> hotelFilterViews = new ArrayList<>();

    public HotelFilterList(){

    }

    public List<HotelFilterViewDto> getHotelFilterViews() {
        return hotelFilterViews;
    }

    public void setHotelFilterViews(List<HotelFilterViewDto> hotelFilterViews) {
        this.hotelFilterViews = hotelFilterViews;
    }
}
