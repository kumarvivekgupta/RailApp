package com.test.naimish.railapp.Fragments;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.R;

/**
 * Created by naimish on 4/1/2018.
 */

public class SplashFragment extends RailAppFragment {
    @Override
    protected int getResourceId() {
        return R.layout.fragment_splash;
    }
    public static Fragment newInstance(){
        return new SplashFragment();
    }
}
