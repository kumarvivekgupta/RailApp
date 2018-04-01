package com.test.naimish.railapp.Network.LoginNetwork;

import com.test.naimish.railapp.Models.LoginModel.LoginUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Vivek on 3/16/2018.
 */

public interface LoginApiInterface {
    @POST("/users/login")
    Call<LoginUser> createUser(@Body LoginUser loginUser);
}
