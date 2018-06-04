package com.test.naimish.railapp.Network.UserPnrsNetwork.GetPnrNetwork;

import com.test.naimish.railapp.Models.UserPnrs.GetPnrs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetPnrInterface {

    @GET("/users/pnr-search")
    Call<GetPnrs> getUserSavedPnrs(@Query("id") String id);
}
