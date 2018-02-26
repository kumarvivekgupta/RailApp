package com.test.naimish.railapp.Network.PnrNetwork;

import android.util.Log;

import com.google.gson.Gson;
import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.PnrModel.BaseModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by naimish on 2/20/2018.
 */

public class PnrApiClient {
    private static final String BASE_URL = "https://api.railwayapi.com/";

    public static void getPnrStatus(String pnrNo) {
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
        PnrApiInterface pnrApiInterface = retrofit.create(PnrApiInterface.class);
        Call<BaseModel> call = pnrApiInterface.pnrInfo(pnrNo);
        Log.i("Pnrno",pnrNo+"");
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                Log.i("Response",gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                Log.i("Error","error");
            }
        });
    }
}
