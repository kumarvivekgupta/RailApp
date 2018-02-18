package com.test.naimish.railapp.Utils;

/**
 * Created by Vivek on 2/16/2018.
 */

public class Validations {
    public static boolean checkEmail(String email) {
        return email.contains("@");
    }

    public static boolean isEmpty(String string) {
        if (string.length() == 0)
            return true;
        else
            return false;
    }

    public static boolean checkPassword(String password, String confirm_password) {
        if (password.length() > 5 && password.equals(confirm_password))
            return true;
        else
            return false;
    }
}
