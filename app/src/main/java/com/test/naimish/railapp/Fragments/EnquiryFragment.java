package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.test.naimish.railapp.Activities.LiveTrainStatusActivity;
import com.test.naimish.railapp.Activities.PnrEnquiryActivity;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.VivzAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.media.CamcorderProfile.get;

/**
 * Created by Vivek on 2/17/2018.
 */

public class EnquiryFragment extends RailAppFragment implements VivzAdapter.Clicklistener {

    private VivzAdapter adapter;

    public static Fragment newInstance() {
        return new EnquiryFragment();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_enquiry;
    }

//    @OnClick(R.id.pnr_enquiry)
//    public void pnrEnquiry() {
//        startActivity(new Intent(getActivity(), PnrEnquiryActivity.class));
//    }
//
//    @OnClick(R.id.live_train_status)
//    public void lineTrainStatus() {
//        startActivity(new Intent(getActivity(), LiveTrainStatusActivity.class));


    //    @Override
//    public void itemclicked(int position) {
//
//    }
    @BindView(R.id.recyclerList)
    private RecyclerView recycler;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new VivzAdapter(getContext(), getdata());
        adapter.setClicklistener(this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public static ArrayList<String> getdata() {
        ArrayList<String> data = new ArrayList<>();


        data.add(0, "Pnr Enquiry");
        data.add(1, "Live Train Status");


        return data;
    }

    @Override
    public void itemclicked(int position) {

        //  intent.putExtra("key", position);

    }
}
