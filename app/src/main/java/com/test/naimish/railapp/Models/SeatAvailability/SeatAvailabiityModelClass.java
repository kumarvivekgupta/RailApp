package com.test.naimish.railapp.Models.SeatAvailability;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 5/27/2018.
 */

public class SeatAvailabiityModelClass {
    @SerializedName("date")
    @Expose
    private String traindate;

    @SerializedName("status")
    @Expose
    private String seatStatus;

    public String getTraindate() {
        return traindate;
    }

    public String getSeatStatus() {
        return seatStatus;
    }
}
