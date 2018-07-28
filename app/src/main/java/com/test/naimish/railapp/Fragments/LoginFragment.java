package com.test.naimish.railapp.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;

import com.test.naimish.railapp.Activities.EnquiryActivity;
import com.test.naimish.railapp.Activities.ForgotPasswordActivity;
import com.test.naimish.railapp.Models.LoginModel.LoginUser;
import com.test.naimish.railapp.Network.LoginNetwork.LoginApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Utils.SharedPreference;
import com.test.naimish.railapp.Utils.Validations;
import com.test.naimish.railapp.Views.ProgressLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.test.naimish.railapp.Utils.RailAppConstants.EMAIL_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.NAME_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.PROFILE_PIC_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.TOKEN_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.USERID_CONSTANT;

/**
 * Created by naimish on 2/10/2018.
 */

public class LoginFragment extends RailAppFragment implements ResponseListener<LoginUser> {
    private String mEmail;
    private String mPassword;
    private ProgressLoader loader;

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

    @OnClick(R.id.forgot_password)
    public void forgotPasswordClicked() {
        startActivity(new Intent(getActivity(), ForgotPasswordActivity.class));
    }

    private void loginUser() {
        loader.showLoader();
        LoginApiClient client = new LoginApiClient(this);
        client.loginUser(mEmail, mPassword);
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loader = new ProgressLoader(getActivity());
    }

    @Override
    public void onSuccess(LoginUser response) {
        loader.dismissLoader();
        if (response.getmIsSuccess()) {
            SharedPreference.setPreference(getContext(), TOKEN_CONSTANT, response.getToken());
            SharedPreference.setPreference(getContext(), USERID_CONSTANT, response.getmResponse().getmId());
            SharedPreference.setPreference(getContext(), NAME_CONSTANT, response.getmResponse().getmName());
            SharedPreference.setPreference(getContext(), EMAIL_CONSTANT, response.getmResponse().getmEmail());
            SharedPreference.setPreference(getContext(), PROFILE_PIC_CONSTANT, response.getmResponse().getmProfileUrl());
            getActivity().finish();
            startActivity(new Intent(getActivity(), EnquiryActivity.class));
        } else {
            Snackbar.make(getView(), response.getmMessage(), Snackbar.LENGTH_SHORT).show();

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
}
