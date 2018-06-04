package com.test.naimish.railapp.Models.UserPnrs;

//creared by naimish on 27-05-18

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SavedPnrs {

    @SerializedName("id")
    @Expose()
    private String userId;

    @SerializedName("pnrSearched")
    @Expose
    private String pnrSearched;

    @SerializedName("status")
    @Expose
    private Boolean responseStatus;

    @SerializedName("message")
    @Expose
    private String message;

    public SavedPnrs(String userId, String pnrSearched) {
        this.userId = userId;
        this.pnrSearched = pnrSearched;
    }

    public Boolean getResponseStatus() {
        return responseStatus;
    }

    public String getMessage() {
        return message;
    }
}
