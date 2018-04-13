package com.test.naimish.railapp.Models.LiveTrainStatusModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 3/17/2018.
 */

public class DaysModel {

    @SerializedName("runs")
    @Expose
    private char trainRuns;

    @SerializedName("code")
    @Expose
    private String trainCode;

    public char getTrainRun() {
        return trainRuns;

    }

    public String getTrainCode() {
        return trainCode;
    }

}
