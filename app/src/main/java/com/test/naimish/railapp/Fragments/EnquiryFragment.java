package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.test.naimish.railapp.Activities.LiveTrainStatusActivity;
import com.test.naimish.railapp.Activities.PnrEnquiryActivity;
import com.test.naimish.railapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vivek on 2/17/2018.
 */

public class EnquiryFragment extends RailAppFragment {

    public static Fragment newInstance() {
        return new EnquiryFragment();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_enquiry;
    }

  //  @OnClick(R.id.pnr_enquiry)
    public void pnrEnquiry() {
        startActivity(new Intent(getActivity(), PnrEnquiryActivity.class));
    }

  //  @OnClick(R.id.live_train_status)
    public void lineTrainStatus() {
        startActivity(new Intent(getActivity(), LiveTrainStatusActivity.class));
    }
}
