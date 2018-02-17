package com.test.naimish.railapp.Utils;

/**
 * Created by Vivek on 2/16/2018.
 */

public class Validations {
    public static boolean checkEmail(String email) {
        return email.contains("@");
    }

    public static boolean emptyEmail(String email) {
        if (email.length() == 0)
            return false;
        else
            return true;
    }

    public static boolean checkPassword(String password, String confirm_password) {
        if (password.length() > 5 && confirm_password.equals(confirm_password))
            return true;
        else
            return false;
    }
}
