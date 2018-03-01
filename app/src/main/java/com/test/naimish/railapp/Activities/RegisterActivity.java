package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.RegisterFragment;
import com.test.naimish.railapp.R;

/**
 * Created by Vivek on 2/18/2018.
 */

public class RegisterActivity extends SingleFragmentActivity {
    private static final String TOOL_BAR_TITLE = "REGISTER PAGE";

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
        return R.color.colorPrimary;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return RegisterFragment.newInstance();
    }
}
