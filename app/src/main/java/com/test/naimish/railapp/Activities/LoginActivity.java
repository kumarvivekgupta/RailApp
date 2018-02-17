package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.LoginFragment;

/**
 * Created by naimish on 2/10/2018.
 */

public class LoginActivity extends SingleFragmentActivity {
    private static final String TOOLBAR_TITLE = "LOGIN";

    @Override
    protected boolean showToolbar() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return TOOLBAR_TITLE;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return LoginFragment.newInstance();
    }

}
