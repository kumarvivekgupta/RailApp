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

    @GET("/v2/check-seat/train/<train number>/source/<stn code>/dest/<dest code>/" +
            "date/<dd-mm-yyyy>/pref/<class code>/quota/<quota code>/apikey/wt1hggajop/")
    Call<TrainSeatBaseModel> seatAvalibilityStatus(@Path("train number") String trainNo,
                                                   @Path("stn code") String stationCode,
                                                   @Path("dest code") String destCode,
                                                   @Path("dd-mm-yyyy") String date,
                                                   @Path("class code") String classCode,
                                                   @Path("quota code") String quota);


}
