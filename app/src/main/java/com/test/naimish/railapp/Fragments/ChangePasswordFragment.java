package com.test.naimish.railapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.test.naimish.railapp.Models.ChangePassword;
import com.test.naimish.railapp.Network.ApiLayer;
import com.test.naimish.railapp.Network.RetrofitCallBack;
import com.test.naimish.railapp.R;
import com.test.naimish.railapp.Utils.RailAppConstants;
import com.test.naimish.railapp.Utils.ResponseListener;
import com.test.naimish.railapp.Utils.SharedPreference;
import com.test.naimish.railapp.Utils.Validations;
import com.test.naimish.railapp.Views.ProgressLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vivek on 3/9/2018.
 */

public class ChangePasswordFragment extends DialogFragment implements ResponseListener<ChangePassword> {
    private String mOldPassword;
    private String mNewPassword;
    private String mConfirmPassword;
    private ProgressLoader loader;

    @BindView(R.id.old_password)
    EditText oldPassword;
    @BindView(R.id.new_password)
    EditText newPassword;
    @BindView(R.id.comfirm_new_password)
    EditText confirmNewPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setLayout(100, 100);
        return inflater.inflate(R.layout.fragment_change_password, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loader = new ProgressLoader(getActivity());
    }

    @OnClick(R.id.comfirm_new_password_button)
    public void changePassword() {
        mNewPassword = newPassword.getText().toString();
        mConfirmPassword = confirmNewPassword.getText().toString();
        mOldPassword = oldPassword.getText().toString();
        newPassword.setError(null);
        oldPassword.setError(null);
        boolean killSwtich = false;
        View focusView = null;
        if (Validations.isEmpty(mOldPassword)) {
            oldPassword.setError(getResources().getString(R.string.password_error));
            killSwtich = true;
            focusView = oldPassword;
        }
        if (!Validations.checkPassword(mOldPassword)) {
            oldPassword.setError(getResources().getString(R.string.password_error));
            killSwtich = true;
            focusView = oldPassword;

        }
        if (!Validations.checkPassword(mNewPassword) || !Validations.checkPassword(mNewPassword, mConfirmPassword)) {
            newPassword.setError(getResources().getString(R.string.password_error));
            killSwtich = true;
            focusView = newPassword;

        }
        if (killSwtich)
            focusView.requestFocus();
        else {
            loader.showLoader();
            String userid = SharedPreference.getPreference(getContext(), RailAppConstants.USERID_CONSTANT);
            RetrofitCallBack<ChangePassword> callBack = new RetrofitCallBack<>(this);
            ApiLayer.getInterface().changePasssword(new ChangePassword(userid, mOldPassword, mNewPassword)).enqueue(callBack);
        }
    }


    @Override
    public void onSuccess(ChangePassword response) {
        loader.dismissLoader();
        if (response.isSuccess()) {
            getDialog().dismiss();
            Snackbar.make(getView(), R.string.change_password_msg, Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar.make(getView(), response.getMessage(), Snackbar.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailure(Throwable throwable) {
        loader.dismissLoader();
        Snackbar.make(getView(), throwable.getMessage().toString() + " " + R.string.try_again, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onNullResponse() {
        loader.dismissLoader();
        Snackbar.make(getView(), R.string.common_error, Snackbar.LENGTH_SHORT).show();
    }
}
