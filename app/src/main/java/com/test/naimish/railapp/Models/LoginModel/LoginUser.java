package com.test.naimish.railapp.Models.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 3/16/2018.
 */

public class LoginUser {

    @SerializedName("email")
    @Expose
    private String mEmail;

    @SerializedName("password")
    @Expose
    private String mPassword;

    @SerializedName("token")
    @Expose
    private String mToken;

    @SerializedName("success")
    @Expose
    private boolean mIsSuccess;

    @SerializedName("user")
    @Expose
    private Response mResponse;

    @SerializedName("msg")
    @Expose
    private String mMessage;

    public LoginUser(String mEmail, String mPassword) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public String getToken() {
        return this.mToken;
    }

    public Response getmResponse() {
        return this.mResponse;
    }

    public Boolean getmIsSuccess() {
        return this.mIsSuccess;
    }

    public String getmMessage() {
        return mMessage;
    }
}
