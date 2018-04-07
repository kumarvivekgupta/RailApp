package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.test.naimish.railapp.Models.LiveTrainStatusModel.LiveStatusBaseModel;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.TrainRouteModel;
import com.test.naimish.railapp.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;

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

    @BindView(R.id.train_sch_dep)
    TextView trainSchDep;

    @BindView(R.id.train_ach_dep)
    TextView trainAchDep;

    @BindView(R.id.train_delay_dep)
    TextView trainDepDelay;

    @BindView(R.id.lastUpdated)
    TextView lastUpdated;

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

        getLiveStatus();


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public void getLiveStatus() {
        trainSchArrival.setText(getActivity().getIntent().getStringExtra("SchArr"));
        trainActualArrival.setText(getActivity().getIntent().getStringExtra("ActArr"));
        trainDelayOnArrival.setText(getActivity().getIntent().getStringExtra("ArrDelay"));
        trainSchDep.setText(getActivity().getIntent().getStringExtra("SchDep"));
        trainAchDep.setText(getActivity().getIntent().getStringExtra("ActDep"));
        trainDepDelay.setText(getActivity().getIntent().getStringExtra("ArrDelay"));
        trainRunningDate.setText(getActivity().getIntent().getStringExtra("TrainDate"));
        startingPointCode.setText(getActivity().getIntent().getStringExtra("TrainStartStationCode"));
        endPointCode.setText(getActivity().getIntent().getStringExtra("TrainEndStationCode"));
        sourceCondition.setText(getActivity().getIntent().getStringExtra("Position"));
        startingPointName.setText(getActivity().getIntent().getStringExtra("TrainStartStationName"));
        endPointName.setText(getActivity().getIntent().getStringExtra("TrainEndStationName"));
        Toast.makeText(getActivity(), getActivity().getIntent().getStringExtra("Position"), Toast.LENGTH_LONG).show();

    }


}
