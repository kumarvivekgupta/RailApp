package com.test.naimish.railapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * Created by Vivek on 3/14/2018.
 */

public class LoginSharedPreference {
    private static final String DEFAULT="N/A";
    public static boolean setPreference(Context context,String key, String value) {
        SharedPreferences setting = context.getSharedPreferences(key,context.MODE_PRIVATE);
        SharedPreferences.Editor editor=setting.edit();
        editor.putString(key,value);
        return editor.commit();


        }
        public static String getPreference(Context context,String key){
        SharedPreferences setting=context.getSharedPreferences(key,context.MODE_PRIVATE);
        return setting.getString(key,DEFAULT);

        }
    }
