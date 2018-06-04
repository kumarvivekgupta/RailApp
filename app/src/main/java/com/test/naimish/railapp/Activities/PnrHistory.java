package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;

import com.test.naimish.railapp.Fragments.PnrHistoryFragment;
import com.test.naimish.railapp.R;

public class PnrHistory extends SingleFragmentActivity {
    private static String TOOLBAR_TITLE = "History";

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
        return R.color.fbutton_color_pomegranate;
    }

    @Override
    protected boolean showBackButton() {
        return true;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return PnrHistoryFragment.newInstance();
    }
}
