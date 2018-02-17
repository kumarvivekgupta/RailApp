package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.AddFragment;
import com.test.naimish.railapp.Views.BoldTextView;

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

    protected abstract Fragment getFragmentInstance();

    protected int getLayoutResourseId() {
        return R.layout.activity_single_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourseId());
        ButterKnife.bind(this);
        if (showToolbar()) {
            setSupportActionBar(mToolbar);
            mToolbarTitle.setText(getToolbarTitle());
        }
        AddFragment.addFragment(getFragmentInstance(), this, R.id.container);

    }
}
