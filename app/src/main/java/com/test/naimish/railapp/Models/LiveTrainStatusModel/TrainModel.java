package com.test.naimish.railapp.Models.LiveTrainStatusModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.DaysModel;

/**
 * Created by Vivek on 3/17/2018.
 */

public class TrainModel {
    @SerializedName("days")
    @Expose
    private DaysModel[] trainDays;

    @SerializedName("name")
    @Expose
    private String trainName;

    @SerializedName("no")
    @Expose
    private String trainNumber;

    public DaysModel[] getTrainDays() {
        return trainDays;

    }

    public String getTrainName() {
        return trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }
}
