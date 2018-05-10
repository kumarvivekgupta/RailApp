package com.test.naimish.railapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 5/10/2018.
 */

public class ReportBug {

    @SerializedName("email")
    @Expose
    private String userEmail;

    @SerializedName("message")
    @Expose
    private String bugMessage;

    @SerializedName("success")
    @Expose
    private boolean bugSuccess;

//    @SerializedName("message")
//    @Expose
//    private String userEmailInfo;


    public ReportBug(String userEmail, String bugMessage) {
        this.userEmail = userEmail;
        this.bugMessage = bugMessage;
    }

    public boolean isBugSuccess() {
        return bugSuccess;
    }

//    public String getUserEmailInfo() {
//        return userEmailInfo;
//    }
}
