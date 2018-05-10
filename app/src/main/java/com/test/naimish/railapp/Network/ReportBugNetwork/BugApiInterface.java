package com.test.naimish.railapp.Network.ReportBugNetwork;

import com.test.naimish.railapp.Models.RegisterUser;
import com.test.naimish.railapp.Models.ReportBug;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Vivek on 5/11/2018.
 */

public interface BugApiInterface {
    @POST("/users/bug")
    Call<ReportBug> reportedBug(@Body ReportBug reportBug);
}
