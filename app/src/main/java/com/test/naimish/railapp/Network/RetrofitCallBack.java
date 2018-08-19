package com.test.naimish.railapp.Network;

import com.test.naimish.railapp.Utils.ResponseListener;

import retrofit2.Call;
import retrofit2.Response;

public class RetrofitCallBack<T> implements retrofit2.Callback<T> {

    private ResponseListener<T> responseListener;

    public RetrofitCallBack(ResponseListener<T> responseListener) {
        this.responseListener = responseListener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.body() != null) {
            responseListener.onSuccess(response.body());
        } else {
            responseListener.onNullResponse();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        responseListener.onFailure(t);
    }
}

