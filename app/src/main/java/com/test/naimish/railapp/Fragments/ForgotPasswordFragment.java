package com.test.naimish.railapp.Fragments;

//Created by naimish on 02-05-2018

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;

import com.test.naimish.railapp.Activities.LoginActivity;
import com.test.naimish.railapp.Models.ForgotPasswordModel;
import com.test.naimish.railapp.Network.ForgotPasswordNetwork.ForgotPasswordApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Utils.Validations;
import com.test.naimish.railapp.Views.ProgressLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordFragment extends RailAppFragment implements ResponseListener<ForgotPasswordModel>{
    private String mEmail;
    private ProgressLoader loader;

    @BindView(R.id.forgot_password_email)
    EditText email;

    @OnClick(R.id.forgot_password_button)
    public void submitEmailClicked() {
        mEmail = email.getText().toString();
        if (Validations.checkEmail(mEmail) && !Validations.isEmpty(mEmail)) {
            sendNewPassword();
        } else {
            email.setError(getActivity().getResources().getString(R.string.email_error));
        }
    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_forgot_passsword;
    }

    public static Fragment newInstance() {
        return new ForgotPasswordFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loader=new ProgressLoader(getActivity());

    }

    private void sendNewPassword(){
        loader.showLoader();
        ForgotPasswordApiClient apiClient=new ForgotPasswordApiClient(this);
        apiClient.createNewUser(mEmail);
    }

    @Override
    public void onSuccess(ForgotPasswordModel response) {
        loader.dismissLoader();
        if(response.getResponse()){
            startActivity(new Intent(getActivity(), LoginActivity.class));
            getActivity().finish();
        }
        else{
            Snackbar.make(getView(),response.getMessage(),Snackbar.LENGTH_SHORT).show();
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
        Snackbar.make(getView(), R.string.common_error, Snackbar.LENGTH_SHORT).show();
    }
}
