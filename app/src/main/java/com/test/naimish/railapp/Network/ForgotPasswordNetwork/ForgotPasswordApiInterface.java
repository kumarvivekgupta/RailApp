package com.test.naimish.railapp.Network.ForgotPasswordNetwork;

import com.test.naimish.railapp.Models.ForgotPasswordModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ForgotPasswordApiInterface {
    @POST("/users/forgot")
    Call<ForgotPasswordModel> sendNewPassword(@Body ForgotPasswordModel email);
}
