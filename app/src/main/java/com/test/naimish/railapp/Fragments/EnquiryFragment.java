package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageButton;

import com.test.naimish.railapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 2/17/2018.
 */

public class EnquiryFragment extends RailAppFragment {
    @BindView(R.id.pnr_enquiry)
    ImageButton mPnr;
    @BindView(R.id.live_train_status)
    ImageButton mLiveStatus;

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
        return R.layout.enquiry_page;
    }
}
