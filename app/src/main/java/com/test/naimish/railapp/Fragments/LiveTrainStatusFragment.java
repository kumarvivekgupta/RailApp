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
    private ArrayList<TrainRouteModel> mTrainRouteModel;
    private LiveStatusBaseModel trainRouteModel;


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

    @BindView(R.id.train_name)
    TextView trainName;

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


    }



}
