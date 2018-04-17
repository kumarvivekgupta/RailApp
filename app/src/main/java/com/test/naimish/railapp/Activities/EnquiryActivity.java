package com.test.naimish.railapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.test.naimish.railapp.Fragments.EnquiryFragment;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.EnquiryAdapter;

import java.util.Set;

import butterknife.BindView;

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
            return super.onOptionsItemSelected(item);
        }
    }

    private void logout() {

        PreferenceManager.getDefaultSharedPreferences(getBaseContext()).
                edit().clear().apply();
        startActivity(new Intent(this, LandingActivity.class));

    }

}
