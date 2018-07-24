package com.test.naimish.railapp.Models.UserPnrs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPnrs {
    @SerializedName("success")
    @Expose
    private Boolean message;
    @SerializedName("pnrSearched")
    @Expose
    private String[] savedPnrs;

    public Boolean getStatus() {
        return message;
    }

    public String[] getSavedPnrs() {
        return savedPnrs;
    }
}
