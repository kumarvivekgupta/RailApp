package com.test.naimish.railapp.Models;

public class StationStatusDisplayModel {

    private String stationName;
    private String fromStation;
    private String toStation;
    private String actualArrival;
    private String scheduledArival;
    private String actualDeparture;
    private String scheduledDepartire;
    private String late;
    private String currentStatus;

    public StationStatusDisplayModel(String stationName, String fromStation, String toStation, String actualArrival, String scheduledArival, String actualDeparture, String scheduledDepartire, String late, String currentStatus) {
        this.stationName = stationName;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.actualArrival = actualArrival;
        this.scheduledArival = scheduledArival;
        this.actualDeparture = actualDeparture;
        this.scheduledDepartire = scheduledDepartire;
        this.late = late;
        this.currentStatus = currentStatus;
    }

    public String getStationName() {
        return stationName;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public String getActualArrival() {
        return actualArrival;
    }

    public String getScheduledArival() {
        return scheduledArival;
    }

    public String getActualDeparture() {
        return actualDeparture;
    }

    public String getScheduledDepartire() {
        return scheduledDepartire;
    }

    public String getLate() {
        return late;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }
}
