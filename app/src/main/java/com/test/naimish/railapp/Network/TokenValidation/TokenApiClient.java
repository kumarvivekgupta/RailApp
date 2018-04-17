package com.test.naimish.railapp.Network.TokenValidation;

import android.util.Log;

import com.google.gson.Gson;
import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.AuthorizationResponse;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.BASE_URL;

/**
 * Created by naimish on 4/4/2018.
 */

public class TokenApiClient {

    private TokenResponse tokenResponse;

    public TokenApiClient(TokenResponse tokenResponse) {
        this.tokenResponse = tokenResponse;
    }

    public void validateUser(String mToken) {
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
        TokenApiInterface tokenApiInterface = retrofit.create(TokenApiInterface.class);
        Call<AuthorizationResponse> call = tokenApiInterface.getAutherization(mToken);
        call.enqueue(new Callback<AuthorizationResponse>() {
            @Override
            public void onResponse(Call<AuthorizationResponse> call, Response<AuthorizationResponse> response) {
                Log.i("Response", gson.toJson(response.body()));
                if (response.body() != null)
                    tokenResponse.onResponse(response.body());
                else
                    tokenResponse.onNullResponse();
            }

            @Override
            public void onFailure(Call<AuthorizationResponse> call, Throwable t) {
                Log.i("Error", t.getMessage());
                tokenResponse.onFailure();
            }
        });
    }

    public interface TokenResponse {
        void onResponse(AuthorizationResponse data);

        void onNullResponse();

        void onFailure();
    }


}
