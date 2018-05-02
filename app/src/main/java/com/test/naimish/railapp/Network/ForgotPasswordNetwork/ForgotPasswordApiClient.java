package com.test.naimish.railapp.Network.ForgotPasswordNetwork;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.ForgotPasswordModel;
import com.test.naimish.railapp.Models.RegisterUser;
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

public class ForgotPasswordApiClient {

    private ResponseListener<ForgotPasswordModel> responseListener;

    public ForgotPasswordApiClient(ResponseListener<ForgotPasswordModel> responseListener) {
        this.responseListener=responseListener;
    }

    public void createNewUser(String mEmail) {
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
        ForgotPasswordApiInterface forgotPasswordApiInterface = retrofit.create(ForgotPasswordApiInterface.class);
        Call<ForgotPasswordModel> call = forgotPasswordApiInterface.sendNewPassword(new ForgotPasswordModel(mEmail));
        call.enqueue(new Callback<ForgotPasswordModel>() {
            @Override
            public void onResponse(Call<ForgotPasswordModel> call, Response<ForgotPasswordModel> response) {
                if(response.body()!=null)
                    responseListener.onSuccess(response.body());
                else
                    responseListener.onNullResponse();
            }

            @Override
            public void onFailure(Call<ForgotPasswordModel> call, Throwable t) {
                responseListener.onFailure(t);
            }
        });
    }

}
