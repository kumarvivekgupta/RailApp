package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.test.naimish.railapp.Fragments.EnquiryFragment;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.EnquiryAdapter;

/**
 * Created by Vivek on 2/17/2018.
 */


public class EnquiryActivity extends SingleFragmentActivity {
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_menu_item:
                
        }
        return super.onOptionsItemSelected(item);
    }
}
