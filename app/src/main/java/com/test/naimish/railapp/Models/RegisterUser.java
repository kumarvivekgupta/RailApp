package com.test.naimish.railapp.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by naimish on 3/14/2018.
 */

public class RegisterUser {
    @SerializedName("name")
    private String mName;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("password")
    private String mPassword;

    @SerializedName("success")
    private Boolean mIsSuccess;

    public RegisterUser(String mName, String mPassword, String mEmail) {
        this.mEmail = mEmail;
        this.mName = mName;
        this.mPassword = mPassword;

    }

    public Boolean getResponse() {
        return this.mIsSuccess;
    }

}
