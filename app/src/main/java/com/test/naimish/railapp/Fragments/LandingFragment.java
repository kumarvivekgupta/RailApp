package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.test.naimish.railapp.Activities.LoginActivity;
import com.test.naimish.railapp.Activities.RegisterActivity;
import com.test.naimish.railapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by naimish on 2/26/2018.
 */

public class LandingFragment extends RailAppFragment {

    @OnClick(R.id.landing_login)
    public void loginClicked() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }

    @OnClick(R.id.landing_register)
    public void signupClicked() {
        startActivity(new Intent(getActivity(), RegisterActivity.class));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_landing;
    }

    public static Fragment newInstance() {
        return new LandingFragment();
    }

}
