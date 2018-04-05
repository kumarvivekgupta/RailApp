package com.test.naimish.railapp.Network.LiveTrainNetwork;

import android.util.Log;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Fragments.LiveTrainSearchFragment;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.LiveStatusBaseModel;

import org.greenrobot.eventbus.EventBus;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vivek on 3/17/2018.
 */

public class LiveTrainApiClient {
    private static final String BASE_URL = "https://api.railwayapi.com/";


    public static void liveTrainStatus(String trainNo, String date) {
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
        LiveTrainApiInterface liveTrainApiInterface = retrofit.create(LiveTrainApiInterface.class);
        Call<LiveStatusBaseModel> call = liveTrainApiInterface.liveTrainInfo(trainNo, date);
        call.enqueue(new Callback<LiveStatusBaseModel>() {
            @Override
            public void onResponse(Call<LiveStatusBaseModel> call, Response<LiveStatusBaseModel> response) {
                EventBus.getDefault().post(response.body());
               // LiveTrainSearchFragment.trainLiveModel(response.body());
            }

            @Override
            public void onFailure(Call<LiveStatusBaseModel> call, Throwable t) {
            }
        });


    }

}
