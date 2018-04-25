package com.test.naimish.railapp.Network.LoginNetwork;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.LoginModel.LoginUser;
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
 * Created by Vivek on 3/16/2018.
 */

public class LoginApiClient {
    private ResponseListener<LoginUser> responseListener;

    public LoginApiClient(ResponseListener responseListener) {
        this.responseListener = responseListener;
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
        LoginApiInterface loginApiInterface = retrofit.create(LoginApiInterface.class);
        Call<LoginUser> call = loginApiInterface.createUser(new LoginUser(mEmail, mPassword));
        call.enqueue(new Callback<LoginUser>() {
            @Override
            public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                if (response.body() != null)
                    responseListener.onSuccess(response.body());
                else
                    responseListener.onNullResponse();

            }

            @Override
            public void onFailure(Call<LoginUser> call, Throwable t) {
                responseListener.onFailure(t);
            }
        });

    }

}
