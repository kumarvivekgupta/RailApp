package com.test.naimish.railapp.Network.RegisterNetwork;

import android.util.Log;

import com.google.gson.Gson;
import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.RegisterUser;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.BASE_URL;

/**
 * Created by naimish on 3/14/2018.
 */

public class RegisterApiClient {

    private NetworkResponse networkResponse;

    public RegisterApiClient(NetworkResponse networkResponse) {
        this.networkResponse = networkResponse;
    }

    public void createNewUser(String mName, String mEmail, String mPassword) {
        OkHttpClient.Builder okhttpbuilder = new OkHttpClient.Builder();
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG) {
            okhttpbuilder.addInterceptor(interceptor);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpbuilder.build())
                .build();
        final Gson gson = new Gson();
        RegisterApiInterface registerApiInterface = retrofit.create(RegisterApiInterface.class);
        Call<RegisterUser> call = registerApiInterface.createUser(new RegisterUser(mName, mPassword, mEmail));
        call.enqueue(new Callback<RegisterUser>() {
            @Override
            public void onResponse(Call<RegisterUser> call, Response<RegisterUser> response) {
                Log.i("Response", gson.toJson(response.body()));
                networkResponse.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<RegisterUser> call, Throwable t) {
                Log.i("Error", "error");
            }
        });
    }

    public interface NetworkResponse {
        void onResponse(RegisterUser data);
    }


}

