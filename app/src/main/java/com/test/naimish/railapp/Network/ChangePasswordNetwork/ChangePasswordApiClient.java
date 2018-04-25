package com.test.naimish.railapp.Network.ChangePasswordNetwork;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.ChangePassword;
import com.test.naimish.railapp.Utils.ResponseListener;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.BASE_URL;

/**
 * Created by naimish on 4/6/2018.
 */

public class ChangePasswordApiClient {

    private ResponseListener<ChangePassword> responseListener;

    public ChangePasswordApiClient(ResponseListener<ChangePassword> responseListener) {
        this.responseListener = responseListener;
    }

    public void changePassword(String userId, String oldPassword, String newPassword) {
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
        ChangePasswordInterface changePasswordInterface = retrofit.create(ChangePasswordInterface.class);
        Call<ChangePassword> call = changePasswordInterface.changePasssword(new ChangePassword(userId, oldPassword, newPassword));
        call.enqueue(new Callback<ChangePassword>() {
            @Override
            public void onResponse(Call<ChangePassword> call, Response<ChangePassword> response) {
                if (response.body() != null)
                    responseListener.onSuccess(response.body());
                else
                    responseListener.onNullResponse();
            }

            @Override
            public void onFailure(Call<ChangePassword> call, Throwable t) {
                responseListener.onFailure(t);
            }
        });

    }


}
