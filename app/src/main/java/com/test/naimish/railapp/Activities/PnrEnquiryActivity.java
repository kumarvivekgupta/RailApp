package com.test.naimish.railapp.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.test.naimish.railapp.Fragments.PnrEnquiryFragment;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.RailAppConstants;

/**
 * Created by Vivek on 2/19/2018.
 */

public class PnrEnquiryActivity extends SingleFragmentActivity {
    private static final String TOOL_BAR_TITLE = "PNR ENQUIRY";

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
        return R.color.light_transparent;
    }

    @Override
    protected boolean showBackButton() {
        return true;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return PnrEnquiryFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getIntent().hasExtra(RailAppConstants.PNR_NO)) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.pnr_menu, menu);
            return true;
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.saved_pnrs:
                startActivity(new Intent(this, PnrHistory.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
