package com.test.naimish.railapp.Network.TokenValidation;

import android.util.Log;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.AuthorizationResponse;
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
 * Created by naimish on 4/4/2018.
 */

public class TokenApiClient {

    private ResponseListener<AuthorizationResponse> responseListener;

    public TokenApiClient(ResponseListener<AuthorizationResponse> responseListener) {
        this.responseListener = responseListener;
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
        TokenApiInterface tokenApiInterface = retrofit.create(TokenApiInterface.class);
        Call<AuthorizationResponse> call = tokenApiInterface.getAutherization(mToken);
        call.enqueue(new Callback<AuthorizationResponse>() {
            @Override
            public void onResponse(Call<AuthorizationResponse> call, Response<AuthorizationResponse> response) {
                if (response.body() != null)
                    responseListener.onSuccess(response.body());
                else
                    responseListener.onNullResponse();
            }

            @Override
            public void onFailure(Call<AuthorizationResponse> call, Throwable t) {
                Log.i("Error", t.getMessage());
                responseListener.onFailure(t);
            }
        });
    }


}
