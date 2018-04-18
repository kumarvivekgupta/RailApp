package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.test.naimish.railapp.Activities.LiveTrainSearchActivity;
import com.test.naimish.railapp.Activities.LiveTrainStatusActivity;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.LiveStatusBaseModel;
import com.test.naimish.railapp.Models.LiveTrainStatusModel.TrainRouteModel;
import com.test.naimish.railapp.Network.LiveTrainNetwork.LiveTrainApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.EnquiryAdapter;
import com.test.naimish.railapp.Utils.Validations;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.test.naimish.railapp.Fragments.EnquiryFragment.getdata;

/**
 * Created by Vivek on 4/4/2018.
 */

public class LiveTrainSearchFragment extends RailAppFragment implements EnquiryAdapter.Clicklistener, AdapterView.OnItemSelectedListener {
    private EnquiryAdapter madapter;
    private String mtrainNo;
    public LiveStatusBaseModel mliveTrainRoute;
    private List<String> categories;
    private String mdateTrain;
    private ArrayList<TrainRouteModel> mtrainRouteModel;


    @BindView(R.id.enter_train)
    EditText enterTrain;

    @BindView(R.id.search_live_train)
    ImageView searchLiveTrain;

    @BindView(R.id.stations_recycler_view)
    RecyclerView stationsRecyclerView;

    @BindView(R.id.date_spinner)
    Spinner dateSpinner;


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
        dateSpinner.setOnItemSelectedListener(this);
        createSpinnerDropdown();
    }

    private void createSpinnerDropdown() {

        categories = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        categories.add(dateFormat.format(cal.getTime()).toString()); //your formatted date here


        cal.add(Calendar.DATE, 1);
        categories.add(dateFormat.format(cal.getTime()).toString());
        cal.add(Calendar.DATE, 1);
        categories.add(dateFormat.format(cal.getTime()).toString());

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateSpinner.setAdapter(dataAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    public void itemclicked(int position) {
        Intent intent = new Intent(getActivity(), LiveTrainStatusActivity.class);


//      Map<String,String>  stationInfo = new HashMap<String, String>();
//        stationInfo.put("SchArr", mtrainRouteModel.get(position).getSchduleArrival());
//        stationInfo.put("ActArr", mtrainRouteModel.get(position).getAccArr());
//        stationInfo.put("ArrDelay",mtrainRouteModel.get(position).getLateMin());
//        stationInfo.put("SchDep", mtrainRouteModel.get(position).getSchdep());
//        stationInfo.put("ActDep", mtrainRouteModel.get(position).getActDep());
//        stationInfo.put("DepDelay",mtrainRouteModel.get(position).getLateMin());
//        Map<String,String> trainInfo=new HashMap<>();
//        trainInfo.put("TrainStartStationCode",mtrainRouteModel.get(0).getStation().getCode());
//        trainInfo.put("TrainEndStationCode",mtrainRouteModel.get(((mliveTrainRoute.getRoute().length)-1))
//                .getStation().getCode());
//        trainInfo.put("TrainStartStationName",mtrainRouteModel.get(0).getStation().getStationName());
//        trainInfo.put("TrainEndStationCode",mtrainRouteModel.get(((mliveTrainRoute.getRoute().length)-1))
//                .getStation().getCode());
//        Map<String,String> trainPosition=new HashMap<>();
//        trainPosition.put("Date",mliveTrainRoute.getTrainStartDate());
//        trainPosition.put("Position",mliveTrainRoute.getPosition());
//        intent.putExtra("StationInfo",stationInfo+"");
        intent.putExtra("SchArr", mtrainRouteModel.get(position).getSchduleArrival());
        intent.putExtra("ActArr", mtrainRouteModel.get(position).getAccArr());
        intent.putExtra("ArrDelay", mtrainRouteModel.get(position).getLateMin());
        intent.putExtra("SchDep", mtrainRouteModel.get(position).getSchdep());
        intent.putExtra("ActDep", mtrainRouteModel.get(position).getActDep());
        intent.putExtra("SchArr", mtrainRouteModel.get(position).getSchduleArrival());
        intent.putExtra("TrainDate", mliveTrainRoute.getTrainStartDate());
        intent.putExtra("Position", mliveTrainRoute.getPosition());
        intent.putExtra("TrainStartStationCode", mtrainRouteModel.get(position).getStation().getCode());
        intent.putExtra("TrainEndStationCode", mtrainRouteModel.get(((mliveTrainRoute.getRoute().length) - 1)).getStation().getCode());
        intent.putExtra("TrainStartStationName", mtrainRouteModel.get(position).getStation().getStationName());
        intent.putExtra("TrainEndStationName", mtrainRouteModel.get(((mliveTrainRoute.getRoute().length) - 1)).getStation().getStationName());
        intent.putExtra("TrainName", mliveTrainRoute.getTrainInfo().getTrainName());

        startActivity(intent);


    }

    public ArrayList<String> getdata() {


        ArrayList<String> data = new ArrayList<>();


        mtrainRouteModel = new ArrayList<>();
        for (int i = 0; i < mliveTrainRoute.getRoute().length; i++) {
            mtrainRouteModel.add(mliveTrainRoute.getRoute()[i]);
        }

        for (int i = 0; i < mliveTrainRoute.getRoute().length; i++) {
            data.add(mtrainRouteModel.get(i).getStation().getStationName());
        }
        return data;
    }

    @OnClick(R.id.search_live_train)
    public void searchLiveTrainStationsList() {
        mtrainNo = enterTrain.getText().toString();


        if (Validations.checkTrainNo(mtrainNo)) {

            LiveTrainApiClient.liveTrainStatus(mtrainNo, mdateTrain);
        } else
            Snackbar.make(getView(), "Train No Incorrect", Snackbar.LENGTH_SHORT).show();
    }

    @Subscribe
    public void trainLiveModel(LiveStatusBaseModel trainRouteModel) {

        mliveTrainRoute = trainRouteModel;
        EnquiryAdapter.getLayoutResourseId(R.layout.recycler_single_row_live_train);
        madapter = new EnquiryAdapter(getContext(), getdata());
        madapter.setClicklistener(this);
        stationsRecyclerView.setAdapter(madapter);
        stationsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // On selecting a spinner item
        mdateTrain = adapterView.getItemAtPosition(i).toString();

        // Showing selected spinner item
        Toast.makeText(adapterView.getContext(), "Selected: " + mdateTrain, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

