package com.test.naimish.railapp.Models.LiveTrainStatusModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 3/17/2018.
 */

public class TrainRouteModel {
    @SerializedName("scharr")
    @Expose
    private String mSchduleArrival;


    @SerializedName("distance")
    @Expose
    private String mDistance;


    @SerializedName("actarr")
    @Expose
    private String mActualArrval;

    @SerializedName("schdep")
    @Expose
    private String mSchduledeparture;

    @SerializedName("day")
    @Expose
    private String mDay;

    @SerializedName("actdep")
    @Expose
    private String mActualDeparture;

    @SerializedName("has_arrived")
    @Expose
    private boolean mHasArrived;

    @SerializedName("status")
    @Expose
    private String mStatus;

    @SerializedName("station")
    @Expose
    private StationModel mStation;

    public String getDistance() {
        return mDistance;
    }

    public String getAccArr() {
        return mActualArrval;
    }

    public String getSchdep() {
        return mSchduledeparture;
    }

    public String getDay() {
        return mDay;
    }

    public String getActDep() {
        return mActualDeparture;
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

    public String getSchduleArrival() {
        return mSchduleArrival;
    }


}
