package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.test.naimish.railapp.R;

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
    TextView trainDelayOnArrival;


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

    public void livetrain() {


    }


}
