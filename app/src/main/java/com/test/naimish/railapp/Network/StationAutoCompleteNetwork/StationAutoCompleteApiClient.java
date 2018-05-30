package com.test.naimish.railapp.Network.StationAutoCompleteNetwork;

import com.test.naimish.railapp.BuildConfig;
import com.test.naimish.railapp.Fragments.SeatAvalibilityEnquiryFragment;
import com.test.naimish.railapp.Models.PnrModel.BaseModel;
import com.test.naimish.railapp.Models.StationAutoCompleteBaseModel;
import com.test.naimish.railapp.Network.PnrNetwork.PnrApiInterface;
import com.test.naimish.railapp.Utils.ResponseListener;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.test.naimish.railapp.Utils.RailAppConstants.RAIL_BASE_URL;

/**
 * Created by Vivek on 5/30/2018.
 */

public class StationAutoCompleteApiClient {
   // private ResponseListener<StationAutoCompleteBaseModel> responseListener;

//    public StationAutoCompleteApiClient(ResponseListener<StationAutoCompleteBaseModel> responseListener) {
//        this.responseListener = responseListener;
//    }
    public stationAutoCompleteResponse stationAutoCompleteResponse;

    public StationAutoCompleteApiClient(StationAutoCompleteApiClient.stationAutoCompleteResponse stationAutoCompleteResponse) {
        this.stationAutoCompleteResponse = stationAutoCompleteResponse;
    }

    public void stationAutoCompleteInfo(String stationPartialName) {

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
        StationAutoCompleteApiInterface stationAutoCompleteApiInterface = retrofit.create(StationAutoCompleteApiInterface.class);
        Call<StationAutoCompleteBaseModel> call = stationAutoCompleteApiInterface.stationAutoCompleteInfo(stationPartialName);
        call.enqueue(new Callback<StationAutoCompleteBaseModel>() {
            @Override
            public void onResponse(Call<StationAutoCompleteBaseModel> call, Response<StationAutoCompleteBaseModel> response) {
//                SeatAvalibilityEnquiryFragment seatAvalibilityEnquiryFragment=new SeatAvalibilityEnquiryFragment();
//                seatAvalibilityEnquiryFragment.createSourceCodeSpinnerDropdown(response.body());
                stationAutoCompleteResponse.onResponce(response.body());
            }

            @Override
            public void onFailure(Call<StationAutoCompleteBaseModel> call, Throwable t) {

            }
        });
    }
    public interface stationAutoCompleteResponse{
        void onResponce(StationAutoCompleteBaseModel stationAutoCompleteBaseModel);
    }



}
