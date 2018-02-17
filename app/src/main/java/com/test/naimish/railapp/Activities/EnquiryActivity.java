package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;
import android.widget.Toolbar;

import com.test.naimish.railapp.Fragments.EnquiryFragment;

/**
 * Created by Vivek on 2/17/2018.
 */

public class EnquiryActivity extends SingleFragmentActivity {
    private static final String TOOLBAR_TITLE="Enquiry Page";
    @Override
    protected boolean showToolbar() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return TOOLBAR_TITLE ;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return EnquiryFragment.getInstance();
    }
}
