package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;

import com.test.naimish.railapp.Activities.EnquiryActivity;
import com.test.naimish.railapp.Activities.LoginActivity;
import com.test.naimish.railapp.Models.RegisterUser;
import com.test.naimish.railapp.Network.RegisterNetwork.RegisterApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.Validations;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Vivek on 2/18/2018.
 */

public class RegisterFragment extends RailAppFragment implements RegisterApiClient.NetworkResponse {
    private String mEmail;
    private String mName;
    private String mPassword;
    private String mConfirmPassword;
    @BindView(R.id.email)
    EditText mEmailField;
    @BindView(R.id.name)
    EditText mNameField;
    @BindView(R.id.password)
    EditText mPasswordField;
    @BindView(R.id.confirm_password)
    EditText mConfirmPasswordField;

    public static Fragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_register;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick(R.id.register)
    public void userInfoAccount() {

        mName = mNameField.getText().toString();
        mEmail = mEmailField.getText().toString();
        mPassword = mPasswordField.getText().toString();
        mConfirmPassword = mConfirmPasswordField.getText().toString();
        mNameField.setError(null);
        mEmailField.setError(null);
        mPasswordField.setError(null);
        boolean killSwitch = false;
        View focusView = null;
        if (Validations.isEmpty(mName)) {
            mNameField.setError(getResources().getString(R.string.name_error));
            focusView = mNameField;
            killSwitch = true;
        }

        if (Validations.isEmpty(mPassword) || (!Validations.checkPassword(mPassword, mConfirmPassword))) {
            mPasswordField.setError(getResources().getString(R.string.password_error));
            focusView = mPasswordField;
            killSwitch = true;
        }
        if (!Validations.checkEmail(mEmail) || Validations.isEmpty(mEmail)) {
            mEmailField.setError(getString(R.string.email_error));
            focusView = mEmailField;
            killSwitch = true;
        }
        if (killSwitch) {
            focusView.requestFocus();
        } else {
            signUpUser();
        }
    }

    private void signUpUser() {
        RegisterApiClient client = new RegisterApiClient(this);
        client.createNewUser(mName, mEmail, mPassword);
    }

    @Override
    public void onResponse(RegisterUser data) {
        if (data.getResponse()) {
            startActivity(new Intent(getContext(), LoginActivity.class));
            getActivity().finish();
        } else {
            Snackbar.make(getView(), getResources().getString(R.string.user_already_registered), Snackbar.LENGTH_SHORT).show();
        }

    }
}
