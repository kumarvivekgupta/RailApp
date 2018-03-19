package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.LandingFragment;
import com.test.naimish.railapp.R;

public class LandingActivity extends SingleFragmentActivity {

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
        return LandingFragment.newInstance();
    }
}
