package com.test.naimish.railapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by naimish on 4/7/2018.
 */

public class ChangePassword {

    @SerializedName("id")
    @Expose
    private String userId;

    @SerializedName("oldPassword")
    @Expose
    private String oldPassword;

    @SerializedName("newPassword")
    @Expose
    private String newPassword;

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    public ChangePassword(String userId, String oldPassword, String newPassword) {
        this.userId = userId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
