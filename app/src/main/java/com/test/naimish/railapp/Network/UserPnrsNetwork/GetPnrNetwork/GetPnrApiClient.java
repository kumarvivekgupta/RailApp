package com.test.naimish.railapp.Network.UserPnrsNetwork.GetPnrNetwork;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.UserPnrs.GetPnrs;
import com.test.naimish.railapp.Utils.ResponseListener;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.BASE_URL;

public class GetPnrApiClient {

    private ResponseListener<GetPnrs> responseListener;

    public GetPnrApiClient(ResponseListener<GetPnrs> responseListener) {
        this.responseListener = responseListener;
    }

    public void getUserPnr(String userId) {
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
        GetPnrInterface getPnrInterface = retrofit.create(GetPnrInterface.class);
        Call<GetPnrs> call = getPnrInterface.getUserSavedPnrs(userId);
        call.enqueue(new Callback<GetPnrs>() {
            @Override
            public void onResponse(Call<GetPnrs> call, Response<GetPnrs> response) {
                if (response.body() != null) {
                    responseListener.onSuccess(response.body());
                } else {
                    responseListener.onNullResponse();
                }
            }

            @Override
            public void onFailure(Call<GetPnrs> call, Throwable t) {
                responseListener.onFailure(t);
            }
        });

    }

}
