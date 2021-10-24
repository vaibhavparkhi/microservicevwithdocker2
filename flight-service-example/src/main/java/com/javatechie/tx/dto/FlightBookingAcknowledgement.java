package com.javatechie.tx.dto;

import com.javatechie.tx.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {
    private String status;
    private Double toatlFare;
    private String pnr;
    private PassengerInfo passengerInfo;
}
