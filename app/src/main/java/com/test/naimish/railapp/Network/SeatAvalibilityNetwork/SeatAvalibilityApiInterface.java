package com.test.naimish.railapp.Network.SeatAvalibilityNetwork;

import com.test.naimish.railapp.Models.SeatAvailability.SeatAvailabiityModelClass;
import com.test.naimish.railapp.Models.SeatAvailability.TrainSeatBaseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

/**
 * Created by Vivek on 5/27/2018.
 */

public interface SeatAvalibilityApiInterface {

    @GET("/v2/check-seat/train/{train_number}/source/{stn_code}/dest/{dest_code}/" +
            "date/{date}/pref/{class_code}/quota/{quota_code}/apikey/wt1hggajop/")
    Call<TrainSeatBaseModel> seatAvalibilityStatus(@Path("train_number") String trainNo,
                                                   @Path("stn_code") String stationCode,
                                                   @Path("dest_code") String destCode,
                                                   @Path("date") String date,
                                                   @Path("class_code") String classCode,
                                                   @Path("quota_code") String quota);


}
