package com.test.naimish.railapp.Activities;

import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.AddFragment;
import com.test.naimish.railapp.Views.BoldTextView;
import com.test.naimish.railapp.Views.ProgressLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by naimish on 2/10/2018.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    @BindView(R.id.tool_bar_title)
    BoldTextView mToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    protected abstract boolean showToolbar();

    protected abstract String getToolbarTitle();

    protected abstract int getToolbarColor();

    protected abstract boolean showBackButton();

    protected abstract Fragment getFragmentInstance();


    protected int getLayoutResourseId() {
        return R.layout.activity_single_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourseId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);

        ButterKnife.bind(this);
        if (showToolbar()) {
            setSupportActionBar(mToolbar);
            mToolbarTitle.setText(getToolbarTitle());
            if (getToolbarColor() != 0) {
                mToolbar.setBackgroundColor(getResources().getColor(getToolbarColor()));
            }
        } else {
            mToolbar.setVisibility(View.INVISIBLE);
        }
        if (showBackButton()) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        AddFragment.addFragment(getFragmentInstance(), this, R.id.container);

    }


}
