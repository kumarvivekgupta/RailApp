package com.test.naimish.railapp.Models.LiveTrainStatusModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Vivek on 3/17/2018.
 */

public class TrainModel {
    @SerializedName("name")
    @Expose
    private String trainName;

    public String getTrainName() {
        return trainName;
    }
}
