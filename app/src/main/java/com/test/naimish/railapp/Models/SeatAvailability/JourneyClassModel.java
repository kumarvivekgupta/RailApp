package com.test.naimish.railapp.Models.SeatAvailability;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 5/27/2018.
 */

public class JourneyClassModel {

    @SerializedName("name")
    @Expose
    private String journeyClassName;

    @SerializedName("code")
    @Expose
    private String journeyCode;

}
