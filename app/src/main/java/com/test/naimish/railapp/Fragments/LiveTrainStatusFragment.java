package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.test.naimish.railapp.Models.StationStatusDisplayModel;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.RailAppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 4/3/2018.
 */

public class LiveTrainStatusFragment extends RailAppFragment {

    @BindView(R.id.starting_point_code)
    TextView startingPointCode;

    @BindView(R.id.end_point_code)
    TextView endPointCode;

    @BindView(R.id.starting_point_name)
    TextView startingPointName;

    @BindView(R.id.end_point_name)
    TextView endPointName;

    @BindView(R.id.train_running_date)
    TextView trainRunningDate;

    @BindView(R.id.train_sch_arrival)
    TextView trainSchArrival;

    @BindView(R.id.train_actual_arrival)
    TextView trainActualArrival;

    @BindView(R.id.train_delay_on_arr)
    TextView trainArrivalDelay;

    @BindView(R.id.train_sch_dep)
    TextView trainSchDep;

    @BindView(R.id.train_ach_dep)
    TextView trainAchDep;

    @BindView(R.id.train_delay_dep)
    TextView trainDepDelay;

    @BindView(R.id.station_name)
    TextView stationName;

    @BindView(R.id.sourceCondition)
    TextView sourceCondition;


    @Override
    protected int getResourceId() {
        return R.layout.live_train_status;
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
        String response = getActivity().getIntent().getExtras().getString(RailAppConstants.SINGLE_STATION_DETAILS);
        Gson gson = new Gson();
        StationStatusDisplayModel displayModel = gson.fromJson(response, StationStatusDisplayModel.class);
        Log.i("Current status", displayModel.getCurrentStatus());
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
