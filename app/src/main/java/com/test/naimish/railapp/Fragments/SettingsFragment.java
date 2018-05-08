package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.test.naimish.railapp.Models.UpdateProfile;
import com.test.naimish.railapp.Network.UpdateProfileNetwork.UpdateProfileApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Utils.SharedPreference;
import com.test.naimish.railapp.Views.ProgressLoader;

import agency.tango.android.avatarview.IImageLoader;
import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;
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

public class SettingsFragment extends RailAppFragment implements ResponseListener<UpdateProfile> {

    private String mOldName;
    private String mOldEmail;
    private String mNewName;
    private String mprofileUrl;
    private UpdateProfileApiClient apiClient;
    private ProgressLoader loader;
    private IImageLoader imageLoader;

    @BindView(R.id.edit_text_name)
    EditText mUserName;
    @BindView(R.id.edit_text_email)
    EditText mUserEmail;
    @BindView(R.id.save_settings)
    Button mSaveSettings;
    @BindView(R.id.user_profile_picture)
    AvatarView mProfilePic;

    @OnClick(R.id.change_password)
    public void changePassword() {
        FragmentManager manager=getActivity().getSupportFragmentManager();
        ChangePasswordFragment changePasswordFragment=new ChangePasswordFragment();
        changePasswordFragment.show(manager,"Settings Dialog");

    }

    @OnClick(R.id.change_profile_picture)
    public void changeProfilePicture() {
        Snackbar.make(getView(), "Feature comming soon...", Snackbar.LENGTH_SHORT).show();
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
        loader=new ProgressLoader(getActivity());
        imageLoader=new PicassoLoader();
        imageLoader.loadImage(mProfilePic,"random url",SharedPreference.getPreference(getContext(), NAME_CONSTANT));

    }

    private void changeSettings() {
        loader.showLoader();
        String userId = SharedPreference.getPreference(getContext(), USERID_CONSTANT);
        apiClient.updateProfile(userId, mNewName, mprofileUrl);
    }


    @Override
    public void onSuccess(UpdateProfile response) {
        loader.dismissLoader();
        if (response.getSuccess()) {
            SharedPreference.setPreference(getContext(), NAME_CONSTANT, mNewName);
            SharedPreference.setPreference(getContext(), PROFILE_PIC_CONSTANT, mprofileUrl);
            Snackbar.make(getView(), R.string.settings_success_message, Snackbar.LENGTH_SHORT).show();
            mUserName.setEnabled(false);
            mSaveSettings.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
            mSaveSettings.setTextColor(getActivity().getResources().getColor(R.color.fbutton_color_pomegranate));
            mSaveSettings.setEnabled(false);
        }
        else{
            Snackbar.make(getView(), R.string.common_error +" "+ R.string.try_again, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        loader.dismissLoader();
        Snackbar.make(getView(), throwable.getMessage().toString() +" "+ R.string.try_again, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onNullResponse() {
        loader.dismissLoader();
        Snackbar.make(getView(), R.string.common_error +" "+ R.string.try_again, Snackbar.LENGTH_SHORT).show();
    }

}
