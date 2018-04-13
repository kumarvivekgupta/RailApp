package com.test.naimish.railapp.Network.UpdateProfileNetwork;


import android.util.Log;

import com.google.gson.Gson;
import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.RegisterUser;
import com.test.naimish.railapp.Models.UpdateProfile;
import com.test.naimish.railapp.Network.RegisterNetwork.RegisterApiInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.BASE_URL;

public class UpdateProfileApiClient {
    private UpdateProfileResponse updateProfileResponse;

    public UpdateProfileApiClient(UpdateProfileResponse updateProfileResponse) {
        this.updateProfileResponse = updateProfileResponse;

    }

    public void updateProfile(String mUserID, String mName, String mProfileUrl) {
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
        UpdateProfileInterface registerApiInterface = retrofit.create(UpdateProfileInterface.class);
        Call<UpdateProfile> call = registerApiInterface.updateProfile(new UpdateProfile(mUserID, mName, mProfileUrl));
        call.enqueue(new Callback<UpdateProfile>() {
            @Override
            public void onResponse(Call<UpdateProfile> call, Response<UpdateProfile> response) {
                Log.i("Response", gson.toJson(response.body()));
                updateProfileResponse.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<UpdateProfile> call, Throwable t) {
                Log.i("Error", "error");
            }
        });
    }

    public interface UpdateProfileResponse {
        void onResponse(UpdateProfile updateProfile);
    }
}
