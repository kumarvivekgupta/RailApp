package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;

import com.test.naimish.railapp.Activities.SettingsActivity;
import com.test.naimish.railapp.Models.ChangePassword;
import com.test.naimish.railapp.Network.ChangePasswordNetwork.ChangePasswordApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Utils.SharedPreference;
import com.test.naimish.railapp.Utils.Validations;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vivek on 3/9/2018.
 */

public class ChangePasswordFragment extends RailAppFragment implements ResponseListener<ChangePassword> {
    private String mOldPassword;
    private String mNewPassword;
    private String mConfirmPassword;
    private int flag=0;

    @BindView(R.id.old_password)
    EditText oldPassword;
    @BindView(R.id.new_password)
    EditText newPassword;
    @BindView(R.id.comfirm_new_password)
    EditText confirmNewPassword;

    @Override
    protected int getResourceId() {
        return R.layout.fragment_change_password;
    }


    public static Fragment newInstance() {
        return new ChangePasswordFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.comfirm_new_password_button)
    public void changePassword() {
        mNewPassword = newPassword.getText().toString();
        mConfirmPassword = confirmNewPassword.getText().toString();
        mOldPassword = oldPassword.getText().toString();
        newPassword.setError(null);
        oldPassword.setError(null);
        boolean killSwtich = false;
        View focusView = null;
        if (Validations.isEmpty(mOldPassword)) {
            oldPassword.setError(getResources().getString(R.string.password_error));
            killSwtich = true;
            focusView = oldPassword;
        }
        if (!Validations.checkPassword(mOldPassword)) {
            oldPassword.setError(getResources().getString(R.string.password_error));
            killSwtich = true;
            focusView = oldPassword;

        }
        if (!Validations.checkPassword(mNewPassword) || !Validations.checkPassword(mNewPassword, mConfirmPassword)) {
            newPassword.setError(getResources().getString(R.string.password_error));
            killSwtich = true;
            focusView = newPassword;

        }
        if (killSwtich)
            focusView.requestFocus();
        else {
            String userid = SharedPreference.getPreference(getContext(), RailAppConstants.USERID_CONSTANT);
            ChangePasswordApiClient apiClient = new ChangePasswordApiClient(this);
            apiClient.changePassword(userid, mOldPassword, mNewPassword);
        }
    }


    @Override
    public void onSuccess(ChangePassword response) {
        if (response.isSuccess()) {
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            Snackbar.make(getView(), R.string.change_password_msg, Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar.make(getView(), response.getMessage(), Snackbar.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailure() {
        Snackbar.make(getView(), R.string.common_error + R.string.try_again, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onNullResponse() {
        Snackbar.make(getView(), R.string.common_error + R.string.try_again, Snackbar.LENGTH_SHORT).show();
    }
}
