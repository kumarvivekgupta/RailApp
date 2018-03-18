package com.test.naimish.railapp.Network.LoginNetwork;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.LoginUser;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vivek on 3/16/2018.
 */

public class LoginApiClient {
    private static final String BASE_URL = "https://fierce-forest-53940.herokuapp.com/";
    private LoginResponse loginResponse;

    public LoginApiClient(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }

    public void loginUser(String mEmail, String mPassword) {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(interceptor);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
                .build();
        final Gson gson = new Gson();
        LoginApiInterface loginApiInterface = retrofit.create(LoginApiInterface.class);
        Call<LoginUser> call = loginApiInterface.createUser(new LoginUser(mEmail, mPassword));
        call.enqueue(new Callback<LoginUser>() {
            @Override
            public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                loginResponse.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<LoginUser> call, Throwable t) {

            }
        });

    }

    public interface LoginResponse {
        void onResponse(LoginUser response);
    }
}
