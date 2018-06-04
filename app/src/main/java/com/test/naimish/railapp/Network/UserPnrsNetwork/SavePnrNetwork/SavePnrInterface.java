package com.test.naimish.railapp.Network.UserPnrsNetwork.SavePnrNetwork;

import com.test.naimish.railapp.Models.UserPnrs.SavedPnrs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SavePnrInterface {
    @POST("/users/pnr-search")
    Call<SavedPnrs> saveUserPnr(@Body SavedPnrs savedPnrs);
}
