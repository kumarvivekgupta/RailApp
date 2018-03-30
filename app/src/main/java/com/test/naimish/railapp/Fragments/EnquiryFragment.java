package com.test.naimish.railapp.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.test.naimish.railapp.Activities.EnquiryActivity;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.VivzAdapter;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Vivek on 2/17/2018.
 */

public class EnquiryFragment extends RailAppFragment implements VivzAdapter.Clicklistener {

    private VivzAdapter adapter;

    @BindView(R.id.recyclerList)
    RecyclerView recycler;


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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


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

    @OnClick(R.id.user_pic)
    public void userImage() {

        
    }


}
