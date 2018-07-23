package com.test.naimish.railapp.Utils;

/**
 * Created by Vivek on 2/16/2018.
 */

public class Validations {
    public static boolean checkEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static boolean isEmpty(String string) {
        return string.length() == 0;
    }

    public static boolean checkPassword(String password) {
        return password.length() > 5;
    }

    public static boolean checkPassword(String password, String confirmPassword) {
        return password.length() > 5 && password.equals(confirmPassword);
    }

    public static boolean checkTrainNo(String trainNo) {
        return trainNo.length() == 5;
    }

    public static boolean checkPNR(String pnr) {
        return pnr.length() == 10;
    }

}
