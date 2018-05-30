package com.test.naimish.railapp.Utils;

import java.util.ArrayList;

/**
 * Created by Vivek on 5/29/2018.
 */

public class SeatClassAndQuotaContants {
    private static final ArrayList<String> trainquota = new ArrayList<>();
    private static final ArrayList<String> trainClassCode = new ArrayList<>();


    public static ArrayList<String> addQuotaCode() {
        trainquota.add("GN");
        trainquota.add("LD");
        trainquota.add("HO");
        trainquota.add("DF");
        trainquota.add("PH");
        trainquota.add("FT");
        trainquota.add("DP");
        trainquota.add("TQ");
        trainquota.add("PT");
        trainquota.add("SS");
        trainquota.add("HP");
        trainquota.add("RE");
        trainquota.add("GNRS");
        trainquota.add("OS");
        trainquota.add("PQ");
        trainquota.add("RC(RAS)");
        trainquota.add("RS");
        trainquota.add("YU");
        trainquota.add("LB");
        return trainquota;
    }

    public static ArrayList<String> addClassCode() {
        trainClassCode.add("1A");
        trainClassCode.add("2A");
        trainClassCode.add("FC");
        trainClassCode.add("CC");
        trainClassCode.add("SL");
        trainClassCode.add("2S");


        return trainClassCode;
    }

}
