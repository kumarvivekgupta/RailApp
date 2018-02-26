package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.naimish.railapp.Fragments.LandingFragment;

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
    protected Fragment getFragmentInstance() {
        return LandingFragment.newInstance();
    }
}
