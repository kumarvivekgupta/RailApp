package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.test.naimish.railapp.Models.PnrModel.BaseModel;
import com.test.naimish.railapp.Models.PnrModel.PassengerModel;
import com.test.naimish.railapp.Network.PnrNetwork.PnrApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.EnquiryAdapter;
import com.test.naimish.railapp.Utils.Validations;
import com.test.naimish.railapp.Views.LightTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Vivek on 2/19/2018.
 */

public class PnrEnquiryFragment extends RailAppFragment  {
    private BaseModel mBaseModel;
    private EnquiryAdapter madapter;
    private ArrayList<PassengerModel> mPassengerList;
    private ArrayList<String> data = new ArrayList<>();
    private PnrApiClient apiClient;

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
    LightTextView trainName;

    @BindView(R.id.fromStation)
    LightTextView fromStation;

    @BindView(R.id.toStation)
    LightTextView toStation;

    @BindView(R.id.passenger_list_recycler)
    RecyclerView passengerListRecycler;

    @OnClick(R.id.search_pnr_status)
    public void getPnrStatus() {
        if(Validations.checkPNR(pnrText.getText().toString()))
        apiClient.getPnrStatus(pnrText.getText().toString());
        else
            Snackbar.make(getView(),"Enter Valid PNR",2);
    }

    public static Fragment newInstance() {
        return new PnrEnquiryFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    public void pnrDisplay(BaseModel pnrBaseModel) {

//
//        EnquiryAdapter.getLayoutResourseId(R.layout.pnr_single_row_passenger);
//
//        pnrStatusCardLayout.setVisibility(View.VISIBLE);
//        fromStation.setText(pnrBaseModel.getFromStation().getStationName());
//        toStation.setText(pnrBaseModel.getToStation().getStationName());
//        trainName.setText(pnrBaseModel.getTrainNumber().getTrainName());
//        for (int i = 0; i < mBaseModel.getPassengersDetails().length; i++) {
//            mPassengerList.add(mBaseModel.getPassengersDetails()[i]);
//        }
//        madapter = new EnquiryAdapter(getContext(), getdata1());
//        passengerListRecycler.setAdapter(madapter);
//        passengerListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    public ArrayList<String> getdata1() {
        ArrayList<String> data1 = new ArrayList<>();

        for (int i = 0; i < mPassengerList.size(); i++) {
            data1.add(mPassengerList.get(i).getBookingStatus() + mPassengerList.get(i).getCurrentStatus());
        }
        return data1;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pnrStatusCardLayout.setVisibility(View.VISIBLE);
        apiClient=new PnrApiClient(getContext());

    }
}
