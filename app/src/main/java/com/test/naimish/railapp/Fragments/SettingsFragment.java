package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.test.naimish.railapp.Activities.ChangePasswordActivity;
import com.test.naimish.railapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by naimish on 4/6/2018.
 */

public class SettingsFragment extends RailAppFragment {

    private String oldName;
    private String oldEmail;

    @BindView(R.id.edit_text_name)
    EditText mUserName;

    @BindView(R.id.edit_text_email)
    EditText mUserEmail;

    @OnClick(R.id.change_password)
    public void changePassword() {
        startActivity(new Intent(getActivity(), ChangePasswordActivity.class));
    }

    @OnClick(R.id.change_profile_picture)
    public void changeProfilePicture() {

    }

    @OnClick(R.id.save_settings)
    public void saveSettings() {

    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_settings;
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }
}
