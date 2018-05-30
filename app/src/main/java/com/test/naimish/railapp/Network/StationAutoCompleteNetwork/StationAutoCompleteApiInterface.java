package com.test.naimish.railapp.Network.StationAutoCompleteNetwork;

import com.test.naimish.railapp.Models.StationAutoCompleteBaseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Vivek on 5/30/2018.
 */

public interface StationAutoCompleteApiInterface {

    @GET("/v2/suggest-station/name/{partial_station_name}/apikey/wt1hggajop/")
    Call<StationAutoCompleteBaseModel> stationAutoCompleteInfo(@Path("partial_station_name")String stationPartialName);
}
