package com.test.naimish.railapp.Models.PnrModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by naimish on 2/22/2018.
 */

public class StationModel {
    @SerializedName("code")
    @Expose
    private String stationCode;

    @SerializedName("name")
    @Expose
    private String stationName;

    public String getStationCode() {
        return stationCode;
    }

    public String getStationName() {
        return stationName;
    }
}
