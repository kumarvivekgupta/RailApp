package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.test.naimish.railapp.Models.UpdateProfile;
import com.test.naimish.railapp.Network.ProfilePicUploadNetwork;
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
import static com.test.naimish.railapp.Utils.RailAppConstants.REQUEST_GALLERY_CODE;
import static com.test.naimish.railapp.Utils.RailAppConstants.SOME_RANDOM_STRING;
import static com.test.naimish.railapp.Utils.RailAppConstants.USERID_CONSTANT;

/**
 * Created by naimish on 4/6/2018.
 */

public class SettingsFragment extends RailAppFragment implements ResponseListener<UpdateProfile>, ProfilePicUploadNetwork.UploadPicResponse {

    private String mOldName;
    private String mOldEmail;
    private String mNewName;
    private String mProfileUrl;
    private UpdateProfileApiClient apiClient;
    private ProgressLoader loader;
    private IImageLoader imageLoader;
    private Uri mProfileUri;
    private Boolean isProfileChanged = false;


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
        FragmentManager manager = getActivity().getSupportFragmentManager();
        ChangePasswordFragment changePasswordFragment = new ChangePasswordFragment();
        changePasswordFragment.show(manager, "Settings Dialog");

    }

    @OnClick(R.id.change_profile_picture)
    public void changeProfilePicture() {
        selectProfilePicture();
    }


    @OnClick(R.id.edit_button)
    public void onEditClicked() {
        mUserName.setEnabled(true);
        mSaveSettings.setBackgroundColor(getActivity().getResources().getColor(R.color.fbutton_color_pomegranate));
        mSaveSettings.setTextColor(getActivity().getResources().getColor(R.color.white));
        mSaveSettings.setEnabled(true);

    }

    private void enableSaveBtn() {
        mUserName.setEnabled(true);
        mSaveSettings.setBackgroundColor(getActivity().getResources().getColor(R.color.fbutton_color_pomegranate));
        mSaveSettings.setTextColor(getActivity().getResources().getColor(R.color.white));
        mSaveSettings.setEnabled(true);
    }

    @OnClick(R.id.save_settings)
    public void saveSettings() {
        mNewName = mUserName.getText().toString();
        if (mNewName.equalsIgnoreCase(mOldName) && !isProfileChanged) {
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
        mProfileUrl = SharedPreference.getPreference(getContext(), PROFILE_PIC_CONSTANT);
        mUserName.setText(mOldName);
        mUserEmail.setText(mOldEmail);
        loader = new ProgressLoader(getActivity());
        imageLoader = new PicassoLoader();
        if (mProfileUrl.equals("")) {
            mProfileUrl = SOME_RANDOM_STRING;
        } // since profile url cannot be empty
        imageLoader.loadImage(mProfilePic, mProfileUrl, SharedPreference.getPreference(getContext(), NAME_CONSTANT));

    }

    private void changeSettings() {
        loader.showLoader();
        String userId = SharedPreference.getPreference(getContext(), USERID_CONSTANT);
        apiClient.updateProfile(userId, mNewName, mProfileUrl);
    }


    @Override
    public void onSuccess(UpdateProfile response) {
        loader.dismissLoader();
        if (response.getSuccess()) {
            SharedPreference.setPreference(getContext(), NAME_CONSTANT, mNewName);
            SharedPreference.setPreference(getContext(), PROFILE_PIC_CONSTANT, mProfileUrl);
            Snackbar.make(getView(), R.string.settings_success_message, Snackbar.LENGTH_SHORT).show();
            mUserName.setEnabled(false);
            mSaveSettings.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
            mSaveSettings.setTextColor(getActivity().getResources().getColor(R.color.fbutton_color_pomegranate));
            mSaveSettings.setEnabled(false);
        } else {
            Snackbar.make(getView(), R.string.common_error, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        loader.dismissLoader();
        Snackbar.make(getView(), throwable.getMessage().toString() + " " + R.string.try_again, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onNullResponse() {
        loader.dismissLoader();
        Snackbar.make(getView(), R.string.common_error, Snackbar.LENGTH_SHORT).show();
    }

    private void selectProfilePicture() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, REQUEST_GALLERY_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_GALLERY_CODE) {
            if (data != null) {
                mProfileUri = data.getData();
                this.uploadPic();
                this.enableSaveBtn();
                this.isProfileChanged = true;
                Log.i("Profile uri", mProfileUri + "");
            }

        }
    }

    private void uploadPic() {
        this.loader.showLoader();
        ProfilePicUploadNetwork profilePicUploadNetwork = new ProfilePicUploadNetwork(getContext());
        profilePicUploadNetwork.setInstance(this);
        profilePicUploadNetwork.uploadPic(mProfileUri);
    }

    @Override
    public void onSuccess(String url) {
        this.loader.dismissLoader();
        if (url != null) {
            this.mProfileUrl = url;
            if (mProfileUrl.equals("")) {
                mProfileUrl = SOME_RANDOM_STRING;
            } // since profile url cannot be empty
            imageLoader.loadImage(mProfilePic, this.mProfileUrl, SharedPreference.getPreference(getContext(), NAME_CONSTANT));
        }

    }

    @Override
    public void onFailure() {
        this.loader.dismissLoader();
        Snackbar.make(getView(), R.string.common_error, Snackbar.LENGTH_SHORT).show();
    }
}
