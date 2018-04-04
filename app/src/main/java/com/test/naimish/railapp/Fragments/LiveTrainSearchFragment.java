package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.test.naimish.railapp.Activities.LiveTrainSearchActivity;
import com.test.naimish.railapp.Activities.LiveTrainStatusActivity;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.LiveStatusBaseModel;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.TrainRouteModel;
import com.test.naimish.railapp.Network.LiveTrainNetwork.LiveTrainApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.EnquiryAdapter;
import com.test.naimish.railapp.Utils.Validations;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.test.naimish.railapp.Fragments.EnquiryFragment.getdata;

/**
 * Created by Vivek on 4/4/2018.
 */

public class LiveTrainSearchFragment extends RailAppFragment implements EnquiryAdapter.Clicklistener {
    private EnquiryAdapter adapter;
    private String trainNo;
   private static LiveStatusBaseModel liveTrainRoute;



    @BindView(R.id.enter_train)
    EditText enterTrain;

    @BindView(R.id.search_live_train)
    ImageView searchLiveTrain;

    @BindView(R.id.stations_recycler_view)
    RecyclerView stationsRecyclerView;

    @Override
    protected int getResourceId() {
        return R.layout.live_train_search;
    }

    public static Fragment newInstance() {
        return new LiveTrainSearchFragment();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new EnquiryAdapter(getContext(), getdata());
        adapter.setClicklistener(this);
        stationsRecyclerView.setAdapter(adapter);
        stationsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void itemclicked(int position) {
        Intent intent = new Intent(getActivity(), LiveTrainStatusActivity.class);
      //  startActivity(intent);
        intent.putExtra("Station",position);


    }

    public static ArrayList<String> getdata() {


        ArrayList<String> data = new ArrayList<>();
         ArrayList<TrainRouteModel> trainRouteModel = new ArrayList<>();
        for (int i = 0; i < liveTrainRoute.getRoute().length; i++) {
            trainRouteModel.add(liveTrainRoute.getRoute()[0]);
        }

        for (int i = 0; i < liveTrainRoute.getRoute().length; i++) {
            data.add(trainRouteModel.get(i).getStation().getStationName());
        }
        return data;
    }

    @OnClick(R.id.search_live_train)
    public void searchLiveTrainStationsList() {
        trainNo = enterTrain.getText().toString();
        if (Validations.checkTrainNo(trainNo)) {
            LiveTrainApiClient.liveTrainStatus(trainNo, "04-04-2018");
            EventBus.getDefault().register(this);

        }
        else
            Snackbar.make(getView(), "Train No Incorrect", Snackbar.LENGTH_SHORT).show();
    }
    public static   void trainLiveModel(LiveStatusBaseModel trainRouteModel){
        liveTrainRoute=trainRouteModel;
       
    }
}
