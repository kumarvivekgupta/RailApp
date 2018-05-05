package com.test.naimish.railapp.Utils;


import com.google.gson.Gson;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.LiveStatusBaseModel;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.TrainRouteModel;
import com.test.naimish.railapp.Models.StationStatusDisplayModel;

import java.util.ArrayList;

public class TrainController {

    public static ArrayList<String> getStationList(TrainRouteModel[] trainRoute) {
        ArrayList stationList = new ArrayList();
        for (int i = 0; i < trainRoute.length; i++) {
            stationList.add(trainRoute[i].getStation().getStationName());
        }
        return stationList;
    }

    public static String getDisplayInformation(LiveStatusBaseModel statusBaseModel, int position) {
        String stationName;
        String fromStation;
        String fromStationCode;
        String toStation;
        String toStationCode;
        String actualArrival;
        String scheduledArival;
        String actualDeparture;
        String scheduledDepartire;
        String late;
        String currentStatus;
        String date;

        TrainRouteModel currentRoute=statusBaseModel.getRoute()[position];
        stationName=currentRoute.getStation().getStationName();
        fromStationCode=statusBaseModel.getRoute()[0].getStation().getCode();
        fromStation=statusBaseModel.getRoute()[0].getStation().getStationName();
        toStationCode=statusBaseModel.getRoute()[statusBaseModel.getRoute().length-1].getStation().getCode();
        toStation=statusBaseModel.getRoute()[statusBaseModel.getRoute().length-1].getStation().getStationName();
        actualArrival=currentRoute.getAccArr();
        scheduledArival=currentRoute.getSchduleArrival();
        actualDeparture=currentRoute.getActDep();
        scheduledDepartire=currentRoute.getSchdep();
        late=currentRoute.getLateMin();
        currentStatus=statusBaseModel.getPosition();
        date=currentRoute.getDate();

        StationStatusDisplayModel model=new StationStatusDisplayModel(
                stationName,
                fromStation,
                toStation,
                actualArrival,
                scheduledArival,
                actualDeparture,
                scheduledDepartire,
                late,
                currentStatus,
                date,
                fromStationCode,
                toStationCode);
        Gson gson=new Gson();
        String response=gson.toJson(model);
        return response;
    }
}
