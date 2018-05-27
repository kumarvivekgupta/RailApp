package com.test.naimish.railapp.Network.SeatAvalibilityNetwork;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.LiveStatusBaseModel;
import com.test.naimish.railapp.Models.SeatAvailability.TrainSeatBaseModel;
import com.test.naimish.railapp.Network.LiveTrainNetwork.LiveTrainApiInterface;
import com.test.naimish.railapp.Utils.ResponseListener;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.RAIL_BASE_URL;

/**
 * Created by Vivek on 5/27/2018.
 */

public class SeatAvalibilityApiClient {
    private ResponseListener<TrainSeatBaseModel> responseListener;

    public SeatAvalibilityApiClient(ResponseListener<TrainSeatBaseModel> responseListener) {
        this.responseListener = responseListener;
    }
    public void seatAvalibilityStatus(String trainNo, String stationCode,String destCode,String date,String classCode,String quota ) {
        OkHttpClient.Builder okhttpbuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG) {
            okhttpbuilder.addInterceptor(interceptor);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RAIL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpbuilder.build())
                .build();
        SeatAvalibilityApiInterface seatAvailableApiInterface = retrofit.create(SeatAvalibilityApiInterface.class);
        Call<TrainSeatBaseModel> call = seatAvailableApiInterface.seatAvalibilityStatus(trainNo,stationCode,destCode, date,classCode,quota);
        call.enqueue(new Callback<TrainSeatBaseModel>() {
            @Override
            public void onResponse(Call<TrainSeatBaseModel> call, Response<TrainSeatBaseModel> response) {
                if (response.body() != null) {
                    responseListener.onSuccess(response.body());
                } else {
                    responseListener.onNullResponse();
                }
            }

            @Override
            public void onFailure(Call<TrainSeatBaseModel> call, Throwable t) {
                responseListener.onFailure(t);
            }
        });
    }

}
