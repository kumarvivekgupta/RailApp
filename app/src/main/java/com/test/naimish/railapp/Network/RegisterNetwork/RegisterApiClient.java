package com.test.naimish.railapp.Network.RegisterNetwork;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.test.naimish.railapp.Activities.EnquiryActivity;
import com.test.naimish.railapp.Activities.LandingActivity;
import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Models.RegisterUser;
import com.test.naimish.railapp.R;

import java.lang.ref.SoftReference;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by naimish on 3/14/2018.
 */

public class RegisterApiClient {
    private static final String BASE_URL = "https://fierce-forest-53940.herokuapp.com/";
    public static boolean user;
    public static String current;

    public static void createNewUser(final Context context, final String mName, final String mPassword, final String mEmail) {
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
        RegisterApiInterface registerApiInterface = retrofit.create(RegisterApiInterface.class);
        Call<RegisterUser> call = registerApiInterface.createUser(new RegisterUser(mName, mPassword, mEmail));
        call.enqueue(new Callback<RegisterUser>() {
            @Override
            public void onResponse(Call<RegisterUser> call, Response<RegisterUser> response) {
                Log.i("Response", gson.toJson(response.body()));
                if (response.body().getResponse()) {
                    context.startActivity(new Intent(context, EnquiryActivity.class));
                } else {
                    Toast.makeText(context, "Already registered!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterUser> call, Throwable t) {
                Log.i("Error", "error");
            }
        });
    }
}
