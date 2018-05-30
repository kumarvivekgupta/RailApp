package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

import com.test.naimish.railapp.Models.PnrModel.BaseModel;
import com.test.naimish.railapp.Models.SeatAvailability.TrainSeatBaseModel;
import com.test.naimish.railapp.Models.StationAutoCompleteBaseModel;
import com.test.naimish.railapp.Network.SeatAvalibilityNetwork.SeatAvalibilityApiClient;
import com.test.naimish.railapp.Network.SeatAvalibilityNetwork.SeatAvalibilityApiInterface;
import com.test.naimish.railapp.Network.StationAutoCompleteNetwork.StationAutoCompleteApiClient;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Utils.SeatClassAndQuotaContants;
import com.test.naimish.railapp.Utils.StationAutoCompleteDetails;
import com.test.naimish.railapp.Utils.Validations;
import com.test.naimish.railapp.Views.ProgressLoader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vivek on 5/29/2018.
 */

public class SeatAvalibilityEnquiryFragment extends RailAppFragment implements ResponseListener<TrainSeatBaseModel>, StationAutoCompleteApiClient.stationAutoCompleteResponse {
    private String mSourceCode;
    private String mDestinationCode;
    private String mDate;
    private String mTrainNo;
    private String mTrainClassCode;
    private String mTrainQuota;
    private ArrayList<String> mClassCode;
    private ArrayList<String> mQuota;
    private ArrayList<String> mStationName;
    private ArrayList<String> mStationCode;


    private SeatAvalibilityApiClient mSeatAvalibilityApiClient;
    // private StationAutoCompleteApiClient mStationAutoCompleteApiClient;
    private ProgressLoader mLoader;

    @BindView(R.id.source_code)
    AutoCompleteTextView trainSourceCode;

    @BindView(R.id.destination_code)
    AutoCompleteTextView trainDestinationCode;

    @BindView(R.id.enter_train)
    EditText trainNo;

    @BindView(R.id.enter_date)
    EditText trainDate;

    @BindView(R.id.class_code)
    Spinner trainClassCode;

    @BindView(R.id.quota_code)
    Spinner trainQuota;
//
//    @BindView(R.id.source_code_spinner)
//    Spinner trainSourceCodeSpinner;
//
//    @BindView(R.id.destination_code_spinner)
//    Spinner trainDestinationCodeSpinner;

    @Override
    protected int getResourceId() {
        return R.layout.fragment_seat_enquiry;
    }

    public static Fragment newInstance() {
        return new SeatAvalibilityEnquiryFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        createClassCodeSpinnerDropdown();
        createQuotaCodeSpinnerDropdown();


    }

    @OnClick(R.id.submit_button)
    public void seatEnquiry() {
        mTrainNo = trainNo.getText().toString();
        mDate = trainDate.getText().toString();
        mSourceCode = trainSourceCode.getText().toString();
        mDestinationCode = trainDestinationCode.getText().toString();
        trainNo.setError(null);
        trainDate.setError(null);
        trainSourceCode.setError(null);
        trainDestinationCode.setError(null);


        View focusView = null;
        Boolean killSwitch = false;
        if (!Validations.isEmpty(mTrainNo) && Validations.checkTrainNo(mTrainNo)) {
            if (!Validations.isEmpty(mDate)) {
                if (!Validations.isEmpty(mSourceCode)) {
                    if (!Validations.isEmpty(mDestinationCode)) {
                        mSeatAvalibilityApiClient.seatAvalibilityStatus(mTrainNo, mSourceCode, mDestinationCode, mDate, mTrainClassCode, mTrainQuota);
                        mLoader.showLoader();
                    } else {
                        trainDestinationCode.setError("Enter Correct Code");
                        focusView = trainDestinationCode;
                        killSwitch = true;
                    }
                } else {
                    trainSourceCode.setError("Enter Correct Code");
                    focusView = trainSourceCode;
                    killSwitch = true;
                }

            } else {
                trainDate.setError("Enter Date Correctly");
                focusView = trainDate;
                killSwitch = true;

            }
        } else {
            trainNo.setError("Invalid train no");
            focusView = trainNo;
            killSwitch = true;
        }
        if (killSwitch) {
            if (focusView != null)
                focusView.requestFocus();
//            if (focusViewEmail != null)
//                focusViewEmail.requestFocus();

        }

    }

