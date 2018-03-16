package com.test.naimish.railapp.Network.LoginNetwork;

import com.test.naimish.railapp.Models.LoginUser;
import com.test.naimish.railapp.Models.RegisterUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by Vivek on 3/16/2018.
 */

public interface LoginApiInterface {
    @GET("/users/login")
    Call<LoginUser> createUser(@Body LoginUser loginUser);
}
