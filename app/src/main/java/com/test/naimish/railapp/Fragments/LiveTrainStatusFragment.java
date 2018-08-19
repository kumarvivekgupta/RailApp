package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdView;
import com.google.gson.Gson;
import com.test.naimish.railapp.Models.StationStatusDisplayModel;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.AddService;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Views.LightTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 4/3/2018.
 */

public class LiveTrainStatusFragment extends RailAppFragment {

    @BindView(R.id.starting_point_code)
    LightTextView startingPointCode;

    @BindView(R.id.end_point_code)
    LightTextView endPointCode;

    @BindView(R.id.starting_point_name)
    LightTextView startingPointName;

    @BindView(R.id.end_point_name)
    LightTextView endPointName;

    @BindView(R.id.train_running_date)
    LightTextView trainRunningDate;

    @BindView(R.id.train_sch_arrival)
    LightTextView trainSchArrival;

    @BindView(R.id.train_actual_arrival)
    LightTextView trainActualArrival;

    @BindView(R.id.train_delay_on_arr)
    LightTextView trainArrivalDelay;

    @BindView(R.id.train_sch_dep)
    LightTextView trainSchDep;

    @BindView(R.id.train_ach_dep)
    LightTextView trainAchDep;

    @BindView(R.id.train_delay_dep)
    LightTextView trainDepDelay;

    @BindView(R.id.station_name)
    LightTextView stationName;

    @BindView(R.id.sourceCondition)
    LightTextView sourceCondition;

    @BindView(R.id.adView)
    AdView adView;


    @Override
    protected int getResourceId() {
        return R.layout.fragment_live_train_status;
    }

    public static Fragment newInstance() {
        return new LiveTrainStatusFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adView.loadAd(AddService.getAdRequest(getActivity()));
        String response = getActivity().getIntent().getExtras().getString(RailAppConstants.SINGLE_STATION_DETAILS);
        Gson gson = new Gson();
        StationStatusDisplayModel displayModel = gson.fromJson(response, StationStatusDisplayModel.class);
        stationName.setText(displayModel.getStationName());
        startingPointCode.setText(displayModel.getFromStationCode());
        startingPointName.setText(displayModel.getFromStation());
        endPointName.setText(displayModel.getToStation());
        endPointCode.setText(displayModel.getToStationCode());
        trainRunningDate.setText(displayModel.getDate());
        trainAchDep.setText(displayModel.getActualDeparture());
        trainActualArrival.setText(displayModel.getActualArrival());
        trainSchDep.setText(displayModel.getScheduledDepartire());
        trainSchArrival.setText(displayModel.getScheduledArival());
        sourceCondition.setText(displayModel.getCurrentStatus());
        trainArrivalDelay.setText(displayModel.getLate());
        trainDepDelay.setText(displayModel.getLate());
    }
}
