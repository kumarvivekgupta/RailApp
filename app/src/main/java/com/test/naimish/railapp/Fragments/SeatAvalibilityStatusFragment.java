package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.test.naimish.railapp.Models.DateSeatModel;
import com.test.naimish.railapp.Models.SeatStatusDisplayModel;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Views.Adapters.SeatAdapter;
import com.test.naimish.railapp.Views.LightTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 6/4/2018.
 */

public class SeatAvalibilityStatusFragment extends RailAppFragment {
    private SeatAdapter adapter;
    private String response;
    private ArrayList<String> seatStatus;

    @BindView(R.id.train_name)
    LightTextView trainName;

    @BindView(R.id.train_journey_class)
    LightTextView trainJourneyClass;

    @BindView(R.id.train_quota)
    LightTextView trainQuota;

    @BindView(R.id.recycler_list_seat_avalibility)
    RecyclerView recyclerListSeatAvalibility;

    @BindView(R.id.starting_point_code)
    LightTextView startingPointCode;

    @BindView(R.id.end_point_code)
    LightTextView endPointCode;

    @BindView(R.id.starting_point_name)
    LightTextView startingPointName;

    @BindView(R.id.end_point_name)
    LightTextView endPointName;


    @Override
    protected int getResourceId() {
        return R.layout.fragment_train_seat_display;
    }

    public static Fragment newInstance() {

        return new SeatAvalibilityStatusFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // seatStatus=new ArrayList<>();
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        response = getActivity().getIntent().getExtras().getString("SeatInfo");
        seatStatus = getActivity().getIntent().getExtras().getStringArrayList("SeatStatus");
        Gson gson = new Gson();
        SeatStatusDisplayModel seatStatusDisplayModel = gson.fromJson(response, SeatStatusDisplayModel.class);

        trainName.setText(seatStatusDisplayModel.getTrainName());
        trainJourneyClass.setText(seatStatusDisplayModel.getTrainJourneyClass());
        trainQuota.setText(seatStatusDisplayModel.getTrainQuota());
        startingPointCode.setText(seatStatusDisplayModel.getFromStationCode());
        endPointCode.setText(seatStatusDisplayModel.getToStationCode());
        startingPointName.setText(seatStatusDisplayModel.getSourceStationName());
        endPointName.setText(seatStatusDisplayModel.getDestinationStationName());
        adapter = new SeatAdapter(getContext(), getdata1());
        recyclerListSeatAvalibility.setAdapter(adapter);
        recyclerListSeatAvalibility.setLayoutManager(layoutManager);


    }

    public ArrayList<DateSeatModel> getdata1() {
        //    Gson gson=new Gson();
//        DateSeatModel seatAvailabiityModelClass=new DateSeatModel();
        //=new ArrayList<>();
        ArrayList<DateSeatModel> dateSeatModel = new ArrayList<>();

        //  seatAvailabiityModelClass =gson.fromJson(seatStatus,DateSeatModel.class);
        for (int i = 0; i < seatStatus.size(); i++)
            //     dateSeatModel.add(new DateSeatModel(seatStatus.get(i).substring(0,seatStatus.get(i).indexOf('-')),seatStatus.get(i).substring(seatStatus.get(i).indexOf(('-')+1),seatStatus.get(i).length())));
            dateSeatModel.add(new DateSeatModel(seatStatus.get(i).substring(0, seatStatus.get(i).indexOf("--")), seatStatus.get(i).substring(seatStatus.get(i).indexOf(("--")+1),seatStatus.get(i).length())));
        return dateSeatModel;

    }
}
