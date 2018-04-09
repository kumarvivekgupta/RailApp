package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.ChangePasswordFragment;
import com.test.naimish.railapp.R;

/**
 * Created by Vivek on 3/9/2018.
 */

public class ChangePasswordActivity extends SingleFragmentActivity {


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
        return R.color.transparent;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return ChangePasswordFragment.newInstance();
    }
}
