package com.test.naimish.railapp.Network.RegisterNetwork;

import com.test.naimish.railapp.Models.RegisterUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by naimish on 3/14/2018.
 */

public interface RegisterApiInterface {
    @POST("/users/register")
    Call<RegisterUser> createUser(@Body RegisterUser registerUser);
}
