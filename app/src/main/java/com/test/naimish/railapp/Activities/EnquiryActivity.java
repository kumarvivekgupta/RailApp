package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.EnquiryFragment;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.EnquiryAdapter;

/**
 * Created by Vivek on 2/17/2018.
 */


public class EnquiryActivity extends SingleFragmentActivity implements EnquiryAdapter.Clicklistener {
    private static final String TOOLBAR_TITLE = "ENQUIRY";

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
    protected Fragment getFragmentInstance() {
        return EnquiryFragment.newInstance();
    }

    @Override
    public void itemclicked(int position) {

    }
}
