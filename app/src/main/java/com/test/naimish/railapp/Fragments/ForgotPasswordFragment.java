package com.test.naimish.railapp.Fragments;

//Created by naimish on 02-05-2018

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;

import com.test.naimish.railapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordFragment extends RailAppFragment {

    @BindView(R.id.forgot_password_email)
    EditText email;

    @OnClick(R.id.forgot_password_button)
    public void submitEmailClicked(){

    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_forgot_passsword;
    }
    public static Fragment newInstance(){
        return new ForgotPasswordFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
