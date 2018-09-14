package com.test.naimish.railapp.Network;

import com.test.naimish.railapp.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.BASE_URL;
import static com.test.naimish.railapp.Utils.RailAppConstants.RAIL_BASE_URL;

/**
 * Created by Vivek on 9/8/2018.
 */

public class RailApiLayer {
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
                    .baseUrl(RAIL_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpBuilder.build())
                    .build();

            apiInterface = retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }

}
