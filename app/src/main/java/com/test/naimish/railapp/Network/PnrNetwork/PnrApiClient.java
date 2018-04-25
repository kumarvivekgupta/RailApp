package com.test.naimish.railapp.Network.PnrNetwork;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Fragments.PnrEnquiryFragment;
import com.test.naimish.railapp.Models.PnrModel.BaseModel;
import com.test.naimish.railapp.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.RAIL_BASE_URL;

/**
 * Created by naimish on 2/20/2018.
 */

public class PnrApiClient {
    private Context context;

    public PnrApiClient(Context context) {
        this.context = context;
    }

    public void getPnrStatus(String pnrNo) {
        OkHttpClient.Builder okhttpbuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG) {
            okhttpbuilder.addInterceptor(interceptor);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RAIL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpbuilder.build())
                .build();
        final Gson gson = new Gson();
        PnrApiInterface pnrApiInterface = retrofit.create(PnrApiInterface.class);
        Call<BaseModel> call = pnrApiInterface.pnrInfo(pnrNo);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                if(response.body()!=null) {
                    PnrEnquiryFragment pnrEnquiryFragment = new PnrEnquiryFragment();
                    pnrEnquiryFragment.pnrDisplay(response.body());
                }else
                    Toast.makeText(context, R.string.common_error+" "+R.string.try_again,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                Toast.makeText(context,t.getMessage()+" "+R.string.try_again,Toast.LENGTH_SHORT).show();;
            }
        });
    }
}
