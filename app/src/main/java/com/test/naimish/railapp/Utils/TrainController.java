package com.test.naimish.railapp.Utils;

import android.util.Log;

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
        String toStation;
        String actualArrival;
        String scheduledArival;
        String actualDeparture;
        String scheduledDepartire;
        String late;
        String currentStatus;

        TrainRouteModel currentRoute=statusBaseModel.getRoute()[position];
        stationName=currentRoute.getStation().getStationName();
        fromStation=statusBaseModel.getRoute()[0].getStation().getCode();
        toStation=statusBaseModel.getRoute()[statusBaseModel.getRoute().length-1].getStation().getCode();
        actualArrival=currentRoute.getAccArr();
        scheduledArival=currentRoute.getSchduleArrival();
        actualDeparture=currentRoute.getActDep();
        scheduledDepartire=currentRoute.getSchdep();
        late=currentRoute.getLateMin();
        currentStatus=statusBaseModel.getPosition();

        StationStatusDisplayModel model=new StationStatusDisplayModel(
                stationName,
                fromStation,
                toStation,
                actualArrival,
                scheduledArival,
                actualDeparture,
                scheduledDepartire,
                late,
                currentStatus);
        Gson gson=new Gson();
        String response=gson.toJson(model);
        Log.i("display",response);
        return response;
    }
}
