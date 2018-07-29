package com.test.naimish.railapp.Fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.test.naimish.railapp.Activities.LiveTrainSearchActivity;
import com.test.naimish.railapp.Activities.PnrEnquiryActivity;
import com.test.naimish.railapp.Activities.SeatAvalibilityEnquiryActivity;
import com.test.naimish.railapp.Models.RecyclerModel;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.AddService;
import com.test.naimish.railapp.Utils.SharedPreference;
import com.test.naimish.railapp.Views.Adapters.EnquiryAdapter;
import com.test.naimish.railapp.Views.LightTextView;

import java.util.ArrayList;


import agency.tango.android.avatarview.IImageLoader;
import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.test.naimish.railapp.Utils.RailAppConstants.EMAIL_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.NAME_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.PERMISSION_REQUEST_CODE;
import static com.test.naimish.railapp.Utils.RailAppConstants.PROFILE_PIC_CONSTANT;
import static com.test.naimish.railapp.Utils.RailAppConstants.SOME_RANDOM_STRING;


/**
 * Created by Vivek on 2/17/2018.
 */

public class EnquiryFragment extends RailAppFragment implements EnquiryAdapter.Clicklistener {

    private EnquiryAdapter mAdapter;
    private IImageLoader mLoader;
    private String mProfileUrl;

    @BindView(R.id.user_pic)
    AvatarView userPic;

    @BindView(R.id.recyclerList)
    RecyclerView recycler;

    @BindView(R.id.user_name)
    LightTextView mUserName;

    @BindView(R.id.user_email)
    LightTextView mUserEmail;

    @BindView(R.id.adView)
    AdView adView;

    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;


    public static Fragment newInstance() {
        return new EnquiryFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Toast.makeText(getContext(), "Refreshing", Toast.LENGTH_LONG).show();
                        myUpdateOperation();
                    }
                }
        );
    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_enquiry;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        checkPermission();
        EnquiryAdapter.getLayoutResourseId(R.layout.recycler_single_row);
        mAdapter = new EnquiryAdapter(getContext(), getdata());
        mAdapter.setClicklistener(this);
        recycler.setAdapter(mAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mUserName.setText(SharedPreference.getPreference(getContext(), NAME_CONSTANT));
        mUserEmail.setText(SharedPreference.getPreference(getContext(), EMAIL_CONSTANT));
        mProfileUrl = SharedPreference.getPreference(getContext(), PROFILE_PIC_CONSTANT);
        adView.loadAd(AddService.getAdRequest(getActivity()));
        mLoader = new PicassoLoader();
        if (mProfileUrl.equals("")) {
            mProfileUrl = SOME_RANDOM_STRING;
        } // since profile url cannot be empty

        mLoader.loadImage(userPic, mProfileUrl, SharedPreference.getPreference(getContext(), NAME_CONSTANT));


    }

    private ArrayList<RecyclerModel> getdata() {
        ArrayList<RecyclerModel> data = new ArrayList<>();
        data.add(new RecyclerModel("Check PNR Status", R.drawable.pnr_icon));
        data.add(new RecyclerModel("Check Live Train Status", R.drawable.live_status_icon));
        data.add(new RecyclerModel("Seat Avalibility", R.drawable.facebook_icon));
        return data;
    }

    @Override
    public void itemclicked(int position) {
        if (position == 0) {
            Intent intent = new Intent(getActivity(), PnrEnquiryActivity.class);
            startActivity(intent);
        } else if (position == 1) {
            Intent intent = new Intent(getActivity(), LiveTrainSearchActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(getActivity(), SeatAvalibilityEnquiryActivity.class);
            startActivity(intent);
        }

    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);
            } else {

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED)
                ;
        }

    }

    public void myUpdateOperation() {
        mSwipeRefreshLayout.setRefreshing(false);
        mUserName.setText(SharedPreference.getPreference(getContext(), NAME_CONSTANT));
        mProfileUrl = SharedPreference.getPreference(getContext(), PROFILE_PIC_CONSTANT);
        if (mProfileUrl.equals("")) {
            mProfileUrl = SOME_RANDOM_STRING;
        } // since profile url cannot be empty
        mLoader.loadImage(userPic, mProfileUrl, SharedPreference.getPreference(getContext(), NAME_CONSTANT));
    }
}
