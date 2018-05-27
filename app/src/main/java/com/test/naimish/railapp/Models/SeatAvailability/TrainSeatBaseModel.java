package com.test.naimish.railapp.Models.SeatAvailability;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.test.naimish.railapp.Models.PnrModel.StationModel;

/**
 * Created by Vivek on 5/27/2018.
 */

public class TrainSeatBaseModel {

    @SerializedName("from_station")
    @Expose
    private StationModel fromStation;

    @SerializedName("to_station")
    @Expose
    private StationModel toStation;

    @SerializedName("journey_class")
    @Expose
    private JourneyClassModel journeyClass;

    @SerializedName("quota")
    @Expose
    private QuotaModel trainQuota;

    @SerializedName("availability")
    @Expose
    private SeatAvailabiityModelClass[] trainSeatAvailability;


    public StationModel getFromStation() {
        return fromStation;
    }

    public StationModel getToStation() {
        return toStation;
    }

    public JourneyClassModel getJourneyClass() {
        return journeyClass;
    }

    public QuotaModel getTrainQuota() {
        return trainQuota;
    }

    public SeatAvailabiityModelClass[] getTrainSeatAvailability() {
        return trainSeatAvailability;
    }
}
