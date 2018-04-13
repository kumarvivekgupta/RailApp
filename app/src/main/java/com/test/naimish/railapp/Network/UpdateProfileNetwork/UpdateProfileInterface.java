package com.test.naimish.railapp.Network.UpdateProfileNetwork;

//Created by naimish on 13/4/18

import com.test.naimish.railapp.Models.UpdateProfile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UpdateProfileInterface {

    @POST("/users/update-profile")
    Call<UpdateProfile> updateProfile(@Body UpdateProfile updateProfile);
}
