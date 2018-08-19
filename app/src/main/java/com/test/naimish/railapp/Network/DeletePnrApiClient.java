package com.test.naimish.railapp.Network;

import com.test.naimish.railapp.Models.UserPnrs.DeletePnrs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeletePnrApiClient {

    private DeleteResponse responseListener;

    public DeletePnrApiClient(DeleteResponse responseListener) {
        this.responseListener = responseListener;
    }

    public void deleteUserPnr(String userId) {
        ApiLayer.getInterface().deleteSavedPnrs(userId)
                .enqueue(new Callback<DeletePnrs>() {
                    @Override
                    public void onResponse(Call<DeletePnrs> call, Response<DeletePnrs> response) {
                        if (response.body() != null) {
                            responseListener.success(response.body());
                        } else {
                            responseListener.failure();
                        }
                    }

                    @Override
                    public void onFailure(Call<DeletePnrs> call, Throwable t) {
                        responseListener.failure();
                    }
                });

    }

    public interface DeleteResponse {
        void success(DeletePnrs deletePnrs);

        void failure();
    }

}
