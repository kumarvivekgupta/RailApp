package com.test.naimish.railapp.Utils;

/**
 * Created by Vivek on 5/9/2018.
 */

public class TimeConversion {

    public static int hours(String a) {
        int h=Integer.parseInt(a);
        h = h/ 60;
        return h;
    }

    public static int min(String a) {
        int h=Integer.parseInt(a);
        h = h% 60;
        return h;
    }

}
