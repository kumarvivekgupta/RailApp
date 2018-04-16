package com.test.naimish.railapp.Network.TokenValidation;

import com.test.naimish.railapp.Models.AuthorizationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by naimish on 4/4/2018.
 */

public interface TokenApiInterface {

    @GET("/users/validate")
    Call<AuthorizationResponse> getAutherization(@Header("Authorization") String token);
}
