package com.test.naimish.railapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by naimish on 3/14/2018.
 */

public class RegisterUser {
    @SerializedName("name")
    @Expose
    private String mName;

    @SerializedName("email")
    @Expose
    private String mEmail;

    @SerializedName("password")
    @Expose
    private String mPassword;

    @SerializedName("success")
    @Expose
    private Boolean mIsSuccess;

    @SerializedName("msg")
    @Expose
    private String mMessagge;

    public RegisterUser(String mName, String mPassword, String mEmail) {
        this.mEmail = mEmail;
        this.mName = mName;
        this.mPassword = mPassword;

    }

    public Boolean getResponse() {
        return this.mIsSuccess;
    }

    public String getMessage() {
        return this.mMessagge;
    }

}
