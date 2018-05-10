package com.test.naimish.railapp.Network.ReportBugNetwork;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.RegisterUser;
import com.test.naimish.railapp.Models.ReportBug;
import com.test.naimish.railapp.Network.RegisterNetwork.RegisterApiInterface;
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
 * Created by Vivek on 5/11/2018.
 */

public class BugApiClient {
    private ResponseListener<ReportBug> responseListener;


    public BugApiClient(ResponseListener<ReportBug> responseListener) {
        this.responseListener=responseListener;
    }

    public void reportBug(String email, String message){
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
        BugApiInterface bugApiInterface = retrofit.create(BugApiInterface.class);
        Call<ReportBug> call = bugApiInterface.reportedBug(new ReportBug(email,message));
        call.enqueue(new Callback<ReportBug>() {
            @Override
            public void onResponse(Call<ReportBug> call, Response<ReportBug> response) {
                if(response.body()!=null)
                    responseListener.onSuccess(response.body());
                else
                    responseListener.onNullResponse();
            }

            @Override
            public void onFailure(Call<ReportBug> call, Throwable t) {
                responseListener.onFailure(t);
            }
        });
    }

    }


