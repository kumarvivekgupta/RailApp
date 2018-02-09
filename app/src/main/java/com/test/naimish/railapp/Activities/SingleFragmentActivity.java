package com.test.naimish.railapp.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.AddFragment;
import com.test.naimish.railapp.Views.BoldTextView;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    private BoldTextView toolbarTitle;
    private Toolbar toolbar;

    protected abstract boolean showToolbar();

    protected abstract String getToolbarTitle();

    protected abstract Fragment getFragmentInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.tool_bar_title);
        if (showToolbar()) {
            setSupportActionBar(toolbar);
            toolbarTitle.setText(getToolbarTitle());
        }
        AddFragment.addFragment(getFragmentInstance(), this, R.id.container);

    }
}
