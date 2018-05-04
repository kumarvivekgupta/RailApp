package com.test.naimish.railapp.Network.PnrNetwork;

import com.test.naimish.railapp.Models.PnrModel.BaseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by naimish on 2/20/2018.
 */

public interface PnrApiInterface {
    @GET("/v2/pnr-status/pnr/{pnr_no}/apikey/wt1hggajop/")
    Call<BaseModel> pnrInfo(@Path("pnr_no") String pnrNo);

}
