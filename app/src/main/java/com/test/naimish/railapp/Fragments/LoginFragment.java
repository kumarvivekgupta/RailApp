package com.test.naimish.railapp.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;

import com.test.naimish.railapp.Activities.EnquiryActivity;
import com.test.naimish.railapp.Models.LoginUser;
import com.test.naimish.railapp.Network.LoginNetwork.LoginApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.Validations;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by naimish on 2/10/2018.
 */

public class LoginFragment extends RailAppFragment implements LoginApiClient.LoginResponse {
    private String mEmail;
    private String mPassword;
    private ProgressDialog mProgress;

    @BindView(R.id.login_email)
    EditText mEmailField;
    @BindView(R.id.login_password)
    EditText mPasswordField;

    @OnClick(R.id.login_button)
    public void loginClicked() {
        mEmail = mEmailField.getText().toString();
        mPassword = mPasswordField.getText().toString();
        mEmailField.setError(null);
        mPasswordField.setError(null);
        View focusViewEmail = null;
        View focusViewPassword = null;
        Boolean killSwitch = false;
        if (!Validations.checkEmail(mEmail) || Validations.isEmpty(mEmail)) {
            mEmailField.setError(getString(R.string.email_error));
            focusViewEmail = mEmailField;
            killSwitch = true;
        }
        if (Validations.isEmpty(mPassword) && !Validations.checkPassword(mPassword)) {
            mPasswordField.setError(getResources().getString(R.string.password_error));
            focusViewPassword = mPasswordField;
            killSwitch = true;
        }
        if (killSwitch) {
            if (focusViewPassword != null)
                focusViewPassword.requestFocus();
            if (focusViewEmail != null)
                focusViewEmail.requestFocus();

        } else {
            loginUser();
        }
    }

    private void loginUser() {
        LoginApiClient client = new LoginApiClient(this);
        client.loginUser(mEmail, mPassword);
        startActivity(new Intent(getActivity(), EnquiryActivity.class));
    }


    @Override
    protected int getResourceId() {
        return R.layout.fragment_login;
    }

    public static Fragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onResponse(LoginUser response) {

    }
}
