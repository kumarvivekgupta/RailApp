package com.test.naimish.railapp.Network;

import com.test.naimish.railapp.Models.UserPnrs.SavedPnrs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SavedPnrApiClient {
    private SavePnrResponse pnrResponse;

    public SavedPnrApiClient(SavePnrResponse pnrResponse) {
        this.pnrResponse = pnrResponse;
    }

    public void savePnr(String userId, String pnrNo) {
        ApiLayer.getInterface().saveUserPnr(new SavedPnrs(userId, pnrNo)).enqueue(new Callback<SavedPnrs>() {
            @Override
            public void onResponse(Call<SavedPnrs> call, Response<SavedPnrs> response) {
                if (response.body() != null) {
                    pnrResponse.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<SavedPnrs> call, Throwable t) {
                pnrResponse.onFailure();
            }
        });

    }

    public interface SavePnrResponse {
        void onSuccess(SavedPnrs savedPnrs);

        void onFailure();
    }
}
