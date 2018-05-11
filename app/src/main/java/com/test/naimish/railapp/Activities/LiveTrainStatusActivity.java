package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.LiveTrainStatusFragment;
import com.test.naimish.railapp.R;

/**
 * Created by Vivek on 2/19/2018.
 */

public class LiveTrainStatusActivity extends SingleFragmentActivity {
    private static final String TOOLBAR_TITLE = "Live Status";

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
        return R.color.light_transparent;
    }

    @Override
    protected boolean showBackButton() {
        return true;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return LiveTrainStatusFragment.newInstance();
    }
}
