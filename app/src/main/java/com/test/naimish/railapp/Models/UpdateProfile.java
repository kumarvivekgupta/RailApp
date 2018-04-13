package com.test.naimish.railapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateProfile {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("profile_url")
    @Expose
    private String profileUrl;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("success")
    @Expose
    private Boolean success;

    public UpdateProfile(String id, String name, String profileUrl) {
        this.id = id;
        this.name = name;
        this.profileUrl = profileUrl;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }
}
