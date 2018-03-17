package com.test.naimish.railapp.Models.LiveTrainStatusModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 3/17/2018.
 */

public class StationModel {
    @SerializedName("code")
    private String stationCode;
    @SerializedName("name")
    private String stationName;

    public String getCode(){
        return stationCode;
    }
    public String getStationName(){
        return stationName;
    }
}
