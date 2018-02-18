package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.test.naimish.railapp.Activities.EnquiryActivity;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.Validations;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vivek on 2/18/2018.
 */

public class RegisterFragment extends RailAppFragment {
    private String mEmail;
    private String mPassword;
    private String mConfirmPassword;
    @BindView(R.id.email)
    EditText mEailField;
    @BindView(R.id.password)
    EditText mPasswordField;
    @BindView(R.id.confirmpassword)
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
        return R.layout.sign_up;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick(R.id.register)
    public void registerUser() {
        mEmail = mEailField.getText().toString();
        mPassword = mPasswordField.getText().toString();
        mConfirmPassword = mConfirmPasswordField.getText().toString();
        mEailField.setError(null);
        mPasswordField.setError(null);
        boolean killSwitch = false;
        View focusView = null;
        if (!Validations.checkEmail(mEmail) || Validations.isEmpty(mEmail)) {
            mEailField.setError(getString(R.string.email_error));
            focusView = mEailField;
            killSwitch = true;
        }
        if (Validations.isEmpty(mPassword) ||(!Validations.checkPassword(mPassword, mConfirmPassword))) {
            mPasswordField.setError(getResources().getString(R.string.password_error));
            focusView = mPasswordField;
            killSwitch = true;
        }
        if (killSwitch) {
            focusView.requestFocus();
        } else {
            signUpUser();
        }
    }

    private void signUpUser() {
        if (true) {
            startActivity(new Intent(getActivity(), EnquiryActivity.class));
        } else {
            Toast.makeText(getContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
        }
    }
}
