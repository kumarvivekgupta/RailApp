package com.test.naimish.railapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthorizationResponse {

    @SerializedName("success")
    @Expose
    private Boolean mIsLoggedIn;

    public Boolean getmIsLoggedIn() {
        return mIsLoggedIn;
    }

}
