package com.test.naimish.railapp.Models.SeatAvailability;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 5/27/2018.
 */

public class QuotaModel {
    @SerializedName("name")
    @Expose
    private String quotaName;

    @SerializedName("code")
    @Expose
    private String quotaCode;

}
