package com.test.naimish.railapp.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by naimish on 2/10/2018.
 */

public class AddFragment {
    private static FragmentTransaction fragmentTransaction = null;
    private static FragmentManager fragmentManager = null;

    public static void addFragment(Fragment fragment, AppCompatActivity appCompatActivity,int container) {
        fragmentManager=appCompatActivity.getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(container,fragment).commit();
    }
}
