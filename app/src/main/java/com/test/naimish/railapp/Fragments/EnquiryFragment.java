package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.test.naimish.railapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 2/17/2018.
 */

public class EnquiryFragment extends Fragment {
    @BindView(R.id.pnr_enquiry)
    Button mPnr;
    @BindView(R.id.live_train_status)
    Button mLiveStatus;

    public static Fragment getInstance() {
        return new EnquiryFragment();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_single_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

}
