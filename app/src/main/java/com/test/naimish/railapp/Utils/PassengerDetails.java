package com.test.naimish.railapp.Utils;

import com.test.naimish.railapp.Models.PassengerRecyclerModel;
import com.test.naimish.railapp.Models.PnrModel.BaseModel;
import com.test.naimish.railapp.Models.PnrModel.PassengerModel;

import java.util.ArrayList;

/**
 * Created by Vivek on 5/9/2018.
 */

public class PassengerDetails {

    public static ArrayList<PassengerRecyclerModel> getPassengerDetails(BaseModel mBaseModel) {
        ArrayList<PassengerModel> mPassengerList = new ArrayList<>();
        ArrayList<PassengerRecyclerModel> data1 = new ArrayList<>();
        for (int i = 0; i < mBaseModel.getPassengersDetails().length; i++) {
            mPassengerList.add(mBaseModel.getPassengersDetails()[i]);
        }
        for (int i = 0; i < mPassengerList.size(); i++) {
            data1.add(new PassengerRecyclerModel(mPassengerList.get(i).getPassengerNo(), mPassengerList.get(i).getBookingStatus()
                    , mPassengerList.get(i).getCurrentStatus()));
        }
        return data1;
    }
}
