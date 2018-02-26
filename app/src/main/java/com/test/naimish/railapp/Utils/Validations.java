package com.test.naimish.railapp.Utils;

/**
 * Created by Vivek on 2/16/2018.
 */

public class Validations {
    public static boolean checkEmail(String email) {

        if (email.contains("@")
                && email.contains(".")
                && email.indexOf('.') > email.indexOf('@') + 1)
            return true;


        return false;
    }

    public static boolean isEmpty(String string) {
        if (string.length() == 0)
            return true;
        else
            return false;
    }

    public static boolean checkPassword(String password) {
        if (password.length() > 5)
            return true;
        else
            return false;
    }

    public static boolean checkPassword(String password, String confirmPassword) {
        if (password.length() > 5 && password.equals(confirmPassword))
            return true;
        else return false;
    }

}
