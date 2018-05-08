package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdView;
import com.test.naimish.railapp.Models.PassengerRecyclerModel;
import com.test.naimish.railapp.Models.PnrModel.BaseModel;
import com.test.naimish.railapp.Models.PnrModel.PassengerModel;
import com.test.naimish.railapp.Network.PnrNetwork.PnrApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.AddService;
import com.test.naimish.railapp.Utils.EnquiryAdapter;
import com.test.naimish.railapp.Utils.PassengerAdapter;
import com.test.naimish.railapp.Utils.Validations;
import com.test.naimish.railapp.Views.LightTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Vivek on 2/19/2018.
 */

public class PnrEnquiryFragment extends RailAppFragment implements PnrApiClient.PnrResponse {
    private BaseModel mBaseModel;

    private PassengerAdapter madapter;
    private ArrayList<PassengerModel> mPassengerList = new ArrayList<>();
    //  ArrayList<PassengerRecyclerModel> data = new ArrayList<>();


    @Override
    protected int getResourceId() {
        return R.layout.pnr_status;
    }

    @BindView(R.id.enter_pnr)
    EditText pnrText;

    @BindView(R.id.search_pnr_status)
    ImageView submitPnr;

    @BindView(R.id.pnr_status_card_layout)
    CardView pnrStatusCardLayout;


    @BindView(R.id.train_name)
    TextView trainName;

    @BindView(R.id.fromStation)
    LightTextView fromStation;

    @BindView(R.id.toStation)
    TextView toStation;

    @BindView(R.id.passenger_list_recycler)
    RecyclerView passengerListRecycler;

    @BindView(R.id.chartStatus)
    LightTextView mChartStatus;

    @BindView(R.id.dateTravel)
    LightTextView mDateTravel;

    @OnClick(R.id.search_pnr_status)
    public void getPnrStatus() {
        if (Validations.checkPNR(pnrText.getText().toString())) {
            PnrApiClient apiClient = new PnrApiClient(this);
            apiClient.getPnrStatus(pnrText.getText().toString());
        } else
            Snackbar.make(getView(), "Enter Valid PNR", 2);
    }

    public static Fragment newInstance() {
        return new PnrEnquiryFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

    }


    public ArrayList<PassengerRecyclerModel> getdata1() {
        ArrayList<PassengerRecyclerModel> data1 = new ArrayList<>();

        for (int i = 0; i < mPassengerList.size(); i++) {
            data1.add(new PassengerRecyclerModel(mPassengerList.get(i).getPassengerNo(), mPassengerList.get(i).getBookingStatus()
                    , mPassengerList.get(i).getCurrentStatus()));
        }
        return data1;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pnrStatusCardLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onRespobnse(BaseModel pnrBaseModel) {
        if (pnrBaseModel.getPnr() != null) {
//        Log.i("PNR", pnrBaseModel.getFromStation().getStationCode());
            mBaseModel = pnrBaseModel;
            pnrStatusCardLayout.setVisibility(View.VISIBLE);
            fromStation.setText(mBaseModel.getFromStation().getStationCode());
            // Toast.makeText(getContext(),mBaseModel.getToStation().getStationName(),Toast.LENGTH_LONG).show();
            toStation.setText(mBaseModel.getToStation().getStationCode());
            mDateTravel.setText(mBaseModel.getDateOfTravel());
            trainName.setText(mBaseModel.getTrainNumber().getTrainName());
            if (mBaseModel.getChartPrepared() == true) {
                mChartStatus.setText("Chart Prepared");
            } else {
                mChartStatus.setText("Chart not Prepared");
            }
            for (int i = 0; i < mBaseModel.getPassengersDetails().length; i++) {
                mPassengerList.add(mBaseModel.getPassengersDetails()[i]);
            }
            madapter = new PassengerAdapter(getContext(), getdata1());
            passengerListRecycler.setAdapter(madapter);
            passengerListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        } else
            Toast.makeText(getContext(), "Api Not Working", Toast.LENGTH_SHORT).show();
    }
}
