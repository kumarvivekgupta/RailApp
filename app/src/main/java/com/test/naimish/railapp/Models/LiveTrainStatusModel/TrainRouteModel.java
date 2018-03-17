package com.test.naimish.railapp.Models.LiveTrainStatusModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 3/17/2018.
 */

public class TrainRouteModel {


    @SerializedName("distance")
    private String mDistance;


    @SerializedName("actarr")
    private String mAccArr;
    @SerializedName("schdep")
    private String mSchdep;
    @SerializedName("day")
    private String mDay;
    @SerializedName("actdep")
    private String mActDep;
    @SerializedName("has_arrived")
    private boolean mHasArrived;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("station")
    private StationModel mStation;

    public String getDistance() {
        return mDistance;
    }

    public String getAccArr() {
        return mAccArr;
    }

    public String getSchdep() {
        return mSchdep;
    }

    public String getDay() {
        return mDay;
    }

    public String getActDep() {
        return mActDep;
    }

    public boolean isHasArrived() {
        return mHasArrived;
    }

    public String getStatus() {
        return mStatus;
    }

    public StationModel getStation() {
        return mStation;
    }


}
