package com.test.naimish.railapp.Network.LiveTrainNetwork;

import com.test.naimish.railapp.Models.LiveTrainStatusModel.LiveStatusBaseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Vivek on 3/17/2018.
 */

public interface LiveTrainApiInterface {

    @GET("/v2/live/train/{train_no}/date/{date}/apikey/wt1hggajop/")
    Call<LiveStatusBaseModel> liveTrainInfo(@Path("train_no") String train_no, @Path("date") String date);
}
