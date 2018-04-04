package com.test.naimish.railapp.Fragments;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.R;

/**
 * Created by Vivek on 4/4/2018.
 */

public class LiveTrainSearchFragment extends RailAppFragment {
    @Override
    protected int getResourceId() {
        return R.layout.live_train_search;
    }
    public static Fragment newInstance(){
        return  new LiveTrainStatusFragment();
    }
}
