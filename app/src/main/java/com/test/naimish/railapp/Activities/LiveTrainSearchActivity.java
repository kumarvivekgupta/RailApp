package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.LiveTrainSearchFragment;
import com.test.naimish.railapp.R;

/**
 * Created by Vivek on 4/4/2018.
 */

public class LiveTrainSearchActivity extends SingleFragmentActivity {
    private final String TOOL_BAR_TITLE="Spot Your Train";
    @Override
    protected boolean showToolbar() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return TOOL_BAR_TITLE;
    }

    @Override
    protected int getToolbarColor() {
        return R.color.transparent;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return LiveTrainSearchFragment.newInstance();
    }
}
