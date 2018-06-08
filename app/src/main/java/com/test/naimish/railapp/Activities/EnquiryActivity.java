package com.test.naimish.railapp.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.test.naimish.railapp.Fragments.EnquiryFragment;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.SharedPreference;

import static com.test.naimish.railapp.Utils.RailAppConstants.EMAIL_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.NAME_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.TOKEN_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.USERID_CONSTANT;

/**
 * Created by Vivek on 2/17/2018.
 */


public class EnquiryActivity extends SingleFragmentActivity {
    private static final String TOOLBAR_TITLE = "ENQUIRY";
    private static int flag = 0;

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
        return false;
    }

    @Override
    protected Fragment getFragmentInstance() {
        return EnquiryFragment.newInstance();
    }


    @Override
    public void onBackPressed() {
        if (flag == 0) {
            Toast.makeText(this, "Press Again to exit", Toast.LENGTH_LONG).show();
            flag++;

        } else {
            super.onBackPressed();
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            this.finish();

        }


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
                startActivity(new Intent(this, SettingsActivity.class));
                break;
            case R.id.logout_menu_item:
                logout();
                break;
            case R.id.bug_report:
                startActivity(new Intent(this,BugReportActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {

        SharedPreference.setPreference(this, TOKEN_CONSTANT, "");
        SharedPreference.setPreference(this, USERID_CONSTANT, "");
        SharedPreference.setPreference(this, NAME_CONSTANT, "");
        SharedPreference.setPreference(this, EMAIL_CONSTANT, "");
        this.finish();
        startActivity(new Intent(this, LandingActivity.class));

    }

}
