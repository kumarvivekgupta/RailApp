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

    @SerializedName("route")
    @Expose
    private TrainRouteModel[] trainRoute;


    @SerializedName("train")
    @Expose
    private TrainModel trainInfo;

    public String getPosition() {
        return trainPosition;
    }

    public TrainRouteModel[] getRoute() {
        return trainRoute;
    }

    public TrainModel getTrainInfo() {
        return trainInfo;
    }

}

/*
train name -
from -
to -
date -
latest update -
act arrival -
sch arrival -
act departure -
sch departure -
dep delay -
arr delay -
*/



