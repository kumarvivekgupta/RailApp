package com.test.naimish.railapp.Network;

import com.test.naimish.railapp.Models.AuthorizationResponse;
import com.test.naimish.railapp.Models.ChangePassword;
import com.test.naimish.railapp.Models.ForgotPasswordModel;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.LiveStatusBaseModel;
import com.test.naimish.railapp.Models.LoginModel.LoginUser;
import com.test.naimish.railapp.Models.PnrModel.BaseModel;
import com.test.naimish.railapp.Models.RegisterUser;
import com.test.naimish.railapp.Models.ReportBug;
import com.test.naimish.railapp.Models.SeatAvailability.TrainSeatBaseModel;
import com.test.naimish.railapp.Models.StationAutoCompleteBaseModel;
import com.test.naimish.railapp.Models.UpdateProfile;
import com.test.naimish.railapp.Models.UserPnrs.DeletePnrs;
import com.test.naimish.railapp.Models.UserPnrs.GetPnrs;
import com.test.naimish.railapp.Models.UserPnrs.SavedPnrs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("/users/change-password")
    Call<ChangePassword> changePasssword(@Body ChangePassword changePassword);

    @POST("/users/forgot")
    Call<ForgotPasswordModel> sendNewPassword(@Body ForgotPasswordModel email);

    @GET("/v2/live/train/{train_no}/date/{date}/apikey/tz807ec2yk/")
    Call<LiveStatusBaseModel> liveTrainInfo(@Path("train_no") String trainNo, @Path("date") String date);

    @POST("/users/login")
    Call<LoginUser> login(@Body LoginUser loginUser);

    @GET("/v2/pnr-status/pnr/{pnr_no}/apikey/tz807ec2yk/")
    Call<BaseModel> pnrInfo(@Path("pnr_no") String pnrNo);

    @POST("/users/register")
    Call<RegisterUser> createUser(@Body RegisterUser registerUser);

    @POST("/users/bug")
    Call<ReportBug> reportedBug(@Body ReportBug reportBug);


    @GET("/v2/check-seat/train/{train_number}/source/{stn_code}/dest/{dest_code}/" +
            "date/{date}/pref/{class_code}/quota/{quota_code}/apikey/tz807ec2yk/")
    Call<TrainSeatBaseModel> seatAvalibilityStatus(@Path("train_number") String trainNo,
                                                   @Path("stn_code") String stationCode,
                                                   @Path("dest_code") String destCode,
                                                   @Path("date") String date,
                                                   @Path("class_code") String classCode,
                                                   @Path("quota_code") String quota);

    @GET("/v2/suggest-station/name/{partial_station_name}/apikey/tz807ec2yk/")
    Call<StationAutoCompleteBaseModel> stationAutoCompleteInfo(@Path("partial_station_name")String stationPartialName);

    @GET("/users/validate")
    Call<AuthorizationResponse> getAutherization(@Header("Authorization") String token);

    @POST("/users/update-profile")
    Call<UpdateProfile> updateProfile(@Body UpdateProfile updateProfile);

    @DELETE("/users/clear-history")
    Call<DeletePnrs> deleteSavedPnrs(@Query("id") String userId);

    @GET("/users/pnr-search")
    Call<GetPnrs> getUserSavedPnrs(@Query("id") String id);

    @POST("/users/pnr-search")
    Call<SavedPnrs> saveUserPnr(@Body SavedPnrs savedPnrs);

}
