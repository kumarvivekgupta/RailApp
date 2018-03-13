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

/**
 * Created by naimish on 3/14/2018.
 */

public class RegisterApiClient {
    private static final String BASE_URL="https://fierce-forest-53940.herokuapp.com/";

    public static void createNewUser() {
        OkHttpClient.Builder okhttpbuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG) {
            okhttpbuilder.addInterceptor(interceptor);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpbuilder.build())
                .build();
        final Gson gson=new Gson();
        RegisterApiInterface registerApiInterface=retrofit.create(RegisterApiInterface.class);
        Call<RegisterUser> call = registerApiInterface.createUser(new RegisterUser("Akhil","verma","akhilverma@gmail.com"));
        call.enqueue(new Callback<RegisterUser>() {
            @Override
            public void onResponse(Call<RegisterUser> call, Response<RegisterUser> response) {
                Log.i("Response",gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<RegisterUser> call, Throwable t) {
                Log.i("Error","error");
            }
        });
    }
}
