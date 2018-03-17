package com.test.naimish.railapp.Models.LiveTrainStatusModel.TrainInfoModel;

import android.app.ProgressDialog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 3/17/2018.
 */

public class DaysModel {
    @SerializedName("runs")
    private char trainRuns;
    @SerializedName("code")
    private String trainCode;

    public char getTrainRun() {
        return trainRuns;

    }

    public String getTrainCode() {
        return trainCode;
    }

}
