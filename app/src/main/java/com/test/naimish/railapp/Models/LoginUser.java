package com.test.naimish.railapp.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 3/16/2018.
 */

public class LoginUser {
    @SerializedName("email")
    private String mEmail;
    @SerializedName("password")
    private String mPassword;
    @SerializedName("token")
    private String mToken;

    public LoginUser(String mEmail, String mPassword) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;

    }

    public String getmToken() {

        return this.mToken;
    }


}
