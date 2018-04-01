package com.test.naimish.railapp.Fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Utils.SharedPreference;
import com.test.naimish.railapp.Utils.VivzAdapter;
import com.test.naimish.railapp.Views.LightTextView;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Vivek on 2/17/2018.
 */

public class EnquiryFragment extends RailAppFragment implements VivzAdapter.Clicklistener {

    private VivzAdapter adapter;

    @BindView(R.id.user_pic)
    CircleImageView userPic;

    @BindView(R.id.recyclerList)
    RecyclerView recycler;

    @BindView(R.id.user_name)
    LightTextView mUserName;

    @BindView(R.id.user_email)
    LightTextView mUserEmail;


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
        checkPermission();
        adapter = new VivzAdapter(getContext(), getdata());
        adapter.setClicklistener(this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mUserName.setText(SharedPreference.getPreference(getContext(),RailAppConstants.NAME_CONSTANT));
        mUserEmail.setText(SharedPreference.getPreference(getContext(),RailAppConstants.EMAIL_CONSTANT));

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
        FragmentManager manager = getActivity().getSupportFragmentManager();
        CameraDialogFragment cameraDialogFragment = CameraDialogFragment.newInsatance();
        cameraDialogFragment.show(manager, "Camera Dialog");


    }


    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, RailAppConstants.PERMISSION_REQUEST_CODE);
            } else {

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RailAppConstants.PERMISSION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED)
                ;

        }
    }

}
