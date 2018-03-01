package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.test.naimish.railapp.Network.PnrNetwork.PnrApiClient;
import com.test.naimish.railapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vivek on 2/19/2018.
 */

public class PnrEnquiryFragment extends RailAppFragment {
    @Override
    protected int getResourceId() {
        return R.layout.fragment_pnr;
    }

    @BindView(R.id.pnr_text)
    EditText pnrText;
    @BindView(R.id.submit_pnr)
    Button submitPnr;

    @OnClick(R.id.submit_pnr)

    public void getPnrStatus() {
        PnrApiClient.getPnrStatus(pnrText.getText().toString());
    }

    public static Fragment newInstance() {
        return new PnrEnquiryFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

}
