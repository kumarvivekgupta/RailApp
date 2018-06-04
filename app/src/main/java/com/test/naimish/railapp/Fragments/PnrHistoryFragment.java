package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.test.naimish.railapp.Models.UserPnrs.GetPnrs;
import com.test.naimish.railapp.Network.UserPnrsNetwork.GetPnrNetwork.GetPnrApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Utils.SavedPnrHistoryAdapter;
import com.test.naimish.railapp.Utils.SharedPreference;
import com.test.naimish.railapp.Views.ProgressLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PnrHistoryFragment extends RailAppFragment implements ResponseListener<GetPnrs>,SwipeRefreshLayout.OnRefreshListener {
    private int mCounter=0;
    private ProgressLoader mProgressLoader;
    private GetPnrApiClient mApiClient;

    @BindView(R.id.saved_pnrs_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.saved_pnrs_refresh)
    SwipeRefreshLayout refreshLayout;

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

    @Override
    public void onSuccess(GetPnrs response) {
        mProgressLoader.dismissLoader();
        if (response.getStatus()) {
            SavedPnrHistoryAdapter adapter = new SavedPnrHistoryAdapter(getActivity(), response.getSavedPnrs());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            if(mCounter==0){
                Snackbar.make(getView(),R.string.saved_pnrs_message,Snackbar.LENGTH_SHORT).show();
                mCounter++;
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
}
