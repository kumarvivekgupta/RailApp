package com.test.naimish.railapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Vivek on 3/14/2018.
 */

public class SharedPreference {
    private static final String DEFAULT = "N/A";

    public static boolean setPreference(Context context, String key, String value) {
        SharedPreferences setting = context.getSharedPreferences(key, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = setting.edit();
        editor.putString(key, value);
        return editor.commit();


    }

    public static String getPreference(Context context, String key) {
        SharedPreferences setting = context.getSharedPreferences(key, context.MODE_PRIVATE);
        return setting.getString(key, DEFAULT);

    }
}
