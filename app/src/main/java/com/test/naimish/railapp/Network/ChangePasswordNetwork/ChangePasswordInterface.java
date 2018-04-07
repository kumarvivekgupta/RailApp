package com.test.naimish.railapp.Network.ChangePasswordNetwork;

import com.test.naimish.railapp.Models.ChangePassword;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by naimish on 4/6/2018.
 */

public interface ChangePasswordInterface {
    @POST("/users/change-password")
    Call<ChangePassword> changePasssword(@Body ChangePassword changePassword);

}
