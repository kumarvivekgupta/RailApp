package com.test.naimish.railapp.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.Toast;

import com.test.naimish.railapp.Fragments.LiveTrainSearchFragment;
import com.test.naimish.railapp.R;

/**
 * Created by Vivek on 4/4/2018.
 */

public class LiveTrainSearchActivity extends SingleFragmentActivity {
    private final String TOOL_BAR_TITLE = "Spot Your Train";

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
        return R.color.transparent;
    }

    @Override
    protected boolean showBackButton() {
        return true;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return LiveTrainSearchFragment.newInstance();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            startActivity(new Intent(this, EnquiryActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
