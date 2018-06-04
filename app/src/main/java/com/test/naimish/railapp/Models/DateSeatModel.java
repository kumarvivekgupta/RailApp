package com.test.naimish.railapp.Models;

import com.test.naimish.railapp.Models.SeatAvailability.SeatAvailabiityModelClass;

import java.util.ArrayList;

/**
 * Created by Vivek on 6/6/2018.
 */

public class DateSeatModel {
   private String mDate;
   private String mSeatStatus;

    public String getmDate() {
        return mDate;
    }

    public String getmSeatStatus() {
        return mSeatStatus;
    }

    public DateSeatModel(String date, String seatStatus){
        this.mDate=date;
        this.mSeatStatus=seatStatus;


    }
}
