package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.SeatAvalibilityEnquiryFragment;
import com.test.naimish.railapp.R;

/**
 * Created by Vivek on 5/29/2018.
 */

public class SeatAvalibilityEnquiryActivity extends SingleFragmentActivity {
    private final String TITLE="Seat Enquiry";
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
        return R.color.transparent;
    }

    @Override
    protected boolean showBackButton() {
        return true;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return SeatAvalibilityEnquiryFragment.newInstance();
    }
}
