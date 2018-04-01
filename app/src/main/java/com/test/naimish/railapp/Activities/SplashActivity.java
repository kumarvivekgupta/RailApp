package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.SplashFragment;

public class SplashActivity extends SingleFragmentActivity {

    @Override
    protected boolean showToolbar() {
        return false;
    }

    @Override
    protected String getToolbarTitle() {
        return null;
    }

    @Override
    protected int getToolbarColor() {
        return 0;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return SplashFragment.newInstance();
    }
}
