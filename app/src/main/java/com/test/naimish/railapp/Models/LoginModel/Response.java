package com.test.naimish.railapp.Models.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by naimish on 4/1/2018.
 */

public class Response {

    @SerializedName("id")
    @Expose
    private String mId;

    @SerializedName("name")
    @Expose
    private String mName;

    @SerializedName("email")
    @Expose
    private String mEmail;

    @SerializedName("profile_url")
    @Expose
    private String mProfileUrl;

    public String getmId() {
        return mId;
    }

    public String getmName() {
        return mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmProfileUrl() {
        return mProfileUrl;
    }
}
