package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.test.naimish.railapp.Models.LiveTrainStatusModel.BaseModel;
import com.test.naimish.railapp.Network.LiveTrainNetwork.LiveTrainApiClient;
import com.test.naimish.railapp.R;

import butterknife.ButterKnife;

/**
 * Created by Vivek on 4/3/2018.
 */

public class LiveTrainStatusFragment extends RailAppFragment  {

    @Override
    protected int getResourceId() {
        return R.layout.live_train_status;
    }
    public static Fragment newInstance(){
        return new LiveTrainStatusFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }
    public  static  void livetrain(BaseModel baseModel){
        Log.i("Response",baseModel.getPosition());

    }


}
