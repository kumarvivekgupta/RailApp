package com.test.naimish.railapp.Activities;

// Created by naimish on 2-5-18

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.ForgotPasswordFragment;
import com.test.naimish.railapp.R;

public class ForgotPasswordActivity extends SingleFragmentActivity {
    private static final String TOOLBAR_TITLE="FORGOT PASSWORD";
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
        return R.color.transparent;
    }

    @Override
    protected boolean showBackButton() {
        return true;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return ForgotPasswordFragment.newInstance();
    }
}
