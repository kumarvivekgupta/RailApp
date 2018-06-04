package com.test.naimish.railapp.Models;

/**
 * Created by Vivek on 6/5/2018.
 */

public class SeatStatusDisplayModel {
    private String trainName;
    private String sourceStationName;
    private String destinationStationName;
    private String trainQuota;
    private String trainJourneyClass;
    private String fromStationCode;
    private String toStationCode;


    public String getTrainName() {
        return trainName;
    }

    public String getSourceStationName() {
        return sourceStationName;
    }

    public String getDestinationStationName() {
        return destinationStationName;
    }

    public String getTrainQuota() {
        return trainQuota;
    }

    public String getTrainJourneyClass() {
        return trainJourneyClass;
    }

    public String getFromStationCode() {
        return fromStationCode;
    }

    public String getToStationCode() {
        return toStationCode;
    }

    public SeatStatusDisplayModel(String trainName, String sourceStationName, String destinationStationName, String trainQuota, String trainJourneyClass, String fromStationCode, String toStationCode) {
        this.trainName = trainName;
        this.sourceStationName = sourceStationName;
        this.destinationStationName = destinationStationName;
        this.trainQuota = trainQuota;
        this.trainJourneyClass = trainJourneyClass;
        this.fromStationCode = fromStationCode;
        this.toStationCode = toStationCode;
    }
}
