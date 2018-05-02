package com.test.naimish.railapp.Models;

/**
 * Created by Vivek on 4/20/2018.
 */

public class PassengerRecyclerModel {
    private String bookingStatus;
    private int passengerNo;
    private String currentStatus;

    public String getBookingStatus() {
        return bookingStatus;
    }

    public int getPassengerNo() {
        return passengerNo;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }


    public PassengerRecyclerModel( int passengerNo,String bookingStatus, String currentStatus) {
        this.bookingStatus = bookingStatus;
        this.passengerNo = passengerNo;
        this.currentStatus = currentStatus;
    }
}
