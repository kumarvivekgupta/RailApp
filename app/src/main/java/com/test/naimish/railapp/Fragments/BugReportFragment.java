package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;

import com.test.naimish.railapp.Models.ReportBug;
import com.test.naimish.railapp.Network.ReportBugNetwork.BugApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Utils.SharedPreference;
import com.test.naimish.railapp.Views.ProgressLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.test.naimish.railapp.Utils.RailAppConstants.EMAIL_CONSTANT;

/**
 * Created by Vivek on 5/10/2018.
 */

public class BugReportFragment extends RailAppFragment implements  ResponseListener<ReportBug>{
    private String messageBugReport;
    private ProgressLoader loader;

    @BindView(R.id.bug_report)
    EditText mBugReport;

    @Override
    protected int getResourceId() {
        return R.layout.fragment_report_bug;
    }

    public static BugReportFragment newInstance() {
        return new BugReportFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loader=new ProgressLoader(getContext());
    }

    @OnClick(R.id.send_bug_report)
    public void sendMessage(){
        messageBugReport=mBugReport.getText().toString();
        if(messageBugReport!=null) {
            loader.showLoader();
            BugApiClient bugApiClient = new BugApiClient(this);
            bugApiClient.reportBug( SharedPreference.getPreference(getContext(), EMAIL_CONSTANT).toString(),messageBugReport);
        }
        else
           Snackbar.make(getView(),R.string.empty_bug_message, Snackbar.LENGTH_SHORT).show();


    }

    @Override
    public void onSuccess(ReportBug response) {
        loader.dismissLoader();
        if(response.isBugSuccess())
        Snackbar.make(getView(), R.string.bug_reported_successfully, Snackbar.LENGTH_SHORT).show();
//        else
//            Snackbar.make(getView(), response.getUserEmailInfo(), Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void onFailure(Throwable throwable) {
        loader.dismissLoader();
        Snackbar.make(getView(), throwable.getMessage().toString() +" "+ R.string.try_again, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void onNullResponse() {
        loader.dismissLoader();
        Snackbar.make(getView(), R.string.common_error +" "+ R.string.try_again, Snackbar.LENGTH_SHORT).show();

    }
}
