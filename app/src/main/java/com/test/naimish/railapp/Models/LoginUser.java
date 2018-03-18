package com.test.naimish.railapp.Models;

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

    public LoginUser(String mEmail, String mPassword) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public String getToken() {
        return this.mToken;
    }


}