    private void createClassCodeSpinnerDropdown() {

        mClassCode = new ArrayList<>();
        mClassCode.addAll(SeatClassAndQuotaContants.addClassCode());
//        mClassCode.add("1A");
//        mClassCode.add("2A");
//        mClassCode.add("FC");
//        mClassCode.add("CC");
//        mClassCode.add("SL");
//        mClassCode.add("2S");


        ArrayAdapter<String> classCodeAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, mClassCode);
        classCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        trainClassCode.setAdapter(classCodeAdapter);
        trainClassCode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mTrainClassCode = mClassCode.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void createQuotaCodeSpinnerDropdown() {
        mQuota = new ArrayList<>();
        mQuota.addAll(SeatClassAndQuotaContants.addQuotaCode());
        ArrayAdapter<String> quotaAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, mQuota);
        quotaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        trainQuota.setAdapter(quotaAdapter);
        trainQuota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mTrainQuota = mQuota.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void createSourceCodeSpinnerDropdown(StationAutoCompleteBaseModel stationAutoCompleteBaseModel) {
        //  = new ArrayList<>();
        //   mQuota.addAll(SeatClassAndQuotaContants.addQuotaCode());
        //  trainSourceCodeSpinner.setVisibility(View.VISIBLE);

        StationAutoCompleteDetails stationAutoCompleteDetails = new StationAutoCompleteDetails();
        mStationName = stationAutoCompleteDetails.deatils(stationAutoCompleteBaseModel);
        //  mStationCode=stationAutoCompleteDetails.stationCode(stationAutoCompleteBaseModel);
        ArrayAdapter<String> sourceCodeAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, mStationName);
        sourceCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        trainSourceCode.setAdapter(sourceCodeAdapter);
        trainSourceCode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                trainSourceCode.setText(mStationName.get(i).substring((mStationName.indexOf('-') + 1), mStationName.get(i).length()));
                // trainSourceCodeSpinner.setVisibility(View.GONE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLoader = new ProgressLoader(getActivity());
        mSeatAvalibilityApiClient = new SeatAvalibilityApiClient(this);
        trainSourceCode.setThreshold(2);
        trainDestinationCode.setThreshold(2);
        trainSourceCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 3) {
//                    long startTime = System.currentTimeMillis();
//                    long elapsedTime = 0L;
//                    elapsedTime = (new Date()).getTime() - startTime;
//                    while (elapsedTime > 2 * 60 * 1000) {
                    StationAutoCompleteApiClient mStationAutoCompleteApiClient = new StationAutoCompleteApiClient(SeatAvalibilityEnquiryFragment.this);
                    mStationAutoCompleteApiClient.stationAutoCompleteInfo(s.toString());
                    //  createSourceCodeSpinnerDropdown();

                    // }

                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        trainDestinationCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 3) {
//                    long startTime = System.currentTimeMillis();
//                    long elapsedTime = 0L;
//                    elapsedTime = (new Date()).getTime() - startTime;
//                    while (elapsedTime > 2 * 60 * 1000) {
                    StationAutoCompleteApiClient mStationAutoCompleteApiClient = new StationAutoCompleteApiClient(SeatAvalibilityEnquiryFragment.this);
                    mStationAutoCompleteApiClient.stationAutoCompleteInfo(s.toString());

                    // }

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onSuccess(TrainSeatBaseModel response) {
        mLoader.dismissLoader();


    }

    @Override
    public void onFailure(Throwable throwable) {
        mLoader.dismissLoader();
        Snackbar.make(getView(), throwable.getMessage().toString() + " " + R.string.try_again, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void onNullResponse() {
        mLoader.dismissLoader();
        Snackbar.make(getView(), R.string.common_error + " " + R.string.try_again, Snackbar.LENGTH_SHORT).show();


    }

    @Override
    public void onResponce(StationAutoCompleteBaseModel stationAutoCompleteBaseModel) {
        createSourceCodeSpinnerDropdown(stationAutoCompleteBaseModel);
        createDestinationSpinnerDropdown(stationAutoCompleteBaseModel);
    }

    public void createDestinationSpinnerDropdown(StationAutoCompleteBaseModel stationAutoCompleteBaseModel) {
        //  = new ArrayList<>();
        //   mQuota.addAll(SeatClassAndQuotaContants.addQuotaCode());
        //  trainSourceCodeSpinner.setVisibility(View.VISIBLE);

        StationAutoCompleteDetails stationAutoCompleteDetails = new StationAutoCompleteDetails();
        mStationName = stationAutoCompleteDetails.deatils(stationAutoCompleteBaseModel);
        //  mStationCode=stationAutoCompleteDetails.stationCode(stationAutoCompleteBaseModel);
        ArrayAdapter<String> sourceCodeAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, mStationName);
        sourceCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        trainDestinationCode.setAdapter(sourceCodeAdapter);
        trainDestinationCode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                trainDestinationCode.setText(mStationName.get(i).substring((mStationName.indexOf('-') + 1), mStationName.get(i).length()));
                // trainSourceCodeSpinner.setVisibility(View.GONE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
}
