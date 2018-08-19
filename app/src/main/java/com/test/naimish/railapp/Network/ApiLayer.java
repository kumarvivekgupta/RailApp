package com.test.naimish.railapp.Network;

import com.test.naimish.railapp.BuildConfig;

import static com.test.naimish.railapp.Utils.RailAppConstants.BASE_URL;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiLayer {
    private static ApiInterface apiInterface = null;

    public static ApiInterface getInterface() {
        if (apiInterface == null) {
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

            apiInterface = retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }

}
