package com.test.naimish.railapp.Models.LiveTrainStatusModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 3/17/2018.
 */

public class LiveStatusBaseModel {


    @SerializedName("position")
    @Expose
    private String trainPosition;

    @SerializedName("current_station")
    @Expose
    private CurrentStationModel trainCurrentStation;

    @SerializedName("route")
    @Expose
    private TrainRouteModel[] trainRoute;


    @SerializedName("train")
    @Expose
    private TrainModel trainInfo;

    @SerializedName("start_date")
    @Expose
    private String trainStartDate;

    public String getPosition() {
        return trainPosition;
    }

    public CurrentStationModel getCurrentStation() {
        return trainCurrentStation;
    }

    public TrainRouteModel[] getRoute() {
        return trainRoute;
    }

    public TrainModel getTrainInfo() {
        return trainInfo;
    }

    public String getTrainStartDate() {
        return trainStartDate;
    }

}
