package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.naimish.railapp.Fragments.SettingsFragment;
import com.test.naimish.railapp.R;

public class SettingsActivity extends SingleFragmentActivity {
    private static final String TOOLBAR_TITLE = "Settings";

    @Override
    protected boolean showToolbar() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return TOOLBAR_TITLE;
    }

    @Override
    protected int getToolbarColor() {
        return R.color.fbutton_color_pomegranate;
    }

    @Override
    protected boolean showBackButton() {
        return true;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return SettingsFragment.newInstance();
    }
}
