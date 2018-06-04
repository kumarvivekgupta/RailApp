package com.test.naimish.railapp.Utils;

import com.google.gson.Gson;
import com.test.naimish.railapp.Models.DateSeatModel;
import com.test.naimish.railapp.Models.PnrModel.TrainModel;
import com.test.naimish.railapp.Models.SeatAvailability.SeatAvailabiityModelClass;
import com.test.naimish.railapp.Models.SeatAvailability.TrainSeatBaseModel;
import com.test.naimish.railapp.Models.SeatStatusDisplayModel;

import java.util.ArrayList;

/**
 * Created by Vivek on 6/5/2018.
 */

public class SeatAvalibilityController {

    public ArrayList<String> getSeatStatus(TrainSeatBaseModel trainSeatBaseModel) {
        ArrayList<String> dateSeatModelArrayList = new ArrayList<>();
        for (int i = 0; i < trainSeatBaseModel.getTrainSeatAvailability().length; i++)
            dateSeatModelArrayList.add(trainSeatBaseModel.getTrainSeatAvailability()[i].getTraindate() + "--" + trainSeatBaseModel.getTrainSeatAvailability()[i].getSeatStatus());
        //  String seatStatus = gson.toJson(dateSeatModelArrayList);
        return dateSeatModelArrayList;
    }

    public String getSeatAvalibilityInfo(TrainSeatBaseModel trainSeatBaseModel) {
        String trainName;
        String trainJourneyClass;
        String trainQuota;
        String sourceCode;
        String destinationCode;
        String sourceStationName;
        String destinationStationName;

        trainName = trainSeatBaseModel.getTrainModel().getTrainName();
        destinationCode = trainSeatBaseModel.getToStation().getStationCode();
        sourceCode = trainSeatBaseModel.getFromStation().getStationCode();
        destinationStationName = trainSeatBaseModel.getToStation().getStationName();
        sourceStationName = trainSeatBaseModel.getFromStation().getStationName();
        trainJourneyClass = trainSeatBaseModel.getJourneyClass().getJourneyClassName();
        trainQuota = trainSeatBaseModel.getTrainQuota().getQuotaName();

        SeatStatusDisplayModel seatStatusDisplayModel = new SeatStatusDisplayModel(
                trainName,
                sourceStationName,
                destinationStationName,
                trainQuota,
                trainJourneyClass,
                sourceCode,
                destinationCode
        );

        Gson gson = new Gson();
        String response = gson.toJson(seatStatusDisplayModel);
        return response;


    }
}
