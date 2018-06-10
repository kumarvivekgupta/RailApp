package com.test.naimish.railapp.Network.UserPnrsNetwork.DeletePnrNetwork;

import com.test.naimish.railapp.Models.UserPnrs.DeletePnrs;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Query;

public interface DeletePnrInterface {

    @DELETE("/users/clear-history")
    Call<DeletePnrs> deleteSavedPnrs(@Query("id") String userId);
}
