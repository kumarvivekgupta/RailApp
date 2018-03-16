package com.test.naimish.railapp.Models.LiveTrainStatusModel.TrainInfoModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 3/17/2018.
 */

public class TrainModel {
    @SerializedName("days")
    private DaysModel[] trainDays;
    @SerializedName("name")
    private String trainName;
    @SerializedName("no")
    private String trainNumber;

    public DaysModel[] getTrainDays() {
        return trainDays;

    }

    public String getTrainName(){
        return trainName;
    }
    public String getTrainNumber(){
        return trainNumber;
    }
}
