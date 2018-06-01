package com.test.naimish.railapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.test.naimish.railapp.Models.PnrModel.StationModel;

/**
 * Created by Vivek on 5/30/2018.
 */

public class StationAutoCompleteBaseModel {

    @SerializedName("stations")
    @Expose
    private StationModel[] trainStations;

    public StationModel[] getTrainStations() {
        return trainStations;
    }
}
