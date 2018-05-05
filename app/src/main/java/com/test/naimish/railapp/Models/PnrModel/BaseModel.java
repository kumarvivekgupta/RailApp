package com.test.naimish.railapp.Models.PnrModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by naimish on 2/22/2018.
 */

public class BaseModel {
    @SerializedName("pnr")
    @Expose
    private String pnr;

    @SerializedName("from_station")
    @Expose
    private StationModel fromStation;

    @SerializedName("to_station")
    @Expose
    private StationModel toStation;

    @SerializedName("train")
    @Expose
    private TrainModel trainNumber;

    @SerializedName("passengers")
    @Expose
    private PassengerModel[] passengersDetails;


    @SerializedName("chart_prepared")
    @Expose
    private Boolean chartPrepared;


    public String getPnr() {
        return pnr;
    }

    public StationModel getFromStation() {
        return fromStation;
    }

    public StationModel getToStation() {
        return toStation;
    }

    public TrainModel getTrainNumber() {
        return trainNumber;
    }

    public PassengerModel[] getPassengersDetails() {
        return passengersDetails;
    }

    public Boolean getChartPrepared() {
        return chartPrepared;
    }
}
