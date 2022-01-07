package com.sk02.sk02_gui_service.controller;

import com.sk02.sk02_gui_service.restclient.clients.reservation.HotelRestClient;
import com.sk02.sk02_gui_service.restclient.dto.hotel.HotelFilterDto;
import com.sk02.sk02_gui_service.restclient.dto.hotel.HotelFilterList;
import com.sk02.sk02_gui_service.restclient.dto.hotel.HotelFilterViewDto;
import com.sk02.sk02_gui_service.view.client.ClientView;
import com.sk02.sk02_gui_service.view.panes.HotelPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class HotelFilterController implements EventHandler<ActionEvent> {

    private HotelRestClient hotelRestClient;

    public HotelFilterController(){
        hotelRestClient = new HotelRestClient();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ClientView.getInstance().getVbHotels().getChildren().removeAll();

        String name = ClientView.getInstance().getTfHotel().getText();
        String city = ClientView.getInstance().getTfCity().getText();

        LocalDate localDate = ClientView.getInstance().getDpStart().getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date dateStart = Date.from(instant);

        localDate = ClientView.getInstance().getDpEnd().getValue();
        instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date dateEnd = Date.from(instant);

        String priceSort = (String) ClientView.getInstance().getCbPrice().getValue();  //bude null!!!

        try {
            HotelFilterList hotelFilterList = hotelRestClient.filterHotels(name, city, dateStart, dateEnd, "Low To High");

            for (HotelFilterViewDto hfv : hotelFilterList.getHotelFilterViews()){
                ClientView.getInstance().getVbHotels().getChildren().add(new HotelPane(hfv));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
