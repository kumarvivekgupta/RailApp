package com.test.naimish.railapp.Network.UserPnrsNetwork.DeletePnrNetwork;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.UserPnrs.DeletePnrs;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.BASE_URL;

public class DeletePnrApiClient {

    private DeleteResponse responseListener;

    public DeletePnrApiClient(DeleteResponse responseListener) {
        this.responseListener = responseListener;
    }

    public void deleteUserPnr(String userId) {
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
        DeletePnrInterface deletePnrInterface = retrofit.create(DeletePnrInterface.class);
        Call<DeletePnrs> call = deletePnrInterface.deleteSavedPnrs(userId);
        call.enqueue(new Callback<DeletePnrs>() {
            @Override
            public void onResponse(Call<DeletePnrs> call, Response<DeletePnrs> response) {
                if (response.body() != null) {
                    responseListener.success(response.body());
                } else {
                    responseListener.failure();
                }
            }

            @Override
            public void onFailure(Call<DeletePnrs> call, Throwable t) {
                responseListener.failure();
            }
        });

    }

    public interface DeleteResponse {
        void success(DeletePnrs deletePnrs);

        void failure();
    }

}
