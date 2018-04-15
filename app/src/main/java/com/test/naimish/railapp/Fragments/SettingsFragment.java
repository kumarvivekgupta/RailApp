package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.test.naimish.railapp.Activities.ChangePasswordActivity;
import com.test.naimish.railapp.Models.UpdateProfile;
import com.test.naimish.railapp.Network.UpdateProfileNetwork.UpdateProfileApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Utils.SharedPreference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.test.naimish.railapp.Utils.RailAppConstants.EMAIL_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.NAME_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.PROFILE_PIC_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.USERID_CONSTANT;

/**
 * Created by naimish on 4/6/2018.
 */

public class SettingsFragment extends RailAppFragment implements UpdateProfileApiClient.UpdateProfileResponse {

    private String mOldName;
    private String mOldEmail;
    private String mNewName;
    private String mprofileUrl;
    private UpdateProfileApiClient apiClient;

    @BindView(R.id.edit_text_name)
    EditText mUserName;
    @BindView(R.id.edit_text_email)
    EditText mUserEmail;
    @BindView(R.id.save_settings)
    Button mSaveSettings;

    @OnClick(R.id.change_password)
    public void changePassword() {
        startActivity(new Intent(getActivity(), ChangePasswordActivity.class));
    }

    @OnClick(R.id.change_profile_picture)
    public void changeProfilePicture() {

    }


    @OnClick(R.id.edit_button)
    public void onEditClicked() {
        mUserName.setEnabled(true);
        mSaveSettings.setBackgroundColor(getActivity().getResources().getColor(R.color.fbutton_color_pomegranate));
        mSaveSettings.setTextColor(getActivity().getResources().getColor(R.color.white));
        mSaveSettings.setEnabled(true);

    }

    @OnClick(R.id.save_settings)
    public void saveSettings() {
        mNewName = mUserName.getText().toString();
        if (mNewName.equalsIgnoreCase(mOldName)) {
            Snackbar.make(getView(), R.string.settings_unchanged_message, Snackbar.LENGTH_SHORT).show();
        } else {
            changeSettings();
        }

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
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        apiClient = new UpdateProfileApiClient(this);
        mOldName = SharedPreference.getPreference(getContext(), NAME_CONSTANT);
        mOldEmail = SharedPreference.getPreference(getContext(), EMAIL_CONSTANT);
        mUserName.setText(mOldName);
        mUserEmail.setText(mOldEmail);


    }

    private void changeSettings() {
        String userId = SharedPreference.getPreference(getContext(), USERID_CONSTANT);
        apiClient.updateProfile(userId, mNewName, mprofileUrl);
    }


    @Override
    public void onResponse(UpdateProfile updateProfile) {
        if (updateProfile.getSuccess()) {
            SharedPreference.setPreference(getContext(), NAME_CONSTANT, mNewName);
            SharedPreference.setPreference(getContext(), PROFILE_PIC_CONSTANT, mprofileUrl);
            Snackbar.make(getView(), R.string.settings_success_message, Snackbar.LENGTH_SHORT).show();
        }
    }
}
