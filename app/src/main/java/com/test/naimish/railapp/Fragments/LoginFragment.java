package com.test.naimish.railapp.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.test.naimish.railapp.Activities.EnquiryActivity;
import com.test.naimish.railapp.Activities.RegisterActivity;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.Validations;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.hoang8f.widget.FButton;

/**
 * Created by naimish on 2/10/2018.
 */

public class LoginFragment extends RailAppFragment {
    private String mEmail;
    private String mPassword;
    private ProgressDialog mProgress;

    @BindView(R.id.login_email)
    EditText mEmailField;
    @BindView(R.id.login_password)
    EditText mPasswordField;
    @BindView(R.id.login_button)
    Button mLoginButtton;

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
            if (focusViewEmail != null)
                focusViewEmail.requestFocus();
            if (focusViewPassword != null)
                focusViewPassword.requestFocus();
        }
    }


    @Override
    protected int getResourceId() {
        return R.layout.login_fragment;
    }

    public static Fragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

}
