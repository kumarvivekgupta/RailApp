package com.test.naimish.railapp.Fragments;

import com.test.naimish.railapp.R;

/**
 * Created by naimish on 4/6/2018.
 */

public class SettingsFragment extends RailAppFragment {
    @Override
    protected int getResourceId() {
        return R.layout.fragment_settings;
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }
}
