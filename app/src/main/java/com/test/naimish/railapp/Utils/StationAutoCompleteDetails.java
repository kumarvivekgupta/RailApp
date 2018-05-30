package com.test.naimish.railapp.Utils;

import com.test.naimish.railapp.Models.PnrModel.StationModel;
import com.test.naimish.railapp.Models.StationAutoCompleteBaseModel;

import java.util.ArrayList;

/**
 * Created by Vivek on 5/30/2018.
 */

public class StationAutoCompleteDetails {
    private ArrayList<StationModel> mStations;
    private ArrayList<String> mStationCode;
    private ArrayList<String> mStationName;


  public  ArrayList<String> deatils(StationAutoCompleteBaseModel stationAutoCompleteBaseModel){
      mStations=new ArrayList<>();
      mStationName=new ArrayList<>();
      for(int i=0;i<stationAutoCompleteBaseModel.getTrainStations().length;i++) {
          mStations.add(stationAutoCompleteBaseModel.getTrainStations()[i]);
      }
      for(int j=0;j<mStations.size();j++) {
          mStationName.add(mStations.get(j).getStationName()+
                 "-"+mStations.get(j).getStationCode());
      }

      return mStationName;

  }
//  public ArrayList<String> stationCode(StationAutoCompleteBaseModel stationAutoCompleteBaseModel){
//      for(int i=0;i<stationAutoCompleteBaseModel.getTrainStations().length;i++) {
//          mStations = stationAutoCompleteBaseModel.getTrainStations()[i];
//          mStationCode.add(mStations.getStationCode());
//      }
//      return mStationCode;
//  }
}
