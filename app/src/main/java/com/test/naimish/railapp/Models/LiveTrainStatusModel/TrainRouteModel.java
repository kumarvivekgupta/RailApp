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


    @SerializedName("actarr")
    @Expose
    private String mActualArrval;

    @SerializedName("schdep")
    @Expose
    private String mSchduledeparture;

    @SerializedName("actdep")
    @Expose
    private String mActualDeparture;


    @SerializedName("latemin")
    @Expose
    private String mLateMin;

    @SerializedName("station")
    @Expose
    private StationModel mStation;


    public String getAccArr() {
        return mActualArrval;
    }

    public String getSchdep() {
        return mSchduledeparture;
    }

    public String getActDep() {
        return mActualDeparture;
    }

    public StationModel getStation() {
        return mStation;
    }

    public String getSchduleArrival() {
        return mSchduleArrival;
    }

    public String getLateMin() {
        return mLateMin;
    }


}
