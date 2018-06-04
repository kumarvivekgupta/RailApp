package com.test.naimish.railapp.Network.UserPnrsNetwork.SavePnrNetwork;

import android.widget.Toast;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.UserPnrs.SavedPnrs;
import com.test.naimish.railapp.Utils.ResponseListener;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.BASE_URL;

public class SavedPnrApiClient {
    private SavePnrResponse pnrResponse;

    public SavedPnrApiClient(SavePnrResponse pnrResponse) {
        this.pnrResponse = pnrResponse;
    }

    public void savePnr(String userId, String pnrNo) {
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
        SavePnrInterface savePnrInterface = retrofit.create(SavePnrInterface.class);
        Call<SavedPnrs> call = savePnrInterface.saveUserPnr(new SavedPnrs(userId, pnrNo));
        call.enqueue(new Callback<SavedPnrs>() {
            @Override
            public void onResponse(Call<SavedPnrs> call, Response<SavedPnrs> response) {
                if (response.body() != null) {
                    pnrResponse.onSuccess(response.body());
                } else {

                }

            }

            @Override
            public void onFailure(Call<SavedPnrs> call, Throwable t) {
                pnrResponse.onFailure();
            }
        });

    }

    public interface SavePnrResponse{
        void onSuccess(SavedPnrs savedPnrs);
        void onFailure();
    }

}
