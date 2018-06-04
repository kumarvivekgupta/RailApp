package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.ProgressBar;
import android.widget.TextView;

import com.test.naimish.railapp.Models.PassengerRecyclerModel;
import com.test.naimish.railapp.Models.PnrModel.BaseModel;
import com.test.naimish.railapp.Models.UserPnrs.SavedPnrs;
import com.test.naimish.railapp.Network.PnrNetwork.PnrApiClient;
import com.test.naimish.railapp.Network.UserPnrsNetwork.SavePnrNetwork.SavedPnrApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.PassengerAdapter;
import com.test.naimish.railapp.Utils.PassengerDetails;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Utils.SharedPreference;
import com.test.naimish.railapp.Utils.Validations;
import com.test.naimish.railapp.Views.LightTextView;
import com.test.naimish.railapp.Views.ProgressLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okio.Timeout;


/**
 * Created by Vivek on 2/19/2018.
 */

public class PnrEnquiryFragment extends RailAppFragment implements ResponseListener<BaseModel>,SavedPnrApiClient.SavePnrResponse {
    private BaseModel mBaseModel;
    private ProgressLoader loader;
    private PassengerAdapter madapter;


    @Override
    protected int getResourceId() {
        return R.layout.fragment_pnr_status;
    }

    @BindView(R.id.save_pnr_message)
    TextView savePnr;

    @BindView(R.id.pnr_progress_bar)
    ProgressBar progressBar;

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
            loader.showLoader();
            PnrApiClient apiClient = new PnrApiClient(this);
            apiClient.getPnrStatus(pnrText.getText().toString());
        } else
            Snackbar.make(getView(), R.string.invalid_pnr, Snackbar.LENGTH_SHORT).show();
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
        return PassengerDetails.getPassengerDetails(mBaseModel);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pnrStatusCardLayout.setVisibility(View.INVISIBLE);
        loader = new ProgressLoader(getActivity());
    }

    @Override
    public void onSuccess(BaseModel response) {
        loader.dismissLoader();
        if (response.getPnr() != null) {
            mBaseModel = response;
            pnrStatusCardLayout.setVisibility(View.VISIBLE);
            fromStation.setText(mBaseModel.getFromStation().getStationCode());
            toStation.setText(mBaseModel.getToStation().getStationCode());
            mDateTravel.setText(mBaseModel.getDateOfTravel());
            trainName.setText(mBaseModel.getTrainNumber().getTrainName());
            if (mBaseModel.getChartPrepared() == true) {
                mChartStatus.setText(R.string.chart_prepared);
            } else {
                mChartStatus.setText(R.string.chart_not_prepared);
            }
            madapter = new PassengerAdapter(getContext(), getdata1());
            passengerListRecycler.setAdapter(madapter);
            passengerListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
            savePnr.setVisibility(View.VISIBLE);
        } else
            Snackbar.make(getView(), R.string.common_error, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void onFailure(Throwable throwable) {
        loader.dismissLoader();
        Snackbar.make(getView(), throwable.getMessage().toString() + " " + R.string.try_again, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onNullResponse() {
        loader.dismissLoader();
        Snackbar.make(getView(), R.string.common_error, Snackbar.LENGTH_SHORT).show();
    }

    @OnClick(R.id.save_pnr_message)
    public void savePnr(){
        savePnr.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        String userId= SharedPreference.getPreference(getContext(), RailAppConstants.USERID_CONSTANT);
        SavedPnrApiClient apiClient=new SavedPnrApiClient(this);
        apiClient.savePnr(userId,pnrText.getText().toString());
    }

    @Override
    public void onSuccess(SavedPnrs savedPnrs) {
        if(savedPnrs.getResponseStatus()){
            progressBar.setVisibility(View.GONE);
            savePnr.setText(R.string.success_pnr_saved);
            savePnr.setClickable(false);
        }
    }

    @Override
    public void onFailure() {
        progressBar.setVisibility(View.GONE);
        savePnr.setText(R.string.try_again);
    }
}
