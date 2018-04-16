package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;

import com.test.naimish.railapp.Activities.EnquiryActivity;
import com.test.naimish.railapp.Activities.LandingActivity;
import com.test.naimish.railapp.Models.AuthorizationResponse;
import com.test.naimish.railapp.Network.TokenValidation.TokenApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Utils.SharedPreference;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by naimish on 4/1/2018.
 */

public class SplashFragment extends RailAppFragment implements TokenApiClient.TokenResponse {

    @BindView(R.id.splash_progress_bar)
    ProgressBar progressBar;

    private String mToken;
    @Override
    protected int getResourceId() {
        return R.layout.fragment_splash;
    }

    public static Fragment newInstance() {
        return new SplashFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressBar.setVisibility(View.VISIBLE);
        mToken= SharedPreference.getPreference(getContext(), RailAppConstants.TOKEN_CONSTANT);
        TokenApiClient apiClient=new TokenApiClient(this);
        apiClient.validateUser(mToken);
    }

    @Override
    public void onResponse(AuthorizationResponse data) {
        if(data.getmIsLoggedIn()){
            startActivity(new Intent(getActivity(), EnquiryActivity.class));
            getActivity().finish();
        }
        else{
            startActivity(new Intent(getActivity(), LandingActivity.class));
            getActivity().finish();
        }

    }
}
