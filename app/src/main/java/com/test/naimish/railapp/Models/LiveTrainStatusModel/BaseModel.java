package com.test.naimish.railapp.Models.LiveTrainStatusModel;

import com.google.gson.annotations.SerializedName;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.TrainInfoModel.TrainModel;

/**
 * Created by Vivek on 3/17/2018.
 */

public class BaseModel {


    @SerializedName("position")
    private String mPosition;

    @SerializedName("current_station")
    private CurrentStationModel mCurrentStation;

    @SerializedName("route")
    private TrainRouteModel[] mRoute;
    @SerializedName("train")
    private TrainModel trainInfo;
    @SerializedName("start_date")
    private String trainStartDate;

    public String getPosition() {
        return mPosition;
    }

    public CurrentStationModel getCurrentStation() {
        return mCurrentStation;
    }

    public TrainRouteModel[] getRoute() {
        return mRoute;
    }

    public TrainModel getTrainInfo() {
        return trainInfo;
    }

    public String getTrainStartDate() {
        return trainStartDate;
    }

}
