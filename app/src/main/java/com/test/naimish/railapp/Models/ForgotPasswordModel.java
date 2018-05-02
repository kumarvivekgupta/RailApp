package com.test.naimish.railapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPasswordModel {
    @SerializedName("email")
    @Expose
    private String mEmail;

    @SerializedName("success")
    @Expose
    private Boolean mIsSuccess;

    @SerializedName("message")
    @Expose
    private String mMessagge;

    public ForgotPasswordModel(String mEmail) {
        this.mEmail = mEmail;
    }

    public Boolean getResponse() {
        return this.mIsSuccess;
    }

    public String getMessage() {
        return this.mMessagge;
    }

}
