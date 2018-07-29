package com.test.naimish.railapp.Utils;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.naimish.railapp.R;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static android.content.ContentValues.TAG;

/**
 * Created by Vivek on 6/14/2018.
 */

public class StationListAndCode {
    private String[] a;
    public static Context stationContext;

    public StationListAndCode(Context stationContext) {
        this.stationContext = stationContext;
    }

    public String getStationCode(String stationName) {
        return StationListAndCode.getStationHashMap().get(stationName);
    }

    public String[] getStationName() {
        return StationListAndCode.getStationHashMap().keySet().toArray(new String[0]);
    }


    private static String getStationListJson(Context context) {
        String s1="";
        s1= context.getResources().getString(R.string.station_list);
        Log.i("StringStation",s1);
        return s1;
    }

    private static HashMap<String, String> getStationHashMap() {
        Gson gson = new Gson();
        return gson.fromJson(StationListAndCode.getStationListJson(stationContext), new TypeToken<LinkedHashMap<String, String>>() {
        }.getType());
    }
}
