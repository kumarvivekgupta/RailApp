package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.BugReportFragment;
import com.test.naimish.railapp.R;

/**
 * Created by Vivek on 5/10/2018.
 */

public class BugReportActivity extends SingleFragmentActivity {
    private final String TITLE = "Bug Report";

    @Override
    protected boolean showToolbar() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return TITLE;
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
        return BugReportFragment.newInstance();
    }
}
