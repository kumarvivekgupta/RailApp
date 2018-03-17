package com.test.naimish.railapp.Models.LiveTrainStatusModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 3/17/2018.
 */

public class CurrentStationModel {
    @SerializedName("code")
    private String mCode;
    @SerializedName("name")
    private String mName;

    public String getName()
    {
        return this.mName;
    }
    public String getCode(){
        return this.mCode;
    }

}
