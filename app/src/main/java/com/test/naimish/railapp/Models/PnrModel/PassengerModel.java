package com.test.naimish.railapp.Models.PnrModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by naimish on 2/22/2018.
 */

public class PassengerModel {
    @SerializedName("booking_status")
    @Expose
    private String bookingStatus;

    @SerializedName("current_status")
    @Expose

    private String currentStatus;
    @SerializedName("no")
    @Expose
    private int passengerNo;

    public String getBookingStatus() {
        return bookingStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public int getPassengerNo() {
        return passengerNo;
    }
}
