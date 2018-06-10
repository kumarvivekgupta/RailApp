package com.test.naimish.railapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.test.naimish.railapp.Activities.PnrEnquiryActivity;
import com.test.naimish.railapp.Models.UserPnrs.DeletePnrs;
import com.test.naimish.railapp.Models.UserPnrs.GetPnrs;
import com.test.naimish.railapp.Models.UserPnrs.SavedPnrs;
import com.test.naimish.railapp.Network.UserPnrsNetwork.DeletePnrNetwork.DeletePnrApiClient;
import com.test.naimish.railapp.Network.UserPnrsNetwork.GetPnrNetwork.GetPnrApiClient;
import com.test.naimish.railapp.Network.UserPnrsNetwork.SavePnrNetwork.SavedPnrApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Views.Adapters.SavedPnrHistoryAdapter;
import com.test.naimish.railapp.Utils.SharedPreference;
import com.test.naimish.railapp.Views.ProgressLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PnrHistoryFragment extends
        RailAppFragment implements
        ResponseListener<GetPnrs>,
        SwipeRefreshLayout.OnRefreshListener,
        SavedPnrHistoryAdapter.SavePnrResponse,
        DeletePnrApiClient.DeleteResponse {

    private int mCounter = 0;
    private ProgressLoader mProgressLoader;
    private GetPnrApiClient mApiClient;

    @BindView(R.id.saved_pnrs_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.saved_pnrs_refresh)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.no_saved_pnr)
    TextView noPnrMessage;

    @Override
    protected int getResourceId() {
        return R.layout.fragment_saved_pnrs;
    }

    public static PnrHistoryFragment newInstance() {
        return new PnrHistoryFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mProgressLoader = new ProgressLoader(getContext());
        mApiClient = new GetPnrApiClient(this);
        getUserPnr();
        refreshLayout.setOnRefreshListener(this);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    private void getUserPnr() {
        mProgressLoader.showLoader();
        String userId = SharedPreference.getPreference(getContext(), RailAppConstants.USERID_CONSTANT);
        mApiClient.getUserPnr(userId);
    }

    public void deletePnrs() {
        DeletePnrApiClient apiClient = new DeletePnrApiClient(this);
        apiClient.deleteUserPnr("5b0714bee3a8fe0014593b08");
    }

    @Override
    public void onSuccess(GetPnrs response) {
        mProgressLoader.dismissLoader();
        if (response.getStatus()) {
            if (response.getSavedPnrs().length > 0) {
                SavedPnrHistoryAdapter adapter = new SavedPnrHistoryAdapter(getActivity(), response.getSavedPnrs());
                adapter.setInstance(this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                if (mCounter == 0) {
                    Snackbar.make(getView(), R.string.saved_pnrs_message, Snackbar.LENGTH_SHORT).show();
                    mCounter++;
                }
            } else {
                noPnrMessage.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    public void onFailure(Throwable throwable) {
        mProgressLoader.dismissLoader();
        Snackbar.make(getView(), R.string.common_error, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void onNullResponse() {
        mProgressLoader.dismissLoader();
        Snackbar.make(getView(), R.string.common_error, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void onRefresh() {
        getUserPnr();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showStatus(String pnr) {
        Intent intent = new Intent(getActivity(), PnrEnquiryActivity.class);
        intent.putExtra(RailAppConstants.PNR_NO, pnr);
        startActivity(intent);
    }

    @Override
    public void success(DeletePnrs deletePnrs) {
        if (deletePnrs.getSuccess()) {
            getUserPnr();
        } else {
            Snackbar.make(getView(), getString(R.string.common_error), Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void failure() {
        Snackbar.make(getView(), getString(R.string.common_error), Snackbar.LENGTH_SHORT).show();
    }
}