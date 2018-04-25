package com.test.naimish.railapp.Network.RegisterNetwork;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.RegisterUser;
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
 * Created by naimish on 3/14/2018.
 */

public class RegisterApiClient {

    private ResponseListener<RegisterUser> responseListener;

    public RegisterApiClient(ResponseListener<RegisterUser> responseListener) {
        this.responseListener=responseListener;
    }

    public void createNewUser(String mName, String mEmail, String mPassword) {
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
        RegisterApiInterface registerApiInterface = retrofit.create(RegisterApiInterface.class);
        Call<RegisterUser> call = registerApiInterface.createUser(new RegisterUser(mName, mPassword, mEmail));
        call.enqueue(new Callback<RegisterUser>() {
            @Override
            public void onResponse(Call<RegisterUser> call, Response<RegisterUser> response) {
                if(response.body()!=null)
                    responseListener.onSuccess(response.body());
                else
                    responseListener.onNullResponse();
            }

            @Override
            public void onFailure(Call<RegisterUser> call, Throwable t) {
                responseListener.onFailure(t);
            }
        });
    }

}

