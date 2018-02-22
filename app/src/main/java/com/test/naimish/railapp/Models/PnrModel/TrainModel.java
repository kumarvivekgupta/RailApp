package com.test.naimish.railapp.Models.PnrModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by naimish on 2/22/2018.
 */

public class TrainModel {
    @SerializedName("number")
    @Expose
    private String trainNumber;

    @SerializedName("name")
    @Expose
    private String trainName;

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }
}
