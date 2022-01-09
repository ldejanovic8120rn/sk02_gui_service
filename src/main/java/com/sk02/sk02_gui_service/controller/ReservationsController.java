package com.sk02.sk02_gui_service.controller;

import com.sk02.sk02_gui_service.model.UserData;
import com.sk02.sk02_gui_service.restclient.clients.reservation.ReservationRestClient;
import com.sk02.sk02_gui_service.restclient.dto.reservation.ReservationDto;
import com.sk02.sk02_gui_service.view.client.dialogs.ReservationsClientDialog;
import com.sk02.sk02_gui_service.view.panes.ReservationPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.util.List;

public class ReservationsController implements EventHandler<ActionEvent> {

    private ReservationRestClient reservationRestClient;

    public ReservationsController(){
        reservationRestClient = new ReservationRestClient();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            if (UserData.getInstance().getRole().equals("CLIENT")){
                List<ReservationDto> reservations = reservationRestClient.getClientReservations();

                ReservationsClientDialog.getInstance().getVbReservations().getChildren().clear();
                for (ReservationDto reservationDto: reservations){
                    ReservationsClientDialog.getInstance().getVbReservations().getChildren().add(new ReservationPane(reservationDto));
                }
                ReservationsClientDialog.getInstance().show();
            }
            else if (UserData.getInstance().getRole().equals("MANAGER")){
                List<ReservationDto> reservations = reservationRestClient.getManagerReservations();
                //TODO
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}